package com.uncoverman.star.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.uncoverman.star.system.entity.Dept;

import java.util.List;

/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author nfl
 * @since 2019-06-21
 */
public interface IDeptService extends IService<Dept> {
    List<Dept> findAll();
}
