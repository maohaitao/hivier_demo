package com.bikemanage.web.common;


import com.bikemanage.common.Constants;
import com.bikemanage.common.tools.MD5Utils;
import com.bikemanage.dto.common.TreeNode;
import com.bikemanage.model.authorized.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

import java.util.List;

/**
 * Created by 700bike on 2017/2/20.
 */
public class UserSession {
    private static final String USER = "USER";

    public static void setMenu(List<TreeNode> treeNodes) {
        Subject subject = SecurityUtils.getSubject();
        subject.getSession().setAttribute(Constants.SESSION_MENU, treeNodes);
    }

    public static User getUser() {
        Subject subject = SecurityUtils.getSubject();
        return (User) subject.getPrincipal();
    }

    public static void setUser(User user) {
        Subject subject = SecurityUtils.getSubject();
        subject.getSession().setAttribute(USER, user);
    }

    public static boolean isLogin() {
        Subject subject = SecurityUtils.getSubject();
        return subject.isAuthenticated();
    }

    public static boolean login(String userName, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, MD5Utils.MD5(password));
        try {
            subject.login(token);
            return isLogin();
        } catch (AuthenticationException e) {
            return false;
        }
    }

    public static void logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }
}
