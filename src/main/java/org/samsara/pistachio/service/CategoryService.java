package org.samsara.pistachio.service;

import org.samsara.pistachio.entity.BookCategory;
import org.samsara.pistachio.mapper.BookCategoryMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Samsara Pistachio
 * Category Service
 * @author sczyh30
 */
@Service(value = "categoryService")
public class CategoryService {

    @Resource
    private BookCategoryMapper mapper;

    /**
     * Add a category entity to the database
     * @param category category entity
     * @return status
     */
    public boolean addCategory(BookCategory category) {
        return mapper.add(category);
    }

    public boolean addCategory(String category) {
        return mapper.add(new BookCategory(category));
    }

    public boolean removeCategory(int cid) {
        return mapper.remove(cid);
    }

    public boolean removeCategory(String name) {
        return mapper.removeByName(name);
    }

    /**
     * Get all categories of books
     * @return the query result
     */
    public List<String> getAllCategories() {
        return mapper.getAll();
    }
}
