package com.bikemanage.dto.common;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述：
 * 创建时间：15/7/22
 * 作者：yanghui
 */
public class JsonResultParameter {
    private final static String PARAMETER_RESULT = "PARAMETER_RESULT_";
    private HttpServletRequest request;

    public JsonResultParameter() {
        this.request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    public JsonResultParameter(HttpServletRequest request) {
        this.request = request;
    }

    public void setAttribute(String key, Object value) {
        request.setAttribute(PARAMETER_RESULT + key, value);
    }

    public Map<String, Object> getAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();
        Enumeration<String> enumeration = request.getAttributeNames();
        while (enumeration.hasMoreElements()) {
            String key = enumeration.nextElement();
            if (key.contains(PARAMETER_RESULT)) {
                attributes.put(key.replace(PARAMETER_RESULT, ""), request.getAttribute(key));
            }
        }
        return attributes;
    }
}
