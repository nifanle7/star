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
    List<Menu> findUserMenus(String username);
}
