package org.samsara.pistachio.cache;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.FileNotFoundException;

import java.util.ResourceBundle;

/**
 * Redis cache util class
 * Manage the redis cache connection pool
 *
 * @author sczyh30
 * @since 0.2
 */
public final class RedisUtil {

    private RedisUtil() {}

    private volatile static JedisPool jedisPool = null;

    static {
        try {
            ResourceBundle bundle = ResourceBundle.getBundle("redis");
            if (bundle == null)
                throw new FileNotFoundException("Cannot find the config file [redis.properties]");

            JedisPoolConfig config = new JedisPoolConfig();

            //int maxActivity = Integer.valueOf(bundle.getString("redis.pool.maxActive"));
            int maxIdle = Integer.valueOf(bundle.getString("redis.pool.maxIdle"));
            long maxWait = Long.valueOf(bundle.getString("redis.pool.maxWait"));
            boolean testOnBorrow = Boolean.valueOf(bundle.getString("redis.pool.testOnBorrow"));
            boolean onReturn = Boolean.valueOf(bundle.getString("redis.pool.testOnReturn"));

            //config.setMaxActive(maxActivity);
            config.setMaxIdle(maxIdle);
            config.setMaxWaitMillis(maxWait);
            config.setTestOnBorrow(testOnBorrow);
            config.setTestOnReturn(onReturn);

            int timeout = Integer.valueOf(bundle.getString("redis.timeout"));

            jedisPool = new JedisPool(config, bundle.getString("redis.ip"),
                    Integer.valueOf(bundle.getString("redis.port")), timeout);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    /**
     * Get a jedis entity from the pool
     *
     * @return the Jedis entity
     */
    public static Jedis getJedis() throws RedisInitException {
        if (jedisPool != null)
            return jedisPool.getResource();
        else
            throw new RedisInitException("Cannot get redis instance from a null JedisPool");
    }

    /**
     * Close the jedis pool and release resources
     */
    public static void release() {
        jedisPool.close();
    }
}
