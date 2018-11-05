package com.appweb.demo.mvc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 请求需要解密
 * Created by zhangxiaoman on 2018/11/5.
 */
@Target(ElementType.METHOD) //修饰的范围对象为 method
@Retention(RetentionPolicy.RUNTIME) //即运行时保留
public @interface RequestDecrypt {
}
