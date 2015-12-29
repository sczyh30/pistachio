package org.samsara.pistachio.mapper;

import org.samsara.pistachio.entity.BorrowStatus;

import java.util.List;

/**
 * Samsara Pistachio
 * Book borrow status mapper interface
 * @author sczyh30
 */
public interface BorrowStatusMapper {

    /**
     * Insert a borrow record
     * @param record borrow record
     * @return the status
     */
    boolean insert(BorrowStatus record);

    /**
     * Get all borrow records by bid
     * @param bid borrow id
     * @return the status list
     */
    List<BorrowStatus> getAllRecordByBid(Integer bid);

    String getStatusMsg(Integer bid, String ISBN);

    BorrowStatus get(int bid, String ISBN);

    /**
     * Get all borrow records by ISBN
     * @param ISBN ISBN of the book
     * @return the status list
     */
    List<BorrowStatus> getAllRecordByISBN(String ISBN);

    boolean update(BorrowStatus record);

    boolean updateDay(int bid, String ISBN, String end, int due);

    /**
     * Remove borrow record by bid and ISBN
     * @param bid borrow id
     * @param ISBN ISBN of the book
     * @return if the process is successful; else false
     */
    boolean remove(Integer bid, String ISBN);

    boolean updateSelective(BorrowStatus record);
}