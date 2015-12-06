package org.samsara.pistachio.mapper;

import org.samsara.pistachio.entity.BookInfo;

import java.util.List;

/**
 * Samsara Pistachio
 * Book info interface
 * @author sczyh30
 */
public interface BookInfoMapper {

    boolean remove(Integer isbn);

    boolean insert(BookInfo book);

    int insertSelective(BookInfo book);

    /**
     * Get the book info object by ISBN
     * @param isbn ISBN of the book
     * @return the book info entity
     */
    BookInfo get(Integer isbn);

    BookInfo getByName(String name);

    List<BookInfo> getAllByAuthor(String author);

    List<String> getAllNameByAuthor(String author);

    int updateByPrimaryKeySelective(BookInfo record);

    boolean update(BookInfo record);
}