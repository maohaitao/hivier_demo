package com.bike.logserver.interceptor.request;


import com.bike.apicommon.utils.TokenUtils;
import com.bike.bananacard.common.tools.code.RSAUtils;
import com.bike.user.model.TAccount;
import com.sf.common.exception.AppException;
import com.sf.common.log.LogService;
import org.apache.commons.codec.binary.Base64;
import org.springframework.util.StringUtils;

/**
 * created with bananaCard.
 * date: 16/1/14
 * time: 下午9:13
 * description: 验证token
 */
public class RequestValidToken implements RequestValid {
    //private static String TOKEN_URL = PropertiesUtils.getValue("rsync.token.url");

    @Override
    public boolean valid() {
        String token = RequestParameterContextBuilder.get().getToken();
        //此处解码token并且获取用户ID
        Token tokenObj = decrypt(token);
        if (tokenObj == null) {
            return false;
        }
        // tokenObj.getValidTime() < new Date().getTime() || 判断Token的时间属性 TODO HESIN
        if (StringUtils.isEmpty(tokenObj.getAccountId()) ) { //|| !rsyncValidToken(token)
            return false;
        }
        RequestParameterContextBuilder.get().setAccountId(tokenObj.getAccountId());
        return true;
    }

    private Token decrypt(String token) {
        try {
            String[] tokenString = new String(RSAUtils.decryptByPublicKey(Base64.decodeBase64(token.getBytes()))).split("&&");
            if (tokenString.length != 2) {
                return null;
            }
            return new Token(tokenString[0], Long.parseLong(tokenString[1]));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * @param token token
     */
    private boolean rsyncValidToken(String token) {
        boolean result = false;
        if (!StringUtils.isEmpty(token)) {
            try {
                TAccount tAccount = TokenUtils.flushToken(token, null);
                if (tAccount != null) {
                    result = true;
                }
            }catch (AppException e){
                LogService.error("rsyncValidToken error",e);
            }
        }
        return result;
    }

    private class Token {
        private String accountId;
        private long validTime;

        Token(String accountId, long validTime) {
            this.accountId = accountId;
            this.validTime = validTime;
        }

        public String getAccountId() {
            return accountId;
        }

        long getValidTime() {
            return validTime;
        }
    }

}
