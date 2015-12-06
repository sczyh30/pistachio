package org.samsara.pistachio.mapper;

import org.samsara.pistachio.entity.BookStatus;

/**
 * Samsara Pistachio
 * Book status mapper interface
 * @author sczyh30
 */
public interface BookStatusMapper {
    int deleteByPrimaryKey(Integer isbn);

    int insert(BookStatus record);

    int insertSelective(BookStatus record);

    BookStatus selectByPrimaryKey(Integer isbn);

    int updateByPrimaryKeySelective(BookStatus record);

    int updateByPrimaryKey(BookStatus record);
}