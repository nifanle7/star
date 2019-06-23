package com.uncoverman.star.system.service.impl;

import com.uncoverman.star.system.entity.Role;
import com.uncoverman.star.system.mapper.RoleMapper;
import com.uncoverman.star.system.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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

}
