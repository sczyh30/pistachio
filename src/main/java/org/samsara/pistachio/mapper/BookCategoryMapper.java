package org.samsara.pistachio.mapper;

import org.samsara.pistachio.entity.BookCategory;

import java.util.List;

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
    boolean remove(Integer cid);

    /**
     * Remove the target category by name
     * @param category category name
     * @return true if the process is successful; else fal
     */
    boolean removeByName(String category);

    /**
     * Get all category names
     * @return list of category name
     */
    List<String> getAll();

    /**
     * Add a category to the database
     * @param category category entity
     * @return true if the process is successful; else false.
     */
    boolean add(BookCategory category);

    boolean insertSelective(BookCategory category);

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
     * Get the category id by category name
     * @param name category name
     * @return category id
     */
    Integer getCidByName(String name);

    /**
     * Update the category record in the database
     * @param record the category entity that shall update
     * @return true if the process is successful; else false.
     */
    boolean update(BookCategory record);
}