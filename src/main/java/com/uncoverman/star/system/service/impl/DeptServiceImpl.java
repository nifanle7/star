package com.uncoverman.star.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uncoverman.star.common.entity.DeptTree;
import com.uncoverman.star.common.entity.QueryRequest;
import com.uncoverman.star.common.utils.TreeUtil;
import com.uncoverman.star.system.entity.Dept;
import com.uncoverman.star.system.mapper.DeptMapper;
import com.uncoverman.star.system.service.IDeptService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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
    public List<DeptTree<Dept>> findAll() {
        List<Dept> depts = this.baseMapper.selectList(new QueryWrapper<>());
        List<DeptTree<Dept>> trees = this.convertDepts(depts);
        return TreeUtil.buildDeptTree(trees);
    }

    @Override
    public List<DeptTree<Dept>> findAll(Dept dept) {
        QueryWrapper<Dept> queryWrapper = new QueryWrapper<>();

        if (StringUtils.isNotBlank(dept.getDeptName()))
            queryWrapper.lambda().eq(Dept::getDeptName, dept.getDeptName());
        queryWrapper.lambda().orderByAsc(Dept::getOrderNum);

        List<Dept> depts = this.baseMapper.selectList(queryWrapper);
        List<DeptTree<Dept>> trees =  this.convertDepts(depts);
        return TreeUtil.buildDeptTree(trees);
    }

    @Override
    public IPage<Dept> findAll(Dept dept, QueryRequest queryRequest){
        Page<Dept> page = new Page<>(queryRequest.getPageNum(),queryRequest.getPageSize());
        QueryWrapper queryWrapper = new QueryWrapper();
        if (StringUtils.isNotBlank(dept.getDeptName())){
            queryWrapper.like("dept_name",dept.getDeptName());
        }
        queryWrapper.orderByAsc("dept_name");
        return this.baseMapper.selectPage(page,queryWrapper);
    };

    @Override
    public void addDept(Dept dept) {
        dept.setCreateTime(new Date());
        this.baseMapper.insert(dept);
    }

    @Override
    public void updateDept(Dept dept) {
        dept.setModifyTime(new Date());
        this.baseMapper.updateById(dept);
    }

    @Override
    public void deleteDepts(String deptIds) {
        List<String> deptIdList = Arrays.asList(deptIds.split(StringPool.COMMA));
        this.baseMapper.deleteBatchIds(deptIdList);
    }

    private List<DeptTree<Dept>> convertDepts(List<Dept> depts){
        List<DeptTree<Dept>> trees = new ArrayList<>();
        depts.forEach(dept -> {
            DeptTree<Dept> tree = new DeptTree<>();
            tree.setId(String.valueOf(dept.getDeptId()));
            tree.setParentId(String.valueOf(dept.getParentId()));
            tree.setName(dept.getDeptName());
            tree.setData(dept);
            trees.add(tree);
        });
        return trees;
    }
}
