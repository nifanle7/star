package com.uncoverman.star.common.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.HashMap;
import java.util.Map;

public class BaseController {

//    protected static Subject getSubject() {
//        return SecurityUtils.getSubject();
//    }
//
//    protected User getCurrentUser() {
//        return (User) getSubject().getPrincipal();
//    }
//
//    protected Session getSession() {
//        return getSubject().getSession();
//    }
//
//    protected Session getSession(Boolean flag) {
//        return getSubject().getSession(flag);
//    }
//
//    protected void login(AuthenticationToken token) {
//        getSubject().login(token);
//    }
//
    protected Map<String, Object> getDataTable(IPage<?> pageInfo) {
        Map<String, Object> data = new HashMap<>();
        // 明细
        data.put("rows", pageInfo.getRecords());
        // 总数
        data.put("total", pageInfo.getTotal());
        return data;
    }

}
