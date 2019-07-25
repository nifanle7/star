package com.uncoverman.star.system.controller;


import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.uncoverman.star.common.controller.BaseController;
import com.uncoverman.star.common.entity.QueryRequest;
import com.uncoverman.star.common.entity.WebResponse;
import com.uncoverman.star.common.exception.WebException;
import com.uncoverman.star.system.entity.User;
import com.uncoverman.star.system.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public WebResponse findUserDetail(User user, QueryRequest queryRequest){
        Map<String,Object> dataTable = getDataTable(userService.findUserDetail(user,queryRequest));
        return new WebResponse().success().data(dataTable);
    }

    @GetMapping("/find/{username}")
    public User findByUsername(@PathVariable String username){
        return userService.findByUsername(username);
    }

    @PostMapping("/add")
    public WebResponse addUser(User user) throws WebException{
        try {
            userService.addUser(user);
            return new WebResponse().success();
        } catch (Exception e) {
            String message = "新增用户失败";
            log.error(message, e);
            throw new WebException(message);
        }
    }

    @PostMapping("/update")
    public WebResponse updateUser(User user) throws WebException{
        try {
            userService.updateUser(user);
            return new WebResponse().success();
        } catch (Exception e) {
            String message = "新增用户失败";
            log.error(message, e);
            throw new WebException(message);
        }
    }

    @PostMapping("/delete/{userIds}")
    public WebResponse deleteUsers(@PathVariable String userIds) throws WebException{
        try {
            String[] ids = userIds.split(StringPool.COMMA);
            userService.deleteUsers(ids);
            return new WebResponse().success();
        } catch (Exception e) {
            String message = "删除用户失败";
            log.error(message, e);
            throw new WebException(message);
        }
    }

}
