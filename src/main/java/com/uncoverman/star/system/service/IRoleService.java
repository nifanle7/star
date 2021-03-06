package com.uncoverman.star.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.uncoverman.star.common.entity.QueryRequest;
import com.uncoverman.star.system.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author nfl
 * @since 2019-06-21
 */
public interface IRoleService extends IService<Role> {

    /**
     * 通过用户名查找用户角色
     *
     * @param username 用户名
     * @return 用户角色集合
     */
    List<Role> findUserRole(String username);

    /**
     * 查找所有角色
     *
     * @param role 角色对象（用于传递查询条件）
     * @return 角色集合
     */
    List<Role> findAll(Role role);

    /**
     * 查找所有角色（分页）
     *
     * @param role    角色对象（用于传递查询条件）
     * @param request request
     * @return IPage
     */
    IPage<Role> findAll(Role role, QueryRequest request);

    /**
     * 通过角色名称查找相应角色
     *
     * @param roleName 角色名称
     * @return 角色
     */
    Role findByRoleName(String roleName);

    /**
     * 新增角色
     *
     * @param role 待新增的角色
     */
    void addRole(Role role);

    /**
     * 修改角色
     *
     * @param role 待修改的角色
     */
    void updateRole(Role role);


    /**
     * 删除角色
     *
     * @param roleIds 待删除角色的 id
     */
    void deleteRoles(String roleIds);

}
