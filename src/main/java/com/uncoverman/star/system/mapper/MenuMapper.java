package com.uncoverman.star.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.uncoverman.star.system.entity.Menu;

import java.util.List;

/**
 * <p>
 * 菜单表 Mapper 接口
 * </p>
 *
 * @author nfl
 * @since 2019-06-21
 */
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 查找用户权限集
     *
     * @param username 用户名
     * @return 用户权限集合
     */
    List<Menu> findUserPermissions(String username);

    /**
     * 查找用户菜单集合
     *
     * @param username 用户名
     * @return 用户菜单集合
     */
    List<Menu> findUserMenus(String username);

}
