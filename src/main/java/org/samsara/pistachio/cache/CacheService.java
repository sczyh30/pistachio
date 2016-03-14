package org.samsara.pistachio.cache;

/**
 * Cache Service Interface
 */
public interface CacheService {

    boolean isCached(String key);

    String cache(String key, String value);

    String cacheObj(String key, Object obj);

    String getCache(String key);
}
