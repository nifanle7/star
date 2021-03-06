package com.uncoverman.star.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.uncoverman.star.common.entity.QueryRequest;
import com.uncoverman.star.system.entity.User;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author nfl
 * @since 2019-06-21
 */
public interface IUserService extends IService<User> {

    /**
     * 查找用户列表
     *
     * @param user
     * @param queryRequest
     * @return
     */
    IPage<User> findAll(User user, QueryRequest queryRequest);

    /**
     * 查找用户详细信息
     *
     * @param queryRequest
     * @param user    用户对象，用于传递查询条件
     * @return IPage
     */
    IPage<User> findUserDetail(User user, QueryRequest queryRequest);

    /**
     * 新增用户
     *
     * @param user user
     */
    void addUser(User user);

    /**
     * 修改用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除用户
     * @param userIds
     */
    void deleteUsers(String[] userIds);

    /**
     * 查找用户
     * @param username
     * @return
     */
    User findByUsername(String username);
}
