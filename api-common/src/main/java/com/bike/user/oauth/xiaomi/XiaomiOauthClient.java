package com.bike.user.oauth.xiaomi;

import com.bike.user.model.OauthUser;
import com.bike.user.model.TAccount;
import com.bike.user.oauth.IOauthClient;
import com.g3.common.http.HttpClientUtil;
import com.google.gson.JsonObject;
import com.sf.common.exception.AppException;
import com.sf.common.reflection.property.PropertiesUtil;
import com.sf.common.util.CommonUtil;
import com.sf.common.util.JsonUtil;

/**
 * Created by a700 on 16/10/28.
 */
public class XiaomiOauthClient implements IOauthClient {
    private static final XiaomiConfig xiaomiConfig = PropertiesUtil.getConfig("xiaomiconfig.properties", XiaomiConfig.class);

    public static void main(String[] args) {
        XiaomiOauthClient xiaomiOauthClient = new XiaomiOauthClient();
        try {
            xiaomiOauthClient.getNickName("2882303761517458686", "V2_om3_-l6WFDYHfcaFCzTM1h7UmtQAxHwxjRYigiNytEbIJsPKV2yw-50A_Apx17UWHtULDqmpVGzcHb5WEbwn5pwYQdxLOdhFIPleS0GmRs6kKHeRbQzpreoUxLrKmPYY");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String authorize(String state) {
        StringBuilder sb = new StringBuilder();
        return sb.toString();
    }

    @Override
    public String getAccessToken(String code) throws Exception {
        return null;
    }

    @Override
    public OauthUser getOauthUser(String code) throws Exception {
        return null;
    }

    @Override
    public TAccount getNickName(String clientId, String accessToken) throws Exception {
        if (CommonUtil.isNull(accessToken)) {
            throw new AppException(-6, "小米 accessToken 没有获取到响应参数，可能是用户取消了授权。 ");
        }
        String url = xiaomiConfig.getBaseURL() + "?clientId=" + xiaomiConfig.getClient_ID() + "&token=" + accessToken;
        String responseText = HttpClientUtil.get(url).getStringData();
        JsonObject json = JsonUtil.parse(responseText);
        System.out.println("json=="+json);
        if ("ok".equals(JsonUtil.getValue(json, "result"))) {
            JsonObject data = json.getAsJsonObject("data");
            System.out.println("data=="+data);
            if (data != null) {
                String nickname = JsonUtil.getValue(data, "miliaoNick");
                TAccount account = new TAccount();
                account.setNickName(nickname);
                String userFace = JsonUtil.getValue(data, "miliaoIcon_90");
                account.setUserFace(userFace);
                account.setOpenId(JsonUtil.getValue(data, "userId"));
                return account;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }


}
