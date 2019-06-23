package com.uncoverman.star.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uncoverman.star.system.entity.Dept;
import com.uncoverman.star.system.mapper.DeptMapper;
import com.uncoverman.star.system.service.IDeptService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author nfl
 * @since 2019-06-21
 */
@Service
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

    @Override
    public List<Dept> findAll(){
        return this.baseMapper.selectList(null);
    };
}
