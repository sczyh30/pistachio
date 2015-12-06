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

    @RequestMapping(value = "/api/book/{id}", method = RequestMethod.PUT)
    public Object borrowBook(@PathVariable(value = "id") String id,
                             @RequestParam(value = "bid") int bid) {
        return new ProcessStatus(RE_CODE_BOOK_BORROW_ERROR, RE_MSG_BOOK_BORROW_ERROR);
    }
}
