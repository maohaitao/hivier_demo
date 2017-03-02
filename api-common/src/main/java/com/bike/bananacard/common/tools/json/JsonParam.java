package com.bike.bananacard.common.tools.json;


import com.bike.bananacard.common.constant.ErrorCode;
import com.bike.bananacard.common.exception.CustomCodeException;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * created with bananaCard.
 * user: yanghui@700bike.com
 * date: 16/1/14
 * time: 下午9:13
 * description: json参数处理
 */
public class JsonParam {
    private JsonObject jsonObject;

    protected void setJsonObject(JsonObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public String getAsString(String key) {
        JsonElement jsonElement = jsonObject.get(key);
        String value = null;
        if (jsonElement != null) {
            try {
                value = jsonElement.getAsString();
            } catch (Exception e) {
                throw new CustomCodeException(ErrorCode.PARAMETERS_INCORRECT, key, "-");
            }
        }
        return value;
    }

    public Double getAsDouble(String key) {
        JsonElement jsonElement = jsonObject.get(key);
        Double value = null;
        if (jsonElement != null) {
            try {
                value = jsonElement.getAsDouble();
            } catch (Exception e) {
                throw new CustomCodeException(ErrorCode.PARAMETERS_INCORRECT, key, "-");
            }
        }
        return value;
    }

    public Integer getAsInt(String key) {
        JsonElement jsonElement = jsonObject.get(key);
        Integer value = null;
        if (jsonElement != null) {
            try {
                value = jsonElement.getAsInt();
            } catch (Exception e) {
                throw new CustomCodeException(ErrorCode.PARAMETERS_INCORRECT, key, "-");
            }
        }
        return value;
    }

    public Boolean getAsBoolean(String key) {
        JsonElement jsonElement = jsonObject.get(key);
        Boolean value = null;
        if (jsonElement != null) {
            try {
                value = jsonElement.getAsBoolean();
            } catch (Exception e) {
                throw new CustomCodeException(ErrorCode.PARAMETERS_INCORRECT, key, "-");
            }
        }
        return value;
    }

    public JsonArray getAsJsonArray(String key) {
        JsonElement jsonElement = jsonObject.get(key);
        JsonArray value = null;
        if (jsonElement != null) {
            try {
                value = jsonElement.getAsJsonArray();
            } catch (Exception e) {
                throw new CustomCodeException(ErrorCode.PARAMETERS_INCORRECT, key, "-");
            }
        }
        return value;
    }
}
