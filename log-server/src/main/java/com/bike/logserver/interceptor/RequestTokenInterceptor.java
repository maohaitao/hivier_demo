package com.bike.logserver.interceptor;

import com.bike.bananacard.common.constant.ErrorCode;
import com.bike.bananacard.common.tools.PrintWriterUtils;
import com.bike.logserver.interceptor.request.RequestParameterContextBuilder;
import com.bike.logserver.interceptor.request.RequestValid;
import com.bike.logserver.interceptor.request.RequestValidToken;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * created with bananaCard.
 * user: yanghui@700bike.com
 * date: 16/1/13
 * time: 下午3:07
 * description: 统一token验证
 */
public class RequestTokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        RequestValid requestValid = new RequestValidToken();
        if (!requestValid.valid()) {
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
            PrintWriterUtils.print(response, ErrorCode.TOKEN_INVALID);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        RequestParameterContextBuilder.close();
    }
}
