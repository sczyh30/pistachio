package org.samsara.pistachio.mapper;

import org.samsara.pistachio.entity.BookStatus;

/**
 * Samsara Pistachio
 * Book status mapper interface
 * @author sczyh30
 */
public interface BookStatusMapper {

    boolean remove(Integer isbn);

    boolean insert(BookStatus record);

    BookStatus getStatus(Integer isbn);

    int updateByPrimaryKeySelective(BookStatus record);

    boolean update(BookStatus record);

    /**
     * Process of borrowing a book<br>
     *
     * @param ISBN ISBN of the book
     * @return status
     */
    boolean borrow(Integer ISBN);

    /**
     * Process of returning a book<br>
     *
     * @param ISBN ISBN of the book
     * @return status
     */
    boolean ret(Integer ISBN);

    /**
     * Get the entire quantity of the book
     * @param ISBN ISBN of the book
     * @return the entire quantity of the book
     */
    int getEntire(Integer ISBN);

    /**
     * Get the present quantity of the book
     * @param ISBN ISBN of the book
     * @return the present quantity of the book, 0 if empty
     */
    int getPresent(Integer ISBN);
}