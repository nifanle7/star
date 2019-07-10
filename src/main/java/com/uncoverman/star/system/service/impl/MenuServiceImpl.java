package com.uncoverman.star.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uncoverman.star.common.entity.MenuTree;
import com.uncoverman.star.common.utils.TreeUtil;
import com.uncoverman.star.system.entity.Menu;
import com.uncoverman.star.system.mapper.MenuMapper;
import com.uncoverman.star.system.service.IMenuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 菜单表 服务实现类
 * </p>
 *
 * @author nfl
 * @since 2019-06-21
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {
    @Override
    public List<Menu> findUserPermissions(String username) {
        return this.baseMapper.findUserPermissions(username);
    }

    @Override
    public MenuTree<Menu> findUserMenus(String username) {
        List<Menu> menuList = this.baseMapper.findUserMenus(username);
        List<MenuTree<Menu>> trees = this.convertMenus(menuList);
        return TreeUtil.buildMenuTree(trees);
    }

    @Override
    public MenuTree<Menu> findMenus(Menu menu) {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(menu.getMenuName())){
            queryWrapper.like("menu_name",menu.getMenuName());
        }
        List<Menu> menus = this.baseMapper.selectList(queryWrapper);
        List<MenuTree<Menu>> trees = this.convertMenus(menus);
        return TreeUtil.buildMenuTree(trees);
    }

    @Override
    public List<Menu> findMenuList(Menu menu) {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(menu.getMenuName())){
            queryWrapper.like("menu_name",menu.getMenuName());
        }
        queryWrapper.orderByAsc("menu_id");
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    public void addMenu(Menu menu) {
        menu.setCreateTime(new Date());
        this.baseMapper.insert(menu);
    }

    @Override
    public void updateMenu(Menu menu) {
        menu.setModifyTime(new Date());
        this.baseMapper.updateById(menu);
    }

    @Override
    public void deleteMenus(String menuIds) {
        String[] menuIdArray = menuIds.split(StringPool.COMMA);
        for (String menuId : menuIdArray){
            this.baseMapper.deleteById(menuId);
        }

    }

    private List<MenuTree<Menu>> convertMenus(List<Menu> menus) {
        List<MenuTree<Menu>> trees = new ArrayList<>();
        menus.forEach(menu -> {
            MenuTree<Menu> tree = new MenuTree<>();
            tree.setId(String.valueOf(menu.getMenuId()));
            tree.setParentId(String.valueOf(menu.getParentId()));
            tree.setTitle(menu.getMenuName());
            tree.setIcon(menu.getIcon());
            tree.setHref(menu.getUrl());
            tree.setData(menu);
            trees.add(tree);
        });
        return trees;
    }
}
