package com.bikemanage.dto.common;

import com.bikemanage.common.ErrorSession;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;
import java.util.Map;

public class JsonResult {
    private final static int SUCCESS = 1;
    private final static int FAILURE = 0;
    private final Map<String, Object> keys = new HashMap<String, Object>();
    //状态默认为成功
    private int status = SUCCESS;
    private String errorMessage;

    public void put(String key, Object value) {
        keys.put(key, value);
    }

    private String getData() {
        Gson gson = new Gson();
        JsonParser jsonParser = new JsonParser();
        JsonObject data = new JsonObject();
        JsonObject result = new JsonObject();
        result.addProperty("status", getStatus());
        result.addProperty("errorMessage", getErrorMessage());
        data.add("result", result);
        for (Map.Entry<String, Object> entry : keys.entrySet()) {
            if (entry.getValue() instanceof String) {
                data.addProperty(entry.getKey(), entry.getValue().toString());
            } else {
                data.add(entry.getKey(), jsonParser.parse(gson.toJson(entry.getValue())));
            }
        }
        return data.toString();
    }

    public String success() {
        this.setStatus(SUCCESS);
        return this.toString();
    }

    public String failure(String errorMessage, Exception e) {
        ErrorSession errorSession = new ErrorSession(e);
        this.setStatus(FAILURE);
        this.setErrorMessage(errorMessage + "【有疑问请联系客服,错误凭证码:" + errorSession.getErrorCode() + "】");

        return this.toString();
    }

    public String failure(String errorMessage) {
        this.setStatus(FAILURE);
        this.setErrorMessage(errorMessage);
        return this.toString();
    }

    public String failure() {
        return failure("本次请求未能处理");
    }

    public String failure(Exception e) {
        return failure("本次请求未能处理!", e);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return getData();
    }


}
