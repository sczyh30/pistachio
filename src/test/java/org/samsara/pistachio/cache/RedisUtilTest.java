package org.samsara.pistachio.cache;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Redis Cache Test
 */
public class RedisUtilTest {

    private Jedis jedis = null;

    @Before
    public void setUp() throws Exception {
        jedis = RedisUtil.getJedis();
    }

    @Test
    public void testJedisBasic() throws Exception {
        jedis.set("fuck", "Scala");
        System.out.println(jedis.get("fuck"));
        jedis.del("fuck");
    }

    @Test
    public void testJedisBasicEx() throws Exception {
        jedis.setex("fuck2", 2, "Scala");
        System.out.println(jedis.get("fuck2"));
        Thread.sleep(3000);
        System.out.println(jedis.get("fuck2"));
    }

    @Test
    public void testJedisHash() throws Exception {
        Map<String, String> map = new HashMap<>();
        map.put("a1", "b1");
        map.put("a2", "b2");
        //map.put(null, "a3");
        jedis.hmset("st01", map);
        jedis.hmget("st01", "a2", "a3")
                .forEach(System.out::println);
        map.clear();
    }

    /*@After
    public void tearDown() throws Exception {
        RedisUtil.release();
    }*/
}