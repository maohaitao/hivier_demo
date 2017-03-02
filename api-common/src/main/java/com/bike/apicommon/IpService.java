package com.bike.apicommon;

import com.g3.common.http.HttpClientUtil;
import com.g3.common.http.model.HttpResult;
import com.google.gson.JsonElement;
import com.sf.common.log.LogService;
import com.sf.common.util.JsonUtil;
import org.apache.commons.lang.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by a700 on 16/11/7.
 * 获取用户访问ip对于国家城市
 */
public class IpService {
    private static String baseUrl = "http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=js&ip=";

    public static Map<String ,String> getIpProvince(String ip){
        LogService.info("IpService,ip:"+ip);
        if(StringUtils.isBlank(ip)){
            return null;
        }
        Map<String ,String> resultMap = null;
        String returnStr = null;
        try {
            //HttpClientUtil.createHttpClient("IpService",5000,5000,100,100);
            HttpResult result = HttpClientUtil.get(baseUrl+ip);//默认5秒的响应时间
            if(result !=null && result.getData() != null){
                returnStr  = new String(result.getData(), "GBK").replaceAll("var remote_ip_info = ", "").                    replace(";", "");
                resultMap = new HashMap<String ,String> ();
                JsonElement element = JsonUtil.parseEle(returnStr);
                resultMap.put("ip",ip);
                LogService.info("IpService,return string :"+element.toString());
                resultMap.put("city",element.getAsJsonObject().get("city").toString().replaceAll("\"", ""));
                resultMap.put("province",element.getAsJsonObject().get("province").toString().replaceAll("\"", ""));
            }
        }catch(Exception e){
            LogService.error("IpService,获取ip对应城市接口异常,ip:"+ip);
            return  null;
        }
        return resultMap;
    }


    public   static void main(String args[]){
        System.out.println(getIpProvince("106.75.142.196"));
    }

    public static String getRemoteAddrIp(HttpServletRequest request) {
        String ipFromNginx = getHeader(request, "X-Real-IP");
        LogService.info("ipFromNginx:" + ipFromNginx);
        LogService.info("getRemoteAddr:" + request.getRemoteAddr());
        return StringUtils.isEmpty(ipFromNginx) ? request.getRemoteAddr() : ipFromNginx;
    }


    private static String getHeader(HttpServletRequest request, String headName) {
        String value = request.getHeader(headName);
        return !StringUtils.isBlank(value) && !"unknown".equalsIgnoreCase(value) ? value : "";
    }

}
