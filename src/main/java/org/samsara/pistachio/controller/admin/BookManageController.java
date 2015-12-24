package org.samsara.pistachio.controller.admin;

import org.samsara.pistachio.entity.BookInfo;
import org.samsara.pistachio.entity.ProcessStatus;
import org.samsara.pistachio.entity.RequestError;
import org.samsara.pistachio.service.BookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Date;

/**
 * Samsara Pistachio
 * Book management controller<br>
 * Only auth for admin role
 * @author sczyh30
 */
@RestController
public class BookManageController {

    @Resource
    BookService bookService;

    /**
     * Route of removing a book entity<br>
     * URL:<code>/adm1n666/book/:id</code><br>
     * Method: <strong>DELETE</strong>
     * @param id ISBN of book
     * @return the process status
     */
    @RequestMapping(value = "/adm1n666/book/{id}", method = RequestMethod.DELETE)
    public Object removeBook(@PathVariable(value = "id") String id) {
        return bookService.retAndRecord(bookService.removeBook(id), 6);
    }

    /**
     * Route of adding a book to the database<br>
     * URL:<code>/adm1n666/add/book/:id</code><br>
     * Method: <strong>PUT</strong>
     * @param id ISBN of the book
     * @param name name of the book
     * @param author author of the book
     * @param pubd release date of the book
     * @param publ publisher of the book
     * @param page page number of the book
     * @param cid category id of the book
     * @return the process status
     */
    @RequestMapping(value = "/adm1n666/add/book/{id}", method = RequestMethod.PUT)
    public Object insertBook(@PathVariable(value = "id") String id,
                             //@RequestParam(value = "ISBN") String ISBN,
                             @RequestParam(value = "name") String name,
                             @RequestParam(value = "author") String author,
                             @RequestParam(value = "pubd") Date pubd,
                             @RequestParam(value = "publ") String publ,
                             @RequestParam(value = "page") int page,
                             @RequestParam(value = "cid") int cid) {
        BookInfo info = new BookInfo(id, name, author, pubd, publ, page, cid);
        return bookService.retAndRecord(bookService.addBook(info), 6);
    }

    /**
     * Route of updating the book info<br>
     * URL:<code>/adm1n666/update/book/:id</code><br>
     * Method: <strong>PUT</strong>
     * @param id ISBN of the book
     * @param name name of the book
     * @param author author of the book
     * @param pubd release date of the book
     * @param publ publisher of the book
     * @param page page number of the book
     * @param cid category id of the book
     * @return the process status
     */
    @RequestMapping(value = "/adm1n666/update/book/{id}", method = RequestMethod.PUT)
    public Object updateBook(@PathVariable(value = "id") String id,
                             @RequestParam(value = "name") String name,
                             @RequestParam(value = "author") String author,
                             @RequestParam(value = "pubd") Date pubd,
                             @RequestParam(value = "publ") String publ,
                             @RequestParam(value = "page") int page,
                             @RequestParam(value = "cid") int cid) {
        BookInfo info = new BookInfo(id, name, author, pubd, publ, page, cid);
        return bookService.retAndRecord(bookService.updateBook(info), 6);
    }
}
