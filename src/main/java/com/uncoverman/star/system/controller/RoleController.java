package com.uncoverman.star.system.controller;


import com.uncoverman.star.common.entity.QueryRequest;
import com.uncoverman.star.common.entity.WebResponse;
import com.uncoverman.star.common.exception.WebException;
import com.uncoverman.star.system.entity.Role;
import com.uncoverman.star.system.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.uncoverman.star.common.controller.BaseController;

import javax.validation.constraints.NotBlank;
import java.util.Map;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author nfl
 * @since 2019-06-21
 */
@RestController
@RequestMapping("/system/role")
public class RoleController extends BaseController {

    @Autowired
    private IRoleService roleService;

    @GetMapping
    public WebResponse findList(Role role) {
        return new WebResponse().success().data(roleService.findRoles(role));
    }

    @GetMapping("list")
    public WebResponse findPage(Role role, QueryRequest request) {
        Map<String, Object> dataTable = getDataTable(this.roleService.findRoles(role, request));
        return new WebResponse().success().data(dataTable);
    }

    @PostMapping
    public WebResponse addRole(Role role) throws WebException {
        try {
            this.roleService.addRole(role);
            return new WebResponse().success();
        } catch (Exception e) {
            String message = "新增角色失败";
            throw new WebException(message);
        }
    }

    @GetMapping("delete/{roleIds}")
    public WebResponse deleteRoles(@NotBlank(message = "{required}") @PathVariable String roleIds) throws WebException {
        try {
            this.roleService.deleteRoles(roleIds);
            return new WebResponse().success();
        } catch (Exception e) {
            String message = "删除角色失败";
            throw new WebException(message);
        }
    }

    @PostMapping("update")
    public WebResponse updateRole(Role role) throws WebException {
        try {
            this.roleService.updateRole(role);
            return new WebResponse().success();
        } catch (Exception e) {
            String message = "修改角色失败";
            throw new WebException(message);
        }
    }

}
