package org.samsara.pistachio.mapper;

import org.samsara.pistachio.entity.BookCategory;

/**
 * Samsara Pistachio
 * Book category mapper interface
 * @author sczyh30
 */
public interface BookCategoryMapper {

    /**
     * Remove the target category by category id(cid)
     * @param cid category id
     * @return if the process is ok
     */
    int remove(Integer cid);

    int insert(BookCategory record);

    int insertSelective(BookCategory record);

    BookCategory get(Integer cid);

    int updateByPrimaryKeySelective(BookCategory record);

    int update(BookCategory record);
}