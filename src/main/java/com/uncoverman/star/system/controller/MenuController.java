package com.uncoverman.star.system.controller;


import com.uncoverman.star.common.entity.WebResponse;
import com.uncoverman.star.system.entity.Menu;
import com.uncoverman.star.system.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.uncoverman.star.common.controller.BaseController;



/**
 * <p>
 * 菜单表 前端控制器
 * </p>
 *
 * @author nfl
 * @since 2019-06-21
 */
@RestController
@RequestMapping("/system/menu")
public class MenuController extends BaseController {

    @Autowired
    private IMenuService menuService;

    @GetMapping("/list")
    public WebResponse findAll(Menu menu){
        return new WebResponse().success().data(menuService.findMenuList(menu));
    }

    @PostMapping("/add")
    public WebResponse addMenu(Menu menu){
        menuService.addMenu(menu);
        return new WebResponse().success();
    }

    @PostMapping("/update")
    public WebResponse updateMenu(Menu menu){
        menuService.updateMenu(menu);
        return new WebResponse().success();
    }

    @PostMapping("/delete/{menuIds}")
    public WebResponse deleteMenus(@PathVariable String menuIds){
        menuService.deleteMenus(menuIds);
        return new WebResponse().success();
    }
}
