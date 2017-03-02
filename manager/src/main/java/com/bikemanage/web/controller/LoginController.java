package com.bikemanage.web.controller;

import com.bikemanage.common.Constants;
import com.bikemanage.dto.common.JsonResult;
import com.bikemanage.model.authorized.User;
import com.bikemanage.service.LoginService;
import com.bikemanage.web.common.UserSession;
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
@RequestMapping("/banana")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login", produces = Constants.PRODUCES_JSON)
    @ResponseBody
    public String login(@RequestParam("username") String userName, @RequestParam("password") String passWord, ModelMap model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        String redirect = "";

        if (UserSession.isLogin()) {
            return redirect;
        }

        JsonResult jsonResult = new JsonResult();

        if (UserSession.login(userName, passWord)) {
            User user = UserSession.getUser();
            UserSession.setUser(user);
            if (user != null) {
                if (user.getErrorCount() >= 5) {
                    return jsonResult.failure("连续5次登录密码错误，当天该账户不能再次登录。提示用户：今天错误次数过多账户已被锁定，请明日再试或请联系客服。");
                }
                // 将相关的菜单功能添加到session
                UserSession.setMenu(loginService.queryMenu(user.getId()));
            }
        } else {
            return jsonResult.failure("账号或密码输入错误");
        }

        return jsonResult.success();
    }
}
