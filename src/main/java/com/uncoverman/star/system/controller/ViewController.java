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
        return "/index";
    }

    @GetMapping("/login")
    public String login() {
        return "febs/views/login";
    }

    @GetMapping("views/system/user/add")
    public String toAddUser() {
        return "febs/views/system/user/userAdd";
    }

    @GetMapping("views/index")
    public String toIndex() {
        return "views/index";
    }

}

