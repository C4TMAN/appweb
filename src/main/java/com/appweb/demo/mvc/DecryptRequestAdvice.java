package com.appweb.demo.mvc;

import com.appweb.demo.mvc.annotation.RequestDecrypt;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

/**
 * 统一对请求解密处理(只支持带有@RequestBody的请求)
 * Created by zhangxiaoman on 2018/11/5.
 */
@ControllerAdvice(basePackages = "com.appweb.demo.web")
public class DecryptRequestAdvice implements RequestBodyAdvice {

    /**
     * 只处理带有 @RequestDecrypt 注解的方法
     * @param methodParameter
     * @param type
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return methodParameter.getMethodAnnotation(RequestDecrypt.class) != null;
    }

    /**
     *
     * @param httpInputMessage
     * @param methodParameter
     * @param type @RequestBody 请求类
     * @param aClass
     * @return
     * @throws IOException
     */
    @Override
    public HttpInputMessage beforeBodyRead(HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) throws IOException {
        InputStream ins = httpInputMessage.getBody();
        /**
         * TODO 解密操作
         */
        return httpInputMessage;
    }

    @Override
    public Object handleEmptyBody(Object o, HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return o;
    }



    @Override
    public Object afterBodyRead(Object o, HttpInputMessage httpInputMessage, MethodParameter methodParameter, Type type, Class<? extends HttpMessageConverter<?>> aClass) {
        return o;
    }
}
