package org.samsara.pistachio.mapper;

import org.samsara.pistachio.entity.BookDetail;

/**
 * Samsara Pistachio
 * Book detail mapper interface
 * @author sczyh30
 */
public interface BookDetailMapper {
    int deleteByPrimaryKey(String isbn);

    int insert(BookDetail record);

    int insertSelective(BookDetail record);

    BookDetail selectByPrimaryKey(String isbn);

    int updateByPrimaryKeySelective(BookDetail record);

    int updateByPrimaryKey(BookDetail record);
}