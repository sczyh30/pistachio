package org.samsara.pistachio.mapper;

import org.samsara.pistachio.entity.BookDetail;

/**
 * Samsara Pistachio
 * Book detail mapper interface
 * @author sczyh30
 */
public interface BookDetailMapper {

    boolean remove(String ISBN);

    int insert(BookDetail record);

    int insertSelective(BookDetail record);

    BookDetail get(String ISBN);

    int updateByPrimaryKeySelective(BookDetail record);

    int update(BookDetail record);
}