package com.uncoverman.star.common.entity;

import org.springframework.http.HttpStatus;

import java.util.HashMap;


public class WebResponse extends HashMap<String, Object> {

    public WebResponse code(HttpStatus status) {
        this.put("code", status.value());
        return this;
    }

    public WebResponse message(String message) {
        this.put("message", message);
        return this;
    }

    public WebResponse data(Object data) {
        this.put("data", data);
        return this;
    }

    public WebResponse success() {
        this.code(HttpStatus.OK);
        return this;
    }

    public WebResponse fail() {
        this.code(HttpStatus.INTERNAL_SERVER_ERROR);
        return this;
    }

    @Override
    public WebResponse put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
