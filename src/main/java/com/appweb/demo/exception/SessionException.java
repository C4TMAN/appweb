package com.appweb.demo.exception;

/**
 * session错误异常
 * Created by zhangxiaoman on 2018/11/5.
 */
public class SessionException extends Exception{

    public SessionException() {
        super("session无效");
    }

}
