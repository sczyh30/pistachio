package org.samsara.pistachio.controller;

import org.samsara.pistachio.entity.ProcessStatus;
import org.samsara.pistachio.service.BorrowService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

import static org.samsara.pistachio.Constant.*;

/**
 * Samsara Pistachio
 * Book borrow controller
 * @author sczyh30
 */
@RestController
public class BookBorrowController {

    @Resource
    BorrowService borrowService;

    /**
     * Route of borrowing a book
     * @param id ISBN of the book
     * @param bid borrow id of the user
     * @return if parameters are appropriate, return the status callback; else return error code.
     */
    @RequestMapping(value = "/api/book/borrow/{id}", method = RequestMethod.POST)
    public Object borrowBook(@PathVariable(value = "id") String id,
                             @RequestParam(value = "bid") int bid,
                             @RequestParam(value = "from") String from,
                             @RequestParam(value = "due") int due) {

        return new ProcessStatus(RE_CODE_BOOK_BORROW_ERROR, "", RE_MSG_BOOK_BORROW_ERROR);
    }

    /**
     * Route of returning a book
     * @param id ISBN of the book
     * @param bid borrow id of the user
     * @return if parameters are appropriate, return the status callback; else return error code.
     */
    @RequestMapping(value = "/api/book/ret/{id}", method = RequestMethod.POST)
    public Object returnBook(@PathVariable(value = "id") String id,
                             @RequestParam(value = "bid") int bid) {
        return new ProcessStatus(RE_CODE_BOOK_BORROW_ERROR, "", RE_MSG_BOOK_BORROW_ERROR);
    }


}
