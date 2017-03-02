package com.bike.logserver.interceptor;

import com.bike.logserver.common.view.JsonView;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RequestExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            ResponseBody ResponseBody = handlerMethod.getMethodAnnotation(org.springframework.web.bind.annotation.ResponseBody.class);
            if (ResponseBody != null && handlerMethod.getMethod().getReturnType().getSimpleName().equals("String")) {
                if (e != null) {
                    return new ModelAndView(new JsonView(), JsonView.EXCEPTION_KEY, e);
                }
            }
        }
        return null;
    }
}
