package com.uncoverman.star.system.controller;


import com.uncoverman.star.common.controller.BaseController;
import com.uncoverman.star.common.entity.QueryRequest;
import com.uncoverman.star.common.entity.WebResponse;
import com.uncoverman.star.system.entity.Dept;
import com.uncoverman.star.system.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 部门表 前端控制器
 * </p>
 *
 * @author nfl
 * @since 2019-06-21
 */
@RestController
@RequestMapping("/system/dept")
public class DeptController extends BaseController {

    @Autowired
    private IDeptService deptService;

    @GetMapping("/list")
    public WebResponse findAll(Dept dept, QueryRequest queryRequest){
        WebResponse webResponse = new WebResponse();
        webResponse.data(deptService.findAll(dept,queryRequest));
        return webResponse.success();
    }

    @PostMapping("/add")
    public WebResponse addDept(Dept dept){

        return new WebResponse().success();
    }
}
