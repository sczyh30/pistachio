package org.samsara.pistachio.cache;

import org.samsara.pistachio.util.JsonUtil;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Samsara Pistachio Service
 * Redis Cache Service
 */
public final class RedisCacheService implements CacheService {

    private volatile Jedis jedis = RedisUtil.getJedis();

    private static class Holder {
        private static RedisCacheService instance = new RedisCacheService();
    }

    public static RedisCacheService getService() {
        return Holder.instance;
    }

    /**
     * Inspect if the key has been cached
     * @param key key
     * @return true if it has been cached
     *         else false
     */
    @Override
    public boolean isCached(String key) {
        return jedis.exists(key);
    }

    /**
     * Inspect if a field has been cached in a hash
     * @param key key
     * @param field field
     * @return true if it has been cached
     *         else false
     */
    public boolean isHCached(String key, String field) {
        return jedis.hexists(key, field);
    }

    @Override
    public String cache(String key, String value) {
        return jedis.set(key, value);
    }

    @Override
    public String cacheObj(String key, Object obj) {
        return cacheObjToJSON(key, obj);
    }

    public String cacheObjToJSON(String key, Object obj) {
        return jedis.set(key, JsonUtil.toJson(obj));
    }

    @Override
    public String getCache(String key) {
        return jedis.get(key);
    }

    public <T> T getCacheObj(String key, Class<T> clazz) {
        return JsonUtil.fromJson(getCache(key), clazz);
    }

    public long hCacheObj(String key, String field, Object obj) {
        return hCache(key, field, JsonUtil.toJson(obj));
    }

    public long hCache(String key, String field, String value) {
        return jedis.hset(key, field, value);
    }

    public String hmCacheObj(String key, Map<String, String> map) {
        return jedis.hmset(key, map);
    }

    public List<String> hmGetCacheList(String key ,String... fields) {
        return jedis.hmget(key, fields);
    }

    public String hGetCache(String key, String field) {
        return jedis.hget(key, field);
    }

    public <T> T hGetCacheObj(String key, String field, Class<T> clazz) {
        return JsonUtil.fromJson(hGetCache(key, field), clazz);
    }

    /**
     * Get list of objects from concrete fields in a hash map
     * convert the data from JSON to objects
     * @param key hash key
     * @param clazz Class of obj
     * @param fields fields
     * @param <T> type of obj, must be the same type, or else boom!
     * @return list of objects
     */
    public <T> List<T> hmGetCacheObjList(String key , Class<T> clazz, String... fields) {
        List<String> list = hmGetCacheList(key, fields);

        return list.stream()
                .map(x -> JsonUtil.fromJson(x, clazz))
                .collect(Collectors.toList());
    }

    public long delCache(String key) {
        return jedis.del(key);
    }

    public long hDelCache(String key, String... fields) {
        return jedis.hdel(key, fields);
    }
}
