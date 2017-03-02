package com.bike.bananacard.common.tools.json;

import com.bike.bananacard.common.constant.ErrorCode;
import com.bike.bananacard.common.tools.code.MD5Utils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.util.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * created with bananaCard.
 * user: yanghui@700bike.com
 * date: 16/1/8
 * time: 下午4:52
 * description: 统一返回结果
 */
public class JsonResult {
    private static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
    private static final Gson GSON;
    private static final GsonBuilder BUIDLER = new GsonBuilder();
    private final static int SUCCESS = 1;
    private final static int FAILURE = 0;

    static {
        BUIDLER.setDateFormat(DEFAULT_DATE_PATTERN);
        GSON = BUIDLER.create();
    }

    private final Map<String, Object> keys = new LinkedHashMap<String, Object>();
    //状态默认为成功
    private int status = SUCCESS;
    private String msg;
    private int errorcode;

    public void put(String key, Object value) {
        keys.put(key, value);
    }

    public String success() {
        this.status = SUCCESS;
        this.errorcode = ErrorCode.SUCCESS.getCode();
        this.msg = ErrorCode.SUCCESS.getMsg();
        return this.toString();
    }

    public String failure(ErrorCode errorCode, String message) {
        if (StringUtils.isEmpty(message)) {
            this.msg = errorCode.getMsg();
        } else {
            this.msg = message;
        }
        this.status = FAILURE;
        this.errorcode = errorCode.getCode();

        return this.toString();
    }

    public String failure(ErrorCode errorCode) {
        this.status = FAILURE;
        this.errorcode = errorCode.getCode();
        this.msg = errorCode.getMsg();
        return this.toString();
    }

    public String failure() {
        this.status = FAILURE;
        this.errorcode = ErrorCode.SYSTEM_INTERNAL_ERROR.getCode();
        this.msg = ErrorCode.SYSTEM_INTERNAL_ERROR.getMsg();
        return this.toString();
    }

    private String getData() {
        JsonParser jsonParser = new JsonParser();
        JsonObject data = new JsonObject();
        JsonObject result = new JsonObject();
        JsonObject status = new JsonObject();
        status.addProperty("status", this.status);
        if (!StringUtils.isEmpty(this.msg)) {
            status.addProperty("msg", this.msg);
        }
        status.addProperty("code", this.errorcode);
        status.addProperty("server_time", System.currentTimeMillis());
        for (Map.Entry<String, Object> entry : keys.entrySet()) {
            if (entry.getValue() instanceof String) {
                data.addProperty(entry.getKey(), entry.getValue().toString());
            } else {
                data.add(entry.getKey(), jsonParser.parse(GSON.toJson(entry.getValue())));
            }
        }
        result.add("result", status);
        if (!keys.isEmpty()) {
            result.add("data", data);
            status.addProperty("hash_code", MD5Utils.MD5(String.valueOf(data.hashCode())));
        }


        return result.toString();
    }


    @Override
    public String toString() {
        return getData();
    }


}
