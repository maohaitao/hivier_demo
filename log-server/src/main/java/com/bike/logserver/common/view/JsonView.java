package com.bike.logserver.common.view;


import com.bike.bananacard.common.constant.ErrorCode;
import com.bike.bananacard.common.exception.CustomCodeException;
import com.bike.bananacard.common.tools.PrintWriterUtils;
import com.bike.logserver.interceptor.request.RequestParameterContext;
import com.bike.logserver.interceptor.request.RequestParameterContextBuilder;
import com.sf.common.log.LogService;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class JsonView extends AbstractView {
    public static final String EXCEPTION_KEY = "exception_key";
    private final static Logger LOG = Logger.getLogger(JsonView.class);

    @Override
    protected void renderMergedOutputModel(Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Throwable e = (Exception) map.get(EXCEPTION_KEY);
        if (e != null) {
            if (e instanceof CustomCodeException) {
                response.setStatus(HttpServletResponse.SC_ACCEPTED);
                CustomCodeException codeException = (CustomCodeException) e;
                PrintWriterUtils.print(response, codeException.getErrorCode(), codeException.getMessage());
                RequestParameterContext requestParameterContext = RequestParameterContextBuilder.get();
                LogService.error(request.getRequestURI() + " 业务处理异常 error:" + requestParameterContext.getToken() + "##"
                        + requestParameterContext.getAccountId() + "##" + codeException.getMessage(), e);
            } else {
                response.setStatus(HttpServletResponse.SC_ACCEPTED);
                PrintWriterUtils.print(response, ErrorCode.SYSTEM_INTERNAL_ERROR);
                if (LOG.isDebugEnabled()) {
                    PrintWriterUtils.print(response, ErrorCode.SYSTEM_INTERNAL_ERROR, e.getMessage());
                } else {
                    PrintWriterUtils.print(response, ErrorCode.SYSTEM_INTERNAL_ERROR);
                }
                RequestParameterContext requestParameterContext = RequestParameterContextBuilder.get();
                LogService.error(request.getRequestURI() + " 业务处理异常error:" + requestParameterContext.getToken() + "##"
                        + requestParameterContext.getAccountId(), e);
            }
        }
    }
}
