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

    public BookInfo getBook(String ISBN) {
        return infoMapper.get(ISBN);
    }

}
