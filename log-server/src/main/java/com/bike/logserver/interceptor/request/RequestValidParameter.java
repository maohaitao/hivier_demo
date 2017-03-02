package com.bike.logserver.interceptor.request;


import com.bike.apicommon.GzipUtil;
import com.bike.bananacard.bean.ProtocolHeader;
import com.bike.bananacard.common.tools.json.JsonUtils;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sf.common.log.LogService;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class RequestValidParameter implements RequestValid {
    public static final String PHEAD = "phead";
    public static final String TOKEN = "token";
    public static final String PARAMETER_DATA = "data";
    public static final String HANDLE = "handle"; // 接收到参数解压处理
    public static final String SHANDLE = "shandle"; // 返回解压处理 shandle
    private HttpServletRequest request;

    public RequestValidParameter(HttpServletRequest request) {
        this.request = request;
    }

    public boolean valid() {
        String data = request.getParameter(PARAMETER_DATA);
        String handle = request.getParameter(HANDLE);
        return validParameter(data,handle);
    }

    private boolean validParameter(String data,String handle) {
        if (StringUtils.isEmpty(data)) {
            return false;
        }
        if ("1".equals(handle)) {
            try {
                data = GzipUtil.ungzip(data);
            } catch (Exception e) {
                LogService.error("参数解析出错, param:" + data, e);
            }finally {
                String recvlog = request.getServletPath() + ":request:" +data;
                LogService.debug("recvlog==:" + recvlog);
            }
        }
        JsonObject JsonData = JsonUtils.fromJson(data, JsonObject.class);

        if (JsonData == null) {
            return false;
        }
        JsonObject headJson = JsonData.getAsJsonObject(PHEAD);
        JsonObject parameterJson = JsonData.getAsJsonObject(PARAMETER_DATA);
        JsonElement tokenJson = JsonData.get(TOKEN);
        if (headJson == null || tokenJson == null) {
            return false;
        }
        ProtocolHeader header = JsonUtils.fromJson(headJson, ProtocolHeader.class);
        String token = tokenJson.getAsString();
        RequestParameterContextBuilder.get().setShandle(request.getParameter(SHANDLE));
        RequestParameterContextBuilder.get().setHandle(handle);
        RequestParameterContextBuilder.get().setToken(token);
        RequestParameterContextBuilder.get().setHeader(header);
        RequestParameterContextBuilder.get().setParameter(parameterJson);
        return true;
    }
}