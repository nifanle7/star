package com.uncoverman.star.system.controller;


import com.uncoverman.star.common.controller.BaseController;
import com.uncoverman.star.common.entity.QueryRequest;
import com.uncoverman.star.common.entity.WebResponse;
import com.uncoverman.star.system.entity.User;
import com.uncoverman.star.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author nfl
 * @since 2019-06-21
 */
@RestController
@RequestMapping("/system/user")
public class UserController extends BaseController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("/list")
    public WebResponse findAll(User user, QueryRequest queryRequest){
        WebResponse webResponse = new WebResponse();
        webResponse.data(iUserService.findAll(user,queryRequest));
        return webResponse;
    }

}
