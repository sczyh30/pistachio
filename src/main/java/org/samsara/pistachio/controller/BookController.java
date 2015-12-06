package org.samsara.pistachio.controller;

import org.samsara.pistachio.entity.BookInfo;
import org.samsara.pistachio.entity.RequestError;
import org.samsara.pistachio.service.BookService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
     * URL:<code>/api/book/{id}</code><br>
     * Method:<strong>PUT</strong>
     * @param id ISBN of the book
     * @return the book entity if ISBN exists and token is correct; else the request error
     */
    @RequestMapping(value = "/api/book/{id}")
    public Object getBookInfo(@PathVariable(value = "id") String id) {
        BookInfo book = service.getBook(id);
        if(book != null)
            return book;
        else
            return new RequestError(RE_CODE_BOOK_NOT_FOUND, RE_MSG_BOOK_NOT_FOUND, API_GET_BOOK_INFO + id);
    }
}
