package org.samsara.pistachio.mapper;

import org.samsara.pistachio.entity.BookDetail;

/**
 * Samsara Pistachio
 * Book detail mapper interface
 * @author sczyh30
 */
public interface BookDetailMapper {

    /**
     * Remove a book detail entry from the database
     * @param ISBN ISBN of the book
     * @return the status
     */
    boolean remove(String ISBN);

    int insert(BookDetail record);

    int insertSelective(BookDetail record);

    BookDetail getDetail(String ISBN);

    int updateByPrimaryKeySelective(BookDetail record);

    int update(BookDetail record);
}