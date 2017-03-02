package com.bike.apicommon;

import com.sf.common.log.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by a700 on 16/9/25.
 * 处理打卡相关模块的返回数据压缩
 */
public class GzipCommonAop {
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
        Object object = pjp.proceed();
        try{
            RequestAttributes ra = RequestContextHolder.getRequestAttributes();
            ServletRequestAttributes sra = (ServletRequestAttributes) ra;
            HttpServletRequest request = sra.getRequest();
            if("1".equals( request.getParameter("shandle")) && (object instanceof String)){//需要进行压缩
                String result = (String)object;
                result = GzipUtil.gzip(result);
                //LogService.info(pjp.getSignature().getDeclaringTypeName()+">>result:"+result);
                return result;
            }
        }catch (Exception e){
            LogService.error("GzipCommonAop around error:"+e);
        }
        return object;
    }
}
