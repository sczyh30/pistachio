package org.samsara.pistachio.service;

import org.samsara.pistachio.entity.BookInfo;
import org.samsara.pistachio.mapper.BookInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Samsara Pistachio Service
 * Book service
 * @author sczyh30
 */
@Service(value = "bookService")
public class BookService {

    @Resource
    private BookInfoMapper infoMapper;

    /**
     * Add a book to the database
     * @param bookInfo the BookInfo entity
     * @return true if insert process is successful; else false
     */
    public boolean addBook(BookInfo bookInfo) {
        return infoMapper.insert(bookInfo);
    }

    /**
     * Get the basic book info by ISBN
     * @param ISBN ISBN of the book
     * @return the BookInfo entity
     */
    public BookInfo getBook(Integer ISBN) {
        return infoMapper.get(ISBN);
    }

    /**
     * Get the basic book info by book name
     * @param name name of the book
     * @return the BookInfo entity
     */
    public BookInfo getBookByName(String name) {
        return infoMapper.getByName(name);
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
     * @return true if remove process is successful; else false
     */
    public boolean removeBook(Integer ISBN) {
        return infoMapper.remove(ISBN);
    }



}
