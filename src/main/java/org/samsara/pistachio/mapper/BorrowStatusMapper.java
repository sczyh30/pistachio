package org.samsara.pistachio.mapper;

import org.samsara.pistachio.entity.BorrowStatus;

/**
 * Samsara Pistachio
 * Book borrow status mapper interface
 * @author sczyh30
 */
public interface BorrowStatusMapper {

    /**
     * Remove all borrow status record by bid
     * @param bid borrow id
     * @return if the process is successful; else false
     */
    boolean remove(Integer bid, String ISBN);

    int insert(BorrowStatus record);

    int insertSelective(BorrowStatus record);

    BorrowStatus selectByPrimaryKey(Integer bid);

    int updateByPrimaryKeySelective(BorrowStatus record);

    int updateByPrimaryKey(BorrowStatus record);
}