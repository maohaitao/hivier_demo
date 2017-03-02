package com.bike.logserver.interceptor;

import com.bike.apicommon.GzipUtil;
import com.bike.bananacard.common.constant.ErrorCode;
import com.bike.bananacard.common.tools.PrintWriterUtils;
import com.bike.logserver.interceptor.request.RequestValid;
import com.bike.logserver.interceptor.request.RequestValidParameter;
import com.sf.common.log.LogService;
import com.sf.common.util.CommonUtil;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * created with bananaCard.
 * user: yanghui@700bike.com
 * date: 16/1/13
 * time: 下午3:07
 * description: 统一请求参数处理
 */
public class RequestParameterInterceptor implements HandlerInterceptor {
    public static String getRequestParameterString(HttpServletRequest request) {
        String handle = request.getParameter("handle");
        StringBuilder builder = new StringBuilder();

        String name;
        String value;
        for (Enumeration enumeration = request.getParameterNames(); enumeration.hasMoreElements(); builder.append(name).append("=").append(value).append(", ")) {
            name = (String) enumeration.nextElement();
            value = request.getParameter(name);
            if (!CommonUtil.isNull(value) && "1".equals(handle)) {
                try {
                    value = GzipUtil.ungzip(value);
                } catch (Exception e) {
                    LogService.error("参数解析出错, param:" + value, e);
                }
                if (value.length() > 1024) {
                    value = "[len:" + value.length() + "] " + value.substring(0, 1023) + "...";
                }
            }
        }
        if (builder.length() > 1) {
            builder.deleteCharAt(builder.length() - 2);
        }
        return builder.toString();
    }


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        RequestValid requestValid = new RequestValidParameter(request);
        if (!requestValid.valid()) {
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
            PrintWriterUtils.print(response, ErrorCode.REQUEST_INCORRECT);
            return false;
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
/*       System.out.print(response.getHeader(""));
        if( "1".equals( request.getParameter("shandle"))&&handler instanceof HandlerMethod){
            response.setHeader("Content-Encoding","gzip");
        }*/

    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //System.out.println("res==:" + response.getOutputStream().toString());
    }
}
