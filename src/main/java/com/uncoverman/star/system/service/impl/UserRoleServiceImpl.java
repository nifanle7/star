package com.uncoverman.star.system.service.impl;

import com.uncoverman.star.system.entity.UserRole;
import com.uncoverman.star.system.mapper.UserRoleMapper;
import com.uncoverman.star.system.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色关联表 服务实现类
 * </p>
 *
 * @author nfl
 * @since 2019-06-21
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
