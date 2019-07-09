package com.uncoverman.star.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uncoverman.star.common.entity.MenuTree;
import com.uncoverman.star.system.entity.Menu;
import com.uncoverman.star.system.mapper.MenuMapper;
import com.uncoverman.star.system.service.IMenuService;
import org.springframework.stereotype.Service;

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
        return null;
    }

    @Override
    public MenuTree<Menu> findUserMenus(String username) {
        return null;
    }

    @Override
    public MenuTree<Menu> findMenus(Menu menu) {
        //QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        //if (StringUtils.isNotBlank(menu.getMenuName())){
        //
        //}
        //List<Menu> list = this.baseMapper.selectList(queryWrapper);
        //List<MenuTree<Menu>> trees = this.convertMenus(menus);
        //return TreeUtil.buildMenuTree(list);
        return null;
    }

    @Override
    public List<Menu> findMenuList(Menu menu) {
        return null;
    }

    @Override
    public void createMenu(Menu menu) {
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

    }
}
