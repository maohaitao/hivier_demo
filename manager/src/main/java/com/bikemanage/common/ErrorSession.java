package com.bikemanage.common;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * 描述：
 * 创建时间：15/7/22
 * 作者：yanghui
 */
public class ErrorSession {
    private static final String USER_ERROR_MESSAGE = "USER_ERROR_MESSAGE";
    private static final String USER_ERROR_CODE = "USER_ERROR_CODE";
    private static String[] CHARS = new String[]{"0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9"};
    private String errorCode;


    public ErrorSession(Exception e) {
        Session session = getSession();
        this.errorCode = ErrorSession.generateShortUUID();
        session.setAttribute(USER_ERROR_CODE, errorCode);
        session.setAttribute(USER_ERROR_MESSAGE, e.getMessage() == null ? "空异常或者页面数据异常" : e.getMessage());
    }

    private static String generateShortUUID() {
        StringBuilder shortBuffer = new StringBuilder();
        String uuid = UUID.randomUUID().toString().replace("-", "");
        for (int i = 0; i < 6; i++) {
            String str = uuid.substring(i * 4, i * 4 + 4);
            int x = Integer.parseInt(str, 16);
            shortBuffer.append(CHARS[x % 10]);
        }
        return shortBuffer.toString();

    }

    public static String getErrorCode(HttpServletRequest request) {
        Object o = request.getSession().getAttribute(USER_ERROR_CODE);
        request.getSession().removeAttribute(USER_ERROR_CODE);
        if (o != null) {
            return o.toString();
        }
        return null;
    }

    public static String getErrorMessage(HttpServletRequest request) {
        Object o = request.getSession().getAttribute(USER_ERROR_MESSAGE);
        request.getSession().removeAttribute(USER_ERROR_MESSAGE);
        if (o != null) {
            return o.toString();
        }
        return null;
    }

    private Session getSession() {
        Subject subject = SecurityUtils.getSubject();
        return subject.getSession();
    }

    public String getErrorCode() {
        return errorCode;
    }

}
