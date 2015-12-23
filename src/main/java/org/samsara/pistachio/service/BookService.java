package org.samsara.pistachio.service;

import org.samsara.pistachio.entity.BookInfo;
import org.samsara.pistachio.entity.BookStatus;
import org.samsara.pistachio.entity.ProcessStatus;
import org.samsara.pistachio.mapper.BookInfoMapper;
import org.samsara.pistachio.mapper.BookStatusMapper;
import org.samsara.pistachio.security.TokenGenerator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

import static org.samsara.pistachio.Constant.*;

/**
 * Samsara Pistachio Service
 * Book service
 * @author sczyh30
 */
@Service(value = "bookService")
public class BookService {

    @Resource
    private BookInfoMapper infoMapper;

    @Resource
    private BookStatusMapper statusMapper;

    public ProcessStatus wrap(int code, int id) {
        String psid = TokenGenerator.generate(667788, code); // 667788 is a magic number
        switch (code) {
            case BOOK_INFO_REMOVE_SUCCESS:
                return new ProcessStatus(code, psid, "book_info_remove_success", API_PROCESS_LEVEL_ADMIN, id);
            case BOOK_INFO_ADD_SUCCESS:
                return new ProcessStatus(code, psid, "book_info_add_success", API_PROCESS_LEVEL_ADMIN, id);
            case BOOK_INFO_UPDATE_SUCCESS:
                return new ProcessStatus(code, psid, "book_info_update_success", API_PROCESS_LEVEL_ADMIN, id);
            case BOOK_INFO_PROCESS_FAILURE:
                return new ProcessStatus(code, psid, "book_info_process_error", API_PROCESS_LEVEL_ADMIN, id);
            default:
                return new ProcessStatus(4606, psid, "book_process_unknown", API_PROCESS_LEVEL_NO, id);
        }
    }

    public BookStatus getStatus(String ISBN) {
        return statusMapper.getStatus(ISBN);
    }

    /**
     * Add a book to the database
     * @param bookInfo the BookInfo entity
     * @return true if insert process is successful; else false
     */
    public int addBook(BookInfo bookInfo) {
        return infoMapper.insert(bookInfo) ? BOOK_INFO_ADD_SUCCESS : BOOK_INFO_PROCESS_FAILURE;
    }

    /**
     * Get the book info by ISBN
     * @param ISBN ISBN of the book
     * @return the BookInfo entity
     */
    @Transactional(readOnly = true)
    public BookInfo getBook(String ISBN) {
        return infoMapper.get(ISBN);
    }

    /**
     * Get latest books
     * @return list of the books
     */
    @Transactional(readOnly = true)
    public List<BookInfo> getLatestBook() {
        return infoMapper.getLatest();
    }

    /**
     * Get the book info by book name
     * @param name name of the book
     * @return the BookInfo entity
     */
    @Transactional(readOnly = true)
    public BookInfo getBookByName(String name) {
        return infoMapper.getByName(name);
    }

    /**
     * Get all books by the author
     * @param author the author name
     * @return list of the books
     */
    @Transactional(readOnly = true)
    public List<BookInfo> getAllBooksByAuthor(String author) {
        return infoMapper.getAllByAuthor(author);
    }

    /**
     * Update the book info by ISBN
     * @param bookInfo the BookInfo entity
     * @return true if update process is successful; else false
     */
    public boolean updateBook(BookInfo bookInfo) {
        return infoMapper.update(bookInfo);
    }

    /**
     * Remove the book from the database.<br>
     * Because the database correlation map is <strong>cascade</strong>, the book detail entity,
     * book status entity will automatically be removed.
     * @param ISBN ISBN of the book
     * @return the status code
     */
    public int removeBook(String ISBN) {
        return infoMapper.remove(ISBN) ? BOOK_INFO_PROCESS_FAILURE : BOOK_INFO_REMOVE_SUCCESS;
    }



}
