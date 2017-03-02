package com.bikemanage.controller;

import com.bikemanage.common.Constants;
import com.bikemanage.dto.common.JsonResult;
import com.bikemanage.model.authorized.User;
import com.bikemanage.service.login.LoginService;
import com.bikemanage.service.login.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by 700bike on 2017/2/16.
 */
@Controller
@RequestMapping()
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login", produces = Constants.PRODUCES_JSON)
    @ResponseBody
    public String login(@RequestParam("username") String userName, @RequestParam("password") String passWord, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String redirect = "";

        JsonResult jsonResult = new JsonResult();
        if (UserSession.isLogin()) {
            User user = UserSession.getUser();
            user.setPassword("");
            jsonResult.put("user", user);
            jsonResult.put("menus", loginService.queryMenu(UserSession.getUser().getId()));
            return jsonResult.success();
        }


        if (UserSession.login(userName, passWord)) {
            User user = UserSession.getUser();
            UserSession.setUser(user);
            if (user != null) {
                if (user.getErrorCount() >= 5) {
                    return jsonResult.failure("连续5次登录密码错误，当天该账户不能再次登录。提示用户：今天错误次数过多账户已被锁定，请明日再试或请联系客服。");
                }
            }
        } else {
            return jsonResult.failure("账号或密码输入错误");
        }
        User user = UserSession.getUser();
        user.setPassword("");
        jsonResult.put("user", user);
        jsonResult.put("menus", loginService.queryMenu(UserSession.getUser().getId()));
        return jsonResult.success();
    }

    @RequestMapping(value = "/verifyLogin", produces = Constants.PRODUCES_JSON)
    @ResponseBody
    public String verifyLogin() {
        JsonResult jsonResult = new JsonResult();
        if (UserSession.isLogin()) {
            return jsonResult.success();
        }
        return jsonResult.failure();
    }
}
