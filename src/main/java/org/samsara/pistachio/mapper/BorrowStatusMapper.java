package org.samsara.pistachio.mapper;

import org.samsara.pistachio.entity.BorrowStatus;

/**
 * Samsara Pistachio
 * Book borrow status mapper interface
 * @author sczyh30
 */
public interface BorrowStatusMapper {
    int deleteByPrimaryKey(Integer bid);

    boolean remove(Integer bid, String ISBN);

    int insert(BorrowStatus record);

    int insertSelective(BorrowStatus record);

    BorrowStatus selectByPrimaryKey(Integer bid);

    int updateByPrimaryKeySelective(BorrowStatus record);

    int updateByPrimaryKey(BorrowStatus record);
}