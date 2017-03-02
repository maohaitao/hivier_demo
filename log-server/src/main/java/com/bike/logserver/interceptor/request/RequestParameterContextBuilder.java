package com.bike.logserver.interceptor.request;

/**
 * created with bananaCard.
 * date: 16/1/14
 * time: 上午9:49
 * description: 负责线程共享参数传递
 */
public class RequestParameterContextBuilder {
    private static final ThreadLocal<RequestParameterContext> threadLocal = new ThreadLocal<RequestParameterContext>();

    public static RequestParameterContext get() {
        RequestParameterContext requestParameterContext = threadLocal.get();
        if (requestParameterContext == null) {
            requestParameterContext = new RequestParameterContext();
            threadLocal.set(requestParameterContext);
        }
        return requestParameterContext;
    }


    public static void close() {
        threadLocal.remove();
    }
}
