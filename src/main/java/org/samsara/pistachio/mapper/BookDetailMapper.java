package org.samsara.pistachio.mapper;

import org.samsara.pistachio.entity.BookDetail;

/**
 * Samsara Pistachio
 * Book detail mapper interface
 * @author sczyh30
 */
public interface BookDetailMapper {

    boolean remove(Integer isbn);

    int insert(BookDetail record);

    int insertSelective(BookDetail record);

    BookDetail get(Integer isbn);

    int updateByPrimaryKeySelective(BookDetail record);

    int update(BookDetail record);
}