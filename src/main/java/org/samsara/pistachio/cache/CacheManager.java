package org.samsara.pistachio.cache;

import org.samsara.pistachio.util.RedisUtil;
import redis.clients.jedis.Jedis;

/**
 * Samsara Pistachio
 * Cache manager
 * @author sczyh30
 * @since 0.1.21
 */
public class CacheManager {

    private static Jedis jedis = RedisUtil.getJedis();

    /**
     * Add a string cache to Redis
     * @param key key
     * @param value value
     * @return Status code reply
     */
    public static String addStringCache(String key, String value) {
        return jedis.set(key, value);
    }

    /**
     * Get a string cache by key
     * @param key key
     * @return the value
     */
    public static String getCacheString(String key) {
        return jedis.get(key);
    }

    /**
     * Remove a cache string explicitly
     * @param key key
     */
    public static void removeCacheString(String key) {
        jedis.del(key);
    }


}
