package com.uncoverman.star.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uncoverman.star.common.entity.QueryRequest;
import com.uncoverman.star.common.utils.MD5Util;
import com.uncoverman.star.system.entity.User;
import com.uncoverman.star.system.mapper.UserMapper;
import com.uncoverman.star.system.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author nfl
 * @since 2019-06-21
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Override
    public IPage<User> findAll(User user, QueryRequest queryRequest) {
        Page<User> page = new Page<>(queryRequest.getPageNum(),queryRequest.getPageSize());
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("user_id");
        return this.baseMapper.selectPage(page,wrapper);
    }

    @Override
    public void createUser(User user) {
        user.setCreateTime(new Date());
        user.setStatus(User.STATUS_VALID);
        user.setAvatar(User.DEFAULT_AVATAR);
        user.setTheme(User.THEME_BLACK);
        user.setIsTab(User.TAB_OPEN);
        user.setPassword(MD5Util.encrypt(user.getUsername(), User.DEFAULT_PASSWORD));
        save(user);
    }
}
