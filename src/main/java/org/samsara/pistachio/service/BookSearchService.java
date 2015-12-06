package org.samsara.pistachio.service;

import org.samsara.pistachio.entity.BookInfo;
import org.samsara.pistachio.mapper.BookInfoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Samsara Pistachio Service
 * Book search service
 * @author sczyh30
 */
@Service(value = "bookSearchService")
public class BookSearchService {

    @Resource
    private BookInfoMapper infoMapper;

    public List<BookInfo> getAllBooksByAuthor(String author) {
        return infoMapper.getAllByAuthor(author);
    }

    public List<String> getAllNameByAuthor(String author) {
        return infoMapper.getAllNameByAuthor(author);
    }
}
