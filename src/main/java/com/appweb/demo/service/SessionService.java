package com.appweb.demo.service;

import com.appweb.demo.exception.SessionException;

/**
 * Created by zhangxiaoman on 2018/11/5.
 */
public interface SessionService {
    /**
     * 校验session是否过期
     * @param sessionId
     * @return
     */
    boolean check(String sessionId) throws SessionException;
}
