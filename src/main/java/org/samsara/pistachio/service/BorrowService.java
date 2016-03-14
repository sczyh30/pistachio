package org.samsara.pistachio.service;

import org.samsara.pistachio.entity.BookStatus;
import org.samsara.pistachio.entity.BorrowStatus;
import org.samsara.pistachio.entity.ProcessStatus;
import org.samsara.pistachio.mapper.BookStatusMapper;
import org.samsara.pistachio.mapper.BorrowStatusMapper;
import org.samsara.pistachio.mapper.ProcessStatusMapper;
import org.samsara.pistachio.security.TokenGenerator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static org.samsara.pistachio.Constant.*;

/**
 * Samsara Pistachio Service
 * Book borrow service
 * @author sczyh30
 */
@Service(value = "borrowService")
public class BorrowService {

    @Resource
    protected BorrowStatusMapper userBorrowMapper;

    @Resource
    protected BookStatusMapper bookBorrowMapper;

    @Resource
    protected ProcessStatusMapper processStatusMapper;

    public ProcessStatus retAndRecord(int bid, int code) {
        ProcessStatus status = generateStatus(bid, code);
        processStatusMapper.insert(status);
        return status;
    }

    /**
     * Generate the process record entity
     * @param bid borrow id
     * @param code req_code
     * @return the process record entity
     */
    public ProcessStatus generateStatus(int bid, int code) {
        String psid = TokenGenerator.generate(bid,code);
        switch (code) {
            case BOOK_BRS_PROCESS_SUCCESS:
                return new ProcessStatus(BOOK_BRS_PROCESS_SUCCESS, psid, "process_ok");
            case BOOK_BRS_PROCESS_FAILURE:
                return new ProcessStatus(BOOK_BRS_PROCESS_FAILURE, psid, "process_fail");
            case BOOK_BORROWING_DUPLICATE:
                return new ProcessStatus(BOOK_BORROWING_DUPLICATE, psid, "process_borrow_duplicate_borrow");
            case BOOK_BORROWING_EMPTY_NO_PRESENT:
                return new ProcessStatus(BOOK_BORROWING_EMPTY_NO_PRESENT, psid, "process_borrow_book_empty_now");
            case BOOK_USER_ENTRY_NOT_BORROWED:
                return new ProcessStatus(BOOK_USER_ENTRY_NOT_BORROWED, psid, "process_borrow_user_not_borrowed");
            case -1:
                return new ProcessStatus(-1, psid, "book_entry_error");
            default:
                return new ProcessStatus(4607, psid, "unknown_process");
        }
    }

    /**
     * Wrap the entity from the parameter then borrow
     * @param bid borrow id
     * @param ISBN book of ISBN
     * @param start start time
     * @param end end time
     * @param due due days
     * @return the status
     */
    public int borrowBook(int bid, String ISBN, String start, String end, int due) {
        // wrap the object
        BorrowStatus borrowStatus = new BorrowStatus(bid, ISBN, BRS_STATUS_CODE_IS,
                start, end, due, BRS_STATUS_IS);
        return borrowBook(ISBN, bid, borrowStatus);
    }


    /**
     * Borrow a book<br>
     *
     * @param ISBN ISBN of the book
     * @param bid borrow id of the user
     * @return the status
     */
    public int borrowBook(String ISBN, int bid, BorrowStatus entity) {
        int num = bookBorrowMapper.getPresent(ISBN);
        if(num < 0)
            return -1;
        if(num > 0) {
            BorrowStatus current = userBorrowMapper.get(bid, ISBN);
            System.out.println(current);
            if(current == null) { // no record, insert
                return userBorrowMapper.insert(entity) && bookBorrowMapper.borrow(ISBN, num)?
                        BOOK_BRS_PROCESS_SUCCESS : BOOK_BRS_PROCESS_FAILURE;
            }
            /*else if(current.getStatus() != BRS_STATUS_CODE_IS) {
                return userBorrowMapper.update(ISBN, entity) && bookBorrowMapper.borrow(ISBN, num)?
                        BOOK_BRS_PROCESS_SUCCESS : BOOK_BRS_PROCESS_FAILURE;
            }*/
            else { // return duplicate error msg
                return BOOK_BORROWING_DUPLICATE;
            }
        } else
            return BOOK_BORROWING_EMPTY_NO_PRESENT;
    }

    /**
     * Return a book borrowed from the system<br>
     * @param ISBN ISBN of the book
     * @param bid borrow id of the user
     * @return the status
     */
    public int retBook(String ISBN, int bid) {
        BorrowStatus current = userBorrowMapper.get(bid, ISBN);
        if(current == null) {
            return BOOK_USER_ENTRY_NOT_BORROWED;
        }
        int num = bookBorrowMapper.getPresent(ISBN);
        if(num < 0)
            return -1;
        if(num == 0) {
            // notify the subscriber
        }
        // verify data

        if(current.getStatus() == BRS_STATUS_CODE_IS) {
            // this is ok
            current.setStatus(BRS_STATUS_CODE_NO);
            //return userBorrowMapper.update(ISBN, current) && bookBorrowMapper.ret(ISBN, num) ?
            return userBorrowMapper.remove(bid, ISBN) && bookBorrowMapper.ret(ISBN, num) ?
                    BOOK_BRS_PROCESS_SUCCESS : BOOK_BRS_PROCESS_FAILURE;
        }
        else if(current.getStatus() == BRS_STATUS_CODE_OVERDUE) {
            // TODO:fire!
            current.setStatus(BRS_STATUS_CODE_NO);
            return userBorrowMapper.remove(bid, ISBN) && bookBorrowMapper.ret(ISBN, num) ?
                    BOOK_BRS_PROCESS_SUCCESS : BOOK_BRS_PROCESS_FAILURE;
        }
        else {
            return BOOK_USER_ENTRY_NOT_BORROWED;
        }
    }



}
