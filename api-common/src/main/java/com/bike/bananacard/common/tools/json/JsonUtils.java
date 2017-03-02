package com.bike.bananacard.common.tools.json;


import com.bike.bananacard.common.exception.CustomCodeException;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * created with bananaCard.
 * user: yanghui@700bike.com
 * date: 16/1/14
 * time: 下午9:13
 * description: json处理工具
 */
public class JsonUtils {
    private static final Gson GSON = new Gson();

    public static <T> T fromJson(String object, Class<T> clazz) {
        try {
            return GSON.fromJson(object, clazz);
        } catch (Exception e) {
            return null;
        }
    }

    public static JsonElement toJson(Object o) {
        return GSON.toJsonTree(o);
    }

    public static <T> T fromJson(JsonObject jsonObject, Class<T> clazz) {
        try {
            return GSON.fromJson(jsonObject, clazz);
        } catch (Exception e) {
            return null;
        }
    }

    public static JsonObject fromJson(byte[] bytes) throws CustomCodeException {
        return fromJson(new String(bytes), JsonObject.class);
    }

    public static String getAsString(JsonObject jsonObject, String key) {
        if (jsonObject == null) {
            return null;
        }
        JsonElement jsonElement = jsonObject.get(key);
        if (jsonElement != null) {
            return jsonElement.getAsString();
        }
        return null;
    }

    public static Double getAsDouble(JsonObject jsonObject, String key) {
        if (jsonObject == null) {
            return null;
        }
        JsonElement jsonElement = jsonObject.get(key);
        if (jsonElement != null) {
            return jsonElement.getAsDouble();
        }
        return null;
    }

    public static Integer getAsInt(JsonObject jsonObject, String key) {
        if (jsonObject == null) {
            return null;
        }
        JsonElement jsonElement = jsonObject.get(key);
        if (jsonElement != null) {
            return jsonElement.getAsInt();
        }
        return null;
    }

}
