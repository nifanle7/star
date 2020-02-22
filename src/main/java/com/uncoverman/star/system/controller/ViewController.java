package com.uncoverman.star.system.controller;

import com.uncoverman.star.common.utils.DateUtil;
import com.uncoverman.star.system.entity.User;
import com.uncoverman.star.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by NFL on 2019/6/26.
 */
@Controller
public class ViewController {

    @Autowired
    private IUserService userService;

    @GetMapping("/")
    public String redirectIndex() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index() {
        return "views/index";
    }
    @GetMapping("views/index")
    public String indexView() {
        return "views/index";
    }

    @GetMapping("/login")
    public String login() {
        return "views/login";
    }

    @GetMapping("views/system/user")
    public String userView() {
        return "views/system/user";
    }

    @GetMapping("views/system/userAdd")
    public String userAddView() {
        return "views/system/userAdd";
    }

//    @GetMapping("views/system/userUpdate")
//    public String userUpdateView() {
//        return "views/system/userUpdate";
//    }

    @GetMapping("views/system/userUpdate/{username}")
    public String systemUserUpdate(@PathVariable String username, Model model) {
        resolveUserModel(username, model, false);
        return "views/system/userUpdate";
    }

    @GetMapping("views/system/dept")
    public String deptView() {
        return "views/system/dept";
    }

    @GetMapping("views/system/menu")
    public String menuView() {
        return "views/system/menu";
    }

    @GetMapping("views/system/role")
    public String roleView() {
        return "views/system/role";
    }

    private void resolveUserModel(String username, Model model, Boolean transform) {
        User user = userService.findByUsername(username);
        model.addAttribute("user", user);
        if (transform) {
            String ssex = user.getSex();
            if (User.SEX_MALE.equals(ssex)) user.setSex("男");
            else if (User.SEX_FEMALE.equals(ssex)) user.setSex("女");
            else user.setSex("保密");
        }
        if (user.getLastLoginTime() != null)
            model.addAttribute("lastLoginTime", DateUtil.getDateFormat(user.getLastLoginTime(), DateUtil.FULL_TIME_SPLIT_PATTERN));
    }


}

