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

    @GetMapping("/home")
    public String home() {
        return "/home";
    }

    @GetMapping("views/system/user/add")
    public String test() {
        return "/system/user/userAdd";
    }
}

