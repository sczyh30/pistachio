package org.samsara.pistachio.cache;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.samsara.pistachio.Constant;
import org.samsara.pistachio.entity.BookInfo;
import org.samsara.pistachio.util.DateUtil;

import static org.junit.Assert.*;

/**
 * Redis Cache Service Test
 */
public class RedisCacheServiceTest {

    RedisCacheService service;

    @Before
    public void setUp() throws Exception {
        service = RedisCacheService.getService();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testIsCached() throws Exception {
        assertEquals(false, service.isCached("st66"));
    }

    @Test
    public void testIsHCached() throws Exception {
        assertEquals(false, service.isHCached("st01", "bb"));
    }

    @Test
    public void testCache() throws Exception {

    }

    @Test
    public void testCacheObj() throws Exception {
        BookInfo bookInfo = new BookInfo("9787544276597", "丈量世界", "[德] 丹尼尔‧凯曼", DateUtil.toDate("2015-10-1"), "南海出版公司", 277, 1406);

        service.hCacheObj(Constant.CACHE_BOOK_KEY, "BOOK_9787544276597", bookInfo);
        assertEquals(true, service.isHCached(Constant.CACHE_BOOK_KEY, "BOOK_9787544276597"));
    }

    @Test
    public void testCacheObjToJSON() throws Exception {

    }

    @Test
    public void testGetCache() throws Exception {

    }

    @Test
    public void testGetCacheObj() throws Exception {

    }

    @Test
    public void testHCacheObj() throws Exception {

    }

    @Test
    public void testHCache() throws Exception {

    }

    @Test
    public void testHmCacheObj() throws Exception {

    }

    @Test
    public void testHmGetCacheList() throws Exception {

    }

    @Test
    public void testHGetCache() throws Exception {

    }

    @Test
    public void testHGetCacheObj() throws Exception {

    }

    @Test
    public void testHmGetCacheObjList() throws Exception {

    }
}