package org.samsara.pistachio.controller;

import org.samsara.pistachio.entity.BookInfo;
import org.samsara.pistachio.entity.RequestError;
import org.samsara.pistachio.service.BookService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.List;

import static org.samsara.pistachio.Constant.*;

/**
 * Samsara Pistachio
 * Book controller
 * @author sczyh30
 */
@RestController
public class BookController {

    @Resource
    BookService service;

    /**
     * Route of getting book basic info by ISBN.<br>
     * URL:<pre><code>/api/book/{id}</code></pre><br>
     * Method: <strong>GET</strong>
     * @param id ISBN of the book
     * @return the book entity if ISBN exists and token is correct; else the request error
     */
    @RequestMapping(value = "/api/book/{id}")
    public Object getBookInfo(@PathVariable(value = "id") String id) {
        BookInfo book = service.getBook(id);
        System.out.println(book);
        if(book != null)
            return book;
        else
            return new RequestError(RE_CODE_BOOK_NOT_FOUND, RE_MSG_BOOK_NOT_FOUND, API_GET_BOOK_INFO + id);
    }

    /**
     * Route of getting latest books.<br>
     * URL:<pre><code>/api/book/latest</code></pre><br>
     * Method: <strong>GET</strong>
     * @return the book list
     */
    @RequestMapping(value = "/api/book/latest")
    public Object getLatest() {
        List<BookInfo> list = service.getLatestBook();
        if(list != null)
            return list;
        else
            return new RequestError(RE_CODE_BOOK_NOT_FOUND, RE_MSG_BOOK_NOT_FOUND, API_GET_BOOK_INFO);
    }
}
