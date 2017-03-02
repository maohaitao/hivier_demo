package com.bike.activity.common;

import banana.wechat.hessian.BananaHessian;
import banana.wechat.model.ImageInfo;
import com.banana.common.hessian.server.BananaUserMessageService;
import com.banana.common.hessian.server.UserMessageHessian;
import com.caucho.hessian.client.HessianProxyFactory;
import com.sf.common.log.LogService;
import com.sf.common.properties.PropertiesLoader;
import com.sf.common.util.CommonUtil;

import java.net.MalformedURLException;
import java.util.Properties;

/**
 * Created by a700 on 17/2/7.
 */
public class ChallengeUserMessageUtil {

    private static BananaUserMessageService bananaUserMessageService = null;

    static {
        Properties properties = PropertiesLoader.loadProperties("project.properties");
        String url = properties.getProperty("challenge_hessian_url");
        HessianProxyFactory factory = new HessianProxyFactory();
        try {
            bananaUserMessageService = (BananaUserMessageService) factory.create(
                    BananaUserMessageService.class, url);
        }catch (MalformedURLException e){
            LogService.error("ChallengeUserMessageUtil init error:"+e);
        }

    }

    public static boolean addUserMessage(UserMessageHessian userMessageHessian){
        if(null==userMessageHessian){
            return false;
        }
        try {
            return bananaUserMessageService.addUserMessage(userMessageHessian);
        }catch (Exception e){
            LogService.error("addUserMessage error:"+e);
            return false;
        }
    }

    public static boolean delUserMessage(UserMessageHessian userMessageHessian){
        if(null==userMessageHessian){
            return false;
        }
        try {
            return bananaUserMessageService.delUserMessage(userMessageHessian);
        }catch (Exception e){
            LogService.error("delUserMessage error:"+e);
            return false;
        }
    }
}
