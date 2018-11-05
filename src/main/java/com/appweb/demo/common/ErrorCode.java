package com.appweb.demo.common;

import lombok.Getter;

/**
 * Created by zhangxiaoman on 2018/11/5.
 */
@Getter
public enum ErrorCode {

    SESSION_ERROR("10000", "session过期");


    private String code;
    private String desc;

    ErrorCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
