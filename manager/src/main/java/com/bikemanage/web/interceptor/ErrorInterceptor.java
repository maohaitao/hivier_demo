package com.bikemanage.web.interceptor;

import com.bikemanage.dto.common.JsonResult;
import com.bikemanage.dto.common.JsonResultException;
import com.bikemanage.dto.common.JsonResultParameter;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.Map;

/**
 * Created by Administrator on 2015/4/23.
 *
 * @author hesin
 *         日志拦截
 */
public class ErrorInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            ResponseBody ResponseBody = handlerMethod.getMethodAnnotation(org.springframework.web.bind.annotation.ResponseBody.class);
            if (ResponseBody != null && handlerMethod.getMethod().getReturnType().getSimpleName().equals("String")) {
                JsonResult jsonResult = new JsonResult();
                if (ex != null) {
                    if (ex instanceof JsonResultException) {
                        jsonResult.failure(ex.getMessage());
                    } else {
                        jsonResult.failure(ex);
                    }
                }
                JsonResultParameter parameter = new JsonResultParameter(request);
                Map<String, Object> parameterMap = parameter.getAttributes();
                for (Map.Entry<String, Object> entry : parameterMap.entrySet()) {
                    jsonResult.put(entry.getKey(), entry.getValue());
                }
                response.setContentType("application/json;charset=UTF-8");
                response.setCharacterEncoding("UTF-8");
                OutputStream output = response.getOutputStream();
                String json = jsonResult.toString();
                output.write(json.getBytes());
            }
        }
    }
}
