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
     * @return true if the process is successful; else false.
     */
    int remove(Integer cid);

    /**
     * Add a category to the database
     * @param category category entity
     * @return true if the process is successful; else false.
     */
    int add(BookCategory category);

    int insertSelective(BookCategory category);

    /**
     * Get the category entity by category id(cid)
     * @param cid category id
     * @return the category entity
     */
    BookCategory get(Integer cid);

    /**
     * Get the category name by category id(cid)
     * @param cid category id
     * @return category name
     */
    String getName(Integer cid);

    /**
     * Update the category record in the database
     * @param record the category entity that shall update
     * @return true if the process is successful; else false.
     */
    int update(BookCategory record);
}