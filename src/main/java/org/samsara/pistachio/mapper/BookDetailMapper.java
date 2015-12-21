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

    /**
     * Insert a book detail entity to the database
     * @param record book detail entity
     * @return the status
     */
    boolean insert(BookDetail record);

    boolean insertSelective(BookDetail record);

    /**
     * Get the book detail entity by ISBN
     * @param ISBN ISBN
     * @return the entity
     */
    BookDetail getDetail(String ISBN);

    boolean updateByPrimaryKeySelective(BookDetail record);

    boolean update(BookDetail record);
}