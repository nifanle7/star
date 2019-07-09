package com.uncoverman.star.system.mapper;

import com.uncoverman.star.system.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 角色表 Mapper 接口
 * </p>
 *
 * @author nfl
 * @since 2019-06-21
 */
public interface RoleMapper extends BaseMapper<Role> {
    /**
     * 通过用户名查找用户角色
     *
     * @param username 用户名
     * @return 用户角色集合
     */
    List<Role> findUserRole(String username);
}
