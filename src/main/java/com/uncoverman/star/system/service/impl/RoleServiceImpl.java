package com.uncoverman.star.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.uncoverman.star.common.entity.QueryRequest;
import com.uncoverman.star.system.entity.Role;
import com.uncoverman.star.system.mapper.RoleMapper;
import com.uncoverman.star.system.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author nfl
 * @since 2019-06-21
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Override
    public List<Role> findUserRole(String username) {
        return this.baseMapper.findUserRole(username);
    }

    @Override
    public List<Role> findAll(Role role) {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(role.getRoleName())){
            queryWrapper.like("role_name",role.getRoleName());
        }
        return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    public IPage<Role> findAll(Role role, QueryRequest request) {
        Page<Role> rolePage = new Page<>(request.getPageNum(),request.getPageSize()) ;
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(role.getRoleName())){
            queryWrapper.like("role_name",role.getRoleName());
        }
        return this.baseMapper.selectPage(rolePage,queryWrapper);
    }

    @Override
    public Role findByRoleName(String roleName) {
        return null;
    }

    @Override
    public void addRole(Role role) {
        role.setCreateTime(new Date());
        this.baseMapper.insert(role);
    }

    @Override
    public void updateRole(Role role) {
        role.setModifyTime(new Date());
        this.baseMapper.updateById(role);

    }

    @Override
    public void deleteRoles(String roleIds) {
        String[] roleIdArray = roleIds.split(StringPool.COMMA);
        for (String roleId : roleIdArray){
            this.baseMapper.deleteById(roleId);
        }
    }
}
