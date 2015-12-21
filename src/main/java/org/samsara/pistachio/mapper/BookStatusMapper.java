package org.samsara.pistachio.mapper;

import org.samsara.pistachio.entity.BookStatus;

/**
 * Samsara Pistachio
 * Book status mapper interface
 * @author sczyh30
 */
public interface BookStatusMapper {

    boolean remove(String isbn);

    boolean insert(BookStatus record);

    BookStatus getStatus(String isbn);

    int updateByPrimaryKeySelective(BookStatus record);

    boolean update(BookStatus record);

    /**
     * Process of borrowing a book<br>
     *
     * @param ISBN ISBN of the book
     * @return status
     */
    boolean borrow(String ISBN);

    /**
     * Process of returning a book<br>
     *
     * @param ISBN ISBN of the book
     * @return status
     */
    boolean ret(String ISBN);

    /**
     * Get the entire quantity of the book
     * @param ISBN ISBN of the book
     * @return the entire quantity of the book
     */
    int getEntire(String ISBN);

    /**
     * Get the present quantity of the book
     * @param ISBN ISBN of the book
     * @return the present quantity of the book, 0 if empty
     */
    int getPresent(String ISBN);
}