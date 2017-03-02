package com.bike.apicommon;

import com.sf.common.log.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

/**
 * dubbo服务层通用日志接口
 */
public class CommonLog {


    /**
     * 进入方法调用时输出类名、方法名及参数列表
     * @param joinpoint
     */
    public void before(JoinPoint joinpoint){
        try {
            StringBuffer sb = new StringBuffer();
            Signature signature = joinpoint.getSignature();
            String classAndMethod = signature.getName();
            String className = signature.getDeclaringTypeName();
            sb.append("className:{").append(className).append("}||method:{").append(classAndMethod).append("}||param:{");
            Object[] args = joinpoint.getArgs();
            if (args != null && args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    sb.append(args[i]).append("||");
                }
            }
            sb.append("}");
            LogService.info(sb.toString());
        }catch(Exception e){
            LogService.error("Commonlog error:"+e);
        }
    }



    /**
     * 进入方法调用时输出返回结果
     * @param joinpoint
     */
    public void afterReturn(JoinPoint joinpoint,Object retValue){
        try {
        StringBuffer sb = new StringBuffer();
        Signature signature = joinpoint.getSignature();
        String classAndMethod = signature.getName();
        String className = signature.getDeclaringTypeName();
        sb.append("className:{").append(className).append("}||method:{").append(classAndMethod).append("}||param:{");
        Object[]  args = joinpoint.getArgs();
        if(args !=null && args.length >0){
            for (int i=0;i<args.length;i++){
                sb.append(args[i]).append("||");
            }
        }
        sb.append("}||retValue:").append(retValue);
        LogService.info(sb.toString());
        }catch(Exception e){
            LogService.error("Commonlog error:"+e);
        }
    }


    public void afterThrowing(JoinPoint joinpoint,Throwable throwable){
        try {
        StringBuffer sb = new StringBuffer();
        Signature signature = joinpoint.getSignature();
        String classAndMethod = signature.getName();
        String className = signature.getDeclaringTypeName();
        sb.append("className:{").append(className).append("}||method:{").append(classAndMethod).
                append("}||throwable:").append(throwable.getMessage());
        LogService.error(sb.toString());
        }catch(Exception e){
            LogService.error("Commonlog error:"+e);
        }
    }

}