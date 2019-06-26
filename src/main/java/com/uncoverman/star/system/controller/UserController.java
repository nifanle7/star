package com.uncoverman.star.system.controller;


import com.uncoverman.star.common.controller.BaseController;
import com.uncoverman.star.common.entity.QueryRequest;
import com.uncoverman.star.common.entity.WebResponse;
import com.uncoverman.star.common.exception.WebException;
import com.uncoverman.star.system.entity.User;
import com.uncoverman.star.system.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author nfl
 * @since 2019-06-21
 */
@Slf4j
@RestController
@RequestMapping("/system/user")
public class UserController extends BaseController {

    @Autowired
    private IUserService userService;

    @GetMapping("/list")
    public WebResponse findAll(User user, QueryRequest queryRequest){
        Map<String,Object> dataTable = getDataTable(userService.findAll(user,queryRequest));
        return new WebResponse().success().data(dataTable);
    }

    @PostMapping("/add")
    public WebResponse addUser(User user) throws WebException{
        try {
            this.userService.createUser(user);
            return new WebResponse().success();
        } catch (Exception e) {
            String message = "新增用户失败";
            log.error(message, e);
            throw new WebException(message);
        }
    }

}
