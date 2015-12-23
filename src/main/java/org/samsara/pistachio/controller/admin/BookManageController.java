package org.samsara.pistachio.controller.admin;

import org.samsara.pistachio.entity.BookInfo;
import org.samsara.pistachio.entity.ProcessStatus;
import org.samsara.pistachio.entity.RequestError;
import org.samsara.pistachio.security.TokenGenerator;
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

    @RequestMapping(value = "/adm1n666/book/{id}", method = RequestMethod.DELETE)
    public Object removeBook(@PathVariable(value = "id") String id) {
        return bookService.wrap(bookService.removeBook(id), 6);
    }

    @RequestMapping(value = "/adm1n666/add/book/{id}", method = RequestMethod.PUT)
    public Object insertBook(@PathVariable(value = "id") String id,
                             @RequestParam(value = "ISBN") String ISBN,
                             @RequestParam(value = "name") String name,
                             @RequestParam(value = "author") String author,
                             @RequestParam(value = "pubd") Date pubd,
                             @RequestParam(value = "publ") String publ,
                             @RequestParam(value = "page") int page,
                             @RequestParam(value = "cid") int cid) {
        BookInfo info = new BookInfo()
        return bookService.wrap()
    }

    @RequestMapping(value = "/adm1n666/update/book/{id}", method = RequestMethod.PUT)
    public Object updateBook(@PathVariable(value = "id") String id) {

        return new RequestError();
    }
}
