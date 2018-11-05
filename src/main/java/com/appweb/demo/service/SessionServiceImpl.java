package com.appweb.demo.service;

import com.appweb.demo.exception.SessionException;
import org.springframework.stereotype.Service;

/**
 * Created by zhangxiaoman on 2018/11/5.
 */
@Service
public class SessionServiceImpl implements SessionService {
    @Override
    public boolean check(String sessionId) throws SessionException {
       return true;
    }
}
