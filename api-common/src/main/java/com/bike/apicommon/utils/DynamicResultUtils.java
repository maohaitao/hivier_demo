package com.bike.apicommon.utils;

import com.google.gson.JsonObject;
import com.sf.common.constant.ResultErrorCode;
import com.sf.common.model.DynamicResult;
/**
 * Created by a700 on 16/1/12.
 */
public class DynamicResultUtils {

    public static DynamicResult getErrorResult(String errorType, String errorInfo) {
        DynamicResult result = new DynamicResult();
        JsonObject res = new JsonObject();
        res.addProperty("status", errorType);
        res.addProperty("errorcode", errorType);
        res.addProperty("msg", errorInfo);
        result.put("result", res);
        return result;
    }


    public static DynamicResult getSeccessResult() {
        JsonObject res = new JsonObject();
        res.addProperty("status", ResultErrorCode.STATUS_CODE_SUCCESS.getCode());
        res.addProperty("errorcode", 0);
        DynamicResult result = new DynamicResult();
        result.put("result", res);
        return result;
    }


}
