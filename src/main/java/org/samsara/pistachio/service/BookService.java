package org.samsara.pistachio.service;

import org.samsara.pistachio.cache.RedisCacheService;
import org.samsara.pistachio.entity.BookInfo;
import org.samsara.pistachio.entity.BookStatus;
import org.samsara.pistachio.entity.ProcessStatus;
import org.samsara.pistachio.mapper.BookInfoMapper;
import org.samsara.pistachio.mapper.BookStatusMapper;
import org.samsara.pistachio.mapper.ProcessStatusMapper;
import org.samsara.pistachio.security.TokenGenerator;
import org.samsara.pistachio.util.DateUtil;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

import static org.samsara.pistachio.Constant.*;

/**
 * Samsara Pistachio Service
 * Book service
 * @author sczyh30
 */
@Service(value = "bookService")
public class BookService {

    protected static final int NUM_PER_PAGE_DEFAULT = 15;

    @Resource
    protected BookInfoMapper infoMapper;

    @Resource
    protected BookStatusMapper statusMapper;

    @Resource
    protected ProcessStatusMapper processStatusMapper;

    /** cache service */
    protected RedisCacheService cacheService = RedisCacheService.getService();

    /**
     * Insert the process entity and then return to next func
     * @param code process code
     * @param id user id
     * @return the process entity
     */
    public ProcessStatus retAndRecord(int code, int id) {
        ProcessStatus status = wrap(code, id);
        processStatusMapper.insert(status);
        return status;
    }

    /**
     * Wrap and yield the process entity
     * @param code process code
     * @param id user id
     * @return the process entity
     */
    public ProcessStatus wrap(int code, int id) {
        String psid = TokenGenerator.generate(667788, code); // 667788 is a magic number
        Timestamp timestamp = DateUtil.getStamp();
        //System.out.println(timestamp);
        switch (code) {
            case BOOK_INFO_REMOVE_SUCCESS:
                return new ProcessStatus(code, psid, "book_info_remove_success", API_PROCESS_LEVEL_ADMIN, id, timestamp);
            case BOOK_INFO_ADD_SUCCESS:
                return new ProcessStatus(code, psid, "book_info_add_success", API_PROCESS_LEVEL_ADMIN, id, timestamp);
            case BOOK_INFO_UPDATE_SUCCESS:
                return new ProcessStatus(code, psid, "book_info_update_success", API_PROCESS_LEVEL_ADMIN, id, timestamp);
            case BOOK_INFO_PROCESS_FAILURE:
                return new ProcessStatus(code, psid, "book_info_process_error", API_PROCESS_LEVEL_ADMIN, id, timestamp);
            case BOOK_INFO_INSERT_DUPLICATE:
                return new ProcessStatus(code, psid, "book_info_insert_duplicate", API_PROCESS_LEVEL_ADMIN, id, timestamp);

            default:
                return new ProcessStatus(4606, psid, "book_process_unknown", API_PROCESS_LEVEL_NO, id, timestamp);
        }
    }

    /**
     * Get the book status entity by ISBN
     * @param ISBN ISBN of the book
     * @return the book status entity
     */
    public BookStatus getStatus(String ISBN) {
        return statusMapper.getStatus(ISBN);
    }

    /**
     * Add a book to the database
     * @param bookInfo the BookInfo entity
     * @return true if insert process is successful; else false
     */
    public int addBook(BookInfo bookInfo) {
        try {
            return infoMapper.insert(bookInfo) ? BOOK_INFO_ADD_SUCCESS : BOOK_INFO_PROCESS_FAILURE;
        } catch (Exception e) {
            return BOOK_INFO_INSERT_DUPLICATE;
        }
    }

    /**
     * Get the book info by ISBN
     * @param ISBN ISBN of the book
     * @return the BookInfo entity
     */
    @Transactional(readOnly = true)
    public Object getBook(String ISBN) {
        String field = wrapCacheField(ISBN);
        // if cached, return the cached object
        if(cacheService.isHCached(CACHE_BOOK_KEY, field)) {
            // TODO: this can directly return String, not necessary to warp; but need Spring MVC support
            return cacheService.hGetCacheObj(CACHE_BOOK_KEY, field, BookInfo.class);
        }
        else {
            BookInfo book = infoMapper.get(ISBN);
            if(book != null)
                cacheService.hCacheObj(CACHE_BOOK_KEY, field, book);
            return book;
        }

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
     * Get the latest books by limit(start, default = 15)
     * @param start start pos
     * @return list of books
     */
    @Transactional(readOnly = true)
    public List<BookInfo> getBooksLimit(int start) {
        return infoMapper.getBooksLimit(start, NUM_PER_PAGE_DEFAULT);
    }

    /**
     * Get the latest books by limit(start, page)
     * @param start start pos
     * @param n entry num per page
     * @return list of books
     */
    @Transactional(readOnly = true)
    public List<BookInfo> getBooksLimit(int start, int n) {
        return infoMapper.getBooksLimit(start, n);
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
    public int updateBook(BookInfo bookInfo) {
        //int status = infoMapper.update(bookInfo) ? BOOK_INFO_UPDATE_SUCCESS : BOOK_INFO_PROCESS_FAILURE;
        if (infoMapper.update(bookInfo)) {
            // if successfully updated, cache the obj
            cacheService.hCacheObj(CACHE_BOOK_KEY, wrapCacheField(bookInfo.getISBN()),
                    bookInfo);
            return BOOK_INFO_UPDATE_SUCCESS;
        }

        return BOOK_INFO_PROCESS_FAILURE;
    }

    /**
     * Remove the book from the database.<br>
     * Because the database correlation map is <strong>cascade</strong>, the book detail entity,
     * book status entity will automatically be removed.
     * @param ISBN ISBN of the book
     * @return the status code
     */
    public int removeBook(String ISBN) {
        // remove cache
        cacheService.delCache(wrapCacheField(ISBN));
        return infoMapper.remove(ISBN) ? BOOK_INFO_REMOVE_SUCCESS : BOOK_INFO_PROCESS_FAILURE;
    }

    /**
     * Wrap the ISBN to cache key
     * Format:<em>BOOK_ISBN</em>
     * @param ISBN ISBN
     * @return the wrapped cache field
     */
    private String wrapCacheField(String ISBN) {
        return "BOOK_" + ISBN;
    }


}
