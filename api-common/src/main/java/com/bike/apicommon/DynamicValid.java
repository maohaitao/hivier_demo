package com.bike.apicommon;

import banana.wechat.hessian.BananaHessian;
import banana.wechat.model.ImageInfo;
import com.caucho.hessian.client.HessianProxyFactory;
import com.sf.common.exception.AppException;
import com.sf.common.log.LogService;
import com.sf.common.properties.PropertiesLoader;
import com.sf.common.util.CommonUtil;

import java.net.MalformedURLException;
import java.util.Properties;

/**
 * Created by a700 on 16/11/29.
 */
public class DynamicValid {

    private static BananaHessian spaceService = null;

    static {
        Properties properties =PropertiesLoader.loadProperties("project.properties");
        String url = properties.getProperty("dynamic_valid_url");
        HessianProxyFactory factory = new HessianProxyFactory();
        try {
            spaceService = (BananaHessian) factory.create(
                    BananaHessian.class, url);
        }catch (MalformedURLException e){
            LogService.error("DynamicValid init error:"+e);
        }

    }

    public static String checkText(String text){
        if(CommonUtil.isNull(text)){
            return null;
        }
        try {
            return spaceService.checkText(text);
        }catch (Exception e){
            LogService.error("checkText error:"+e);
            return text;
        }
    }

    public static boolean checkImage(String url){
        if(CommonUtil.isNull(url)){
            return false;
        }
        try {
            ImageInfo info = spaceService.checkImage(url);
            if(info!=null&&info.getLabel()==0){
                return true;
            }
        }catch (Exception e){
            LogService.error("鉴黄失败："+e+",url:"+url);
        }
        return false;
    }
}
