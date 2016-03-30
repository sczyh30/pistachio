package org.samsara.pistachio.util;

import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * Samsara Common Library
 * JSON Util Class
 */
public final class JsonUtil {

    private JsonUtil() {}

    private final static Gson gson = new Gson();

    /**
     * Convert object to JSON String
     * @param obj object
     * @return JSON string
     */
    public static String toJson(Object obj) {
        return gson.toJson(obj);
    }

    /**
     * Convert JSON string to object
     * @param str JSON string
     * @param klazz Class of the object
     * @param <T> type of the object
     * @return the object
     */
    public static <T> T fromJson(String str, Class<T> klazz) {
        return gson.fromJson(str, klazz);
    }

    public static <T> T fromJson(String str, Type type) {
        return gson.fromJson(str, type);
    }
}
