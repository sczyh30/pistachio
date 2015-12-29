package org.samsara.pistachio.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis cache util class
 * Manage the redis cache connection pool
 * @author sczyh30
 * @since 0.2
 */
public class RedisUtil {

    private static String ADDR = "127.0.0.1";
    private static int PORT = 6379;
    private static String AUTH = "6666";
    private static int MAX_ACTIVE = 1024;
    private static int MAX_IDLE = 200;
    private static long MAX_WAIT = 10000;
    private static int TIMEOUT = 10000;
    private static boolean TEST_ON_BORROW = true;

    private static JedisPool jedisPool = null;

    static {
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxIdle(MAX_IDLE);
            config.setTestOnBorrow(TEST_ON_BORROW);
            jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Get a jedis entity from the pool (with lock)
     * @return the Jedis entity
     */
    public synchronized static Jedis getJedis() {
        try {
            if (jedisPool != null) {
                return jedisPool.getResource();
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Close the jedis pool and release resources
     */
    public static void release() {
        jedisPool.close();
    }
}
