package com.uncoverman.star.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by NFL on 2019/6/26.
 */
@Controller
public class ViewController {
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

    @GetMapping("views/system/dept")
    public String deptView() {
        return "views/system/dept";
    }


}

