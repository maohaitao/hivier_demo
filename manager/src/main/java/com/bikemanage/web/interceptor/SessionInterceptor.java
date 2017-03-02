package com.bikemanage.web.interceptor;

import com.sf.common.database.dao.BaseDao;
import com.sf.common.database.dao.BaseDaoImpl;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2015/4/23.
 *
 * @author hesin
 *         日志拦截
 */
public class SessionInterceptor implements HandlerInterceptor {
    private static BaseDao getBaseDao() {
        WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
        return (BaseDaoImpl) wac.getBean("baseDao");
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("session afterCompletion=="+response);
    }
}
