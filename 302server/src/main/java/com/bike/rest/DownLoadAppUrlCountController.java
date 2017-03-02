package com.bike.rest;

import com.bike.common.CodeType;
import com.mysql.jdbc.TimeUtil;
import com.mysql.jdbc.log.Log;
import com.sf.common.log.LogService;
import com.sf.common.properties.PropertiesLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Properties;

/**
 * Created by a700 on 16/10/17.
 */
@Controller
public class DownLoadAppUrlCountController {


    private static Properties properties = null;

    private static String downloadAppUrl = "http://a.app.qq.com/o/simple.jsp?pkgname=qibai.bike.bananacard&ckey=CK1343225595770";

    private static String  iosLoadAppUrl = "https://itunes.apple.com/app/id1095910968";

    private static String  andLoadAppUrl = "http://7xtxrp.com2.z0.glb.clouddn.com/bananaCard.apk";

    private static String  zheDaRedirectUrl= "http://a.app.qq.com/o/simple.jsp?pkgname=qibai.bike.bananacard&ckey=CK1343225453790";


    static {
        properties = PropertiesLoader.loadProperties("config.properties");
        if(properties.getProperty("downloadAppUrl")!=null){
            downloadAppUrl = properties.getProperty("downloadAppUrl");
        }

        if(properties.getProperty("iosLoadAppUrl")!=null){
            iosLoadAppUrl = properties.getProperty("iosLoadAppUrl");
        }

        if(properties.getProperty("andLoadAppUrl")!=null){
            andLoadAppUrl = properties.getProperty("andLoadAppUrl");
        }

        if(properties.getProperty("zheDaRedirectUrl")!=null){
            zheDaRedirectUrl = properties.getProperty("zheDaRedirectUrl");
        }

    }

    /**
     * 下载地址跳转
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/api/doRedirect.shtml", method = {RequestMethod.GET})
    public String doRedirect(HttpServletRequest request, HttpServletResponse response){
        String dateString = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        Enumeration e  = request.getHeaderNames();
        while (e.hasMoreElements()) {
            String name = (String) e.nextElement();
            if("user-agent".equals(name)){
                String value = request.getHeader(name);
                if(value.indexOf("iOS")>0 || value.indexOf("iPhone")>0){
                    LogService.info(CodeType.SHARE_302.getCode()+"||"+CodeType.IOS.getCode()+"||"+dateString+"||"+CodeType.WAP.getCode());
                }else{
                    LogService.info(CodeType.SHARE_302.getCode()+"||"+CodeType.AND.getCode()+"||"+dateString+"||"+CodeType.WAP.getCode());
                }
                break;
            }
        }
        return "redirect:" + downloadAppUrl;
    }

    /**
     * 二维码分享地址跳转
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/api/doZheDaHdShareRedirect.shtml", method = {RequestMethod.GET})
    public String doZheDaHdShareRedirect(HttpServletRequest request, HttpServletResponse response){
        String dateString = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        Enumeration e  = request.getHeaderNames();
        while (e.hasMoreElements()) {
            String name = (String) e.nextElement();
            if("user-agent".equals(name)){
                String value = request.getHeader(name);
                if(value.indexOf("iOS")>0 || value.indexOf("iPhone")>0){
                    LogService.info(CodeType.ZHEDA_HUODONG.getCode()+"||"+CodeType.IOS.getCode()+"||"+dateString+"||"+CodeType.WAP.getCode());
                }else{
                    LogService.info(CodeType.ZHEDA_HUODONG.getCode()+"||"+CodeType.AND.getCode()+"||"+dateString+"||"+CodeType.WAP.getCode());
                }
                break;
            }
        }
        return "redirect:" + zheDaRedirectUrl;
    }


    /**
     * 官网下载地址跳转
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/api/doAppDownLoad.shtml", method = {RequestMethod.GET})
    public String doAppDownLoad(HttpServletRequest request, HttpServletResponse response){
        String preMessage = "";
        String urlRedirect = "";
        String dateString = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        if(CodeType.WEB.getMsg().equals(request.getParameter("platform"))){
            preMessage = CodeType.WEB.getCode();
        }else if (CodeType.WAP.getMsg().equals(request.getParameter("platform"))){
            preMessage = CodeType.WAP.getCode();
        }

        if(CodeType.IOS.getMsg().equals(request.getParameter("device"))){
            //ISO 下载跳转
            LogService.info(CodeType.WEBSITE_LODD.getCode()+"||"+CodeType.IOS.getCode()+"||"+dateString+"||"+preMessage);
            urlRedirect = iosLoadAppUrl;
        }else if(CodeType.AND.getMsg().equals(request.getParameter("device"))){
            //AND 下载跳转
            LogService.info(CodeType.WEBSITE_LODD.getCode()+"||"+CodeType.AND.getCode()+"||"+dateString+"||"+preMessage);
            urlRedirect =  andLoadAppUrl;
        }else{
            //无平台标识
            urlRedirect = "http://www.banana-punch.com";
        }
        return "redirect:" + urlRedirect;
    }


}
