package org.samsara.pistachio.mapper;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.samsara.pistachio.entity.BookInfo;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.AfterTransaction;

import javax.annotation.Resource;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Test case for BookInfoMapper
 * Created by sczyh30 on 15-12-5.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class BookInfoMapperTest {

    @Resource
    private BookInfoMapper mapper;

    //@Test
    public void testForTemp() throws Exception {
        BookInfo b1 = new BookInfo();
        b1.setAuthor("sczyh30");
        b1.setISBN("9787530215220");
        b1.setName("蜜汁Scala：卷I 出入师门");
        b1.setCategory(1406);
        b1.setPage(666);
        b1.setPubDate(Date.valueOf(LocalDate.now()));
        b1.setPublisher("朝鲜劳动党废土出版社");
        mapper.insert(b1);
    }



    @Before
    public void testInsert() throws Exception {
        BookInfo b1 = new BookInfo();
        BookInfo b2 = new BookInfo();
        b1.setAuthor("sczyh30");
        b1.setISBN("9787530215210");
        b1.setName("蜜汁Scala：卷I 出入师门");
        b1.setCategory(1406);
        b1.setPage(666);
        b1.setPubDate(Date.valueOf(LocalDate.now()));
        b1.setPublisher("朝鲜劳动党废土出版社");
        mapper.insert(b1);

        b2.setAuthor("sczyh30");
        b2.setISBN("9787530215216");
        b2.setName("蜜汁Scala：卷II 风雪残云");
        b2.setCategory(1406);
        b2.setPage(888);
        b2.setPubDate(Date.valueOf(LocalDate.now()));
        b2.setPublisher("朝鲜劳动党黑暗料理出版社");
        mapper.insert(b2);
    }

    @Test
    public void testGet() throws Exception {
        System.out.println("-----------COMMON GET TEST-----------");
        BookInfo book = mapper.get("9787530215216");
        System.out.println(book);
    }

    @Test
    public void testGetByName() throws Exception {
        System.out.println("-----------GET_BY_NAME TEST-----------");
        BookInfo book = mapper.getByName("蜜汁Scala：卷II 风雪残云");
        System.out.println(book);
    }

    @Test
    public void testGetAllByAuthor() throws Exception {
        System.out.println("-----------AUTHOR TEST-----------");
        List<BookInfo> list = mapper.getAllByAuthor("sczyh30");
        list.forEach(System.out::println);

    }

    @Test
    public void testUpdate() throws Exception {
        BookInfo b2 = new BookInfo();
        b2.setAuthor("sczyh30");
        b2.setISBN("9787530215216");
        b2.setName("蜜汁Scala：卷II 风雪残云");
        b2.setCategory(1406);
        b2.setPage(888);
        b2.setPubDate(Date.valueOf(LocalDate.now()));
        b2.setPublisher("朝鲜劳动党中央书鸡菊");
        mapper.update(b2);
    }

    @After
    public void testRemove() throws Exception {
        mapper.remove("9787530215210");
        mapper.remove("9787530215216");
    }
}