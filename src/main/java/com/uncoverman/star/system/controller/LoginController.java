package com.uncoverman.star.system.controller;

import com.uncoverman.star.common.controller.BaseController;
import com.uncoverman.star.common.entity.WebResponse;
import com.uncoverman.star.common.exception.WebException;
import com.uncoverman.star.common.utils.MD5Util;
import com.uncoverman.star.system.service.IUserService;
import org.apache.shiro.authc.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;

/**
 * Created by NFL on 2019/6/27.
 */
@RestController
public class LoginController extends BaseController {
    @Autowired
    private IUserService userService;

    @PostMapping("login")
    public WebResponse login(
            @NotBlank(message = "{required}") String username,
            @NotBlank(message = "{required}") String password,
            //@NotBlank(message = "{required}") String verifyCode,
            boolean rememberMe,
            HttpServletRequest request) throws WebException {
        //if (!CaptchaUtil.verify(verifyCode, request)) {
        //    throw new WebException("验证码错误！");
        //}
        password = MD5Util.encrypt(username.toLowerCase(), password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        try {
            super.login(token);
            // 保存登录日志
            //LoginLog loginLog = new LoginLog();
            //loginLog.setUsername(username);
            //loginLog.setSystemBrowserInfo();
            //this.loginLogService.saveLoginLog(loginLog);

            return new WebResponse().success();
        } catch (UnknownAccountException | IncorrectCredentialsException | LockedAccountException e) {
            throw new WebException(e.getMessage());
        } catch (AuthenticationException e) {
            throw new WebException("认证失败！");
        }
    }
}
