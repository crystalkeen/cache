package cache;

import cache.model.CacheEntry;

import java.util.HashMap;
import java.util.Map;

public class CacheMap {

    private static Map<String, CacheEntry> cacheMap = new HashMap<String, CacheEntry>();

    public static synchronized String get(String key) {
        CacheEntry entry = cacheMap.get(key);
        if (System.currentTimeMillis() > entry.getCreateTime() + entry.getLifeTime()) {
            cacheMap.remove(key);
            return null;
        }
        return entry.getValue();
    }

    public static synchronized void put(String key, String value, Long lifeTime) {
        CacheEntry entry = new CacheEntry();
        entry.setValue(value);
        entry.setLifeTime(lifeTime);

        cacheMap.put(key, entry);
    }
}
