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

    public static String addStringCache(String key, String value) {
        return jedis.set(key, value);
    }

    public static String getCacheString(String key) {
        return jedis.get(key);
    }

    public static void removeCacheString(String key) {
        jedis.del(key);
    }


}
