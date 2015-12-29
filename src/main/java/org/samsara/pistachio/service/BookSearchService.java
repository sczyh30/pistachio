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

    public BookInfo getByName(String name) {
        return infoMapper.getByName(name);
    }

    /**
     * Get all books by author name
     * @param author distinct name of author
     * @return the query result
     */
    public List<BookInfo> getAllBooksByAuthor(String author) {
        return infoMapper.getAllByAuthor(author);
    }
    /**
     * Get all names of book by author name
     * @param author distinct name of author
     * @return the query result
     */
    public List<String> getAllNamesByAuthor(String author) {
        return infoMapper.getAllNameByAuthor(author);
    }

    // TODO: NEED HIGHER PERFORMANCE!!!!
    /**
     * Get all books by author name (vague query)<br>
     * WARNING: this process could consume high because it can
     * make use of the index of the database.<br>
     * Next version, we will use Solr to achieve this
     * @param vague vague name of author
     * @return the query result
     */
    public List<BookInfo> getAllBooksByVgAuthor(String vague) {
        return infoMapper.getAllByVgAuthor(vague);
    }

    /**
     * Get all books by book name (vague query)<br>
     * WARNING: this process could consume high because it can
     * make use of the index of the database.<br>
     * Next version, we will use Solr to achieve this
     * @param vague vague name of book
     * @return the query result
     */
    public List<BookInfo> getAllBooksByVgName(String vague) {
        return infoMapper.getAllByVgName(vague);
    }
}
