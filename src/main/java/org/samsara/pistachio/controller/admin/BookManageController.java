package org.samsara.pistachio.controller.admin;

import org.samsara.pistachio.entity.ProcessStatus;
import org.samsara.pistachio.entity.RequestError;
import org.samsara.pistachio.service.BookService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
        if (bookService.removeBook(id)) {
            return new ProcessStatus(1006, "", "process_successful");
        }
        return new RequestError();
    }

    @RequestMapping(value = "/adm1n666/add/book/{id}", method = RequestMethod.PUT)
    public Object insertBook(@PathVariable(value = "id") String id) {

        return new RequestError();
    }

    @RequestMapping(value = "/adm1n666/update/book/{id}", method = RequestMethod.PUT)
    public Object updateBook(@PathVariable(value = "id") String id) {

        return new RequestError();
    }
}
