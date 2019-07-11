package com.uncoverman.star.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.uncoverman.star.common.entity.QueryRequest;
import com.uncoverman.star.system.entity.Dept;

/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author nfl
 * @since 2019-06-21
 */
public interface IDeptService extends IService<Dept> {
    IPage<Dept> findAll(Dept dept, QueryRequest queryRequest);

    void addDept(Dept dept);
    void updateDept(Dept dept);
    void deleteDepts(String deptIds);
}
