package org.samsara.pistachio.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.samsara.pistachio.entity.BookCategory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Test case for BCM
 * Created by sczyh30 on 15-12-5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class BookCategoryMapperTest {

    @Resource
    private BookCategoryMapper mapper;

    //@Test
    public void testAdd() throws Exception {
        BookCategory c1 = new BookCategory(1407, "猥琐类");
        mapper.add(c1);
    }

    //@Test
    public void testGet() throws Exception {
        System.out.println(mapper.get(1407));
    }

    //@Test
    public void testGetName() throws Exception {
        System.out.println(mapper.getName(1407));
    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testRemove() throws Exception {

    }
}