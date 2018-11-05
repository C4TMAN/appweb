package com.appweb.demo.mvc;

import com.appweb.demo.mvc.annotation.RequestDecrypt;
import com.appweb.demo.mvc.annotation.ResponseEncrypt;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * 只对controller中加了@ResponseBody注解的方法有效
 * Created by zhangxiaoman on 2018/11/5.
 */
@ControllerAdvice(basePackages = "com.appweb.demo.web")
public class EncryptResponseAdvice implements ResponseBodyAdvice {
    private static Gson GSON = new GsonBuilder().create();
    /**
     * 只对加了@ResponseEncrypt注解的方法有效
     * @param methodParameter
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return methodParameter.getMethodAnnotation(ResponseEncrypt.class) != null;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        /**
         * TODO 加密返回值
         * o 统一包装成BaseResponse
         */
        System.out.println(GSON.toJson(o));
        return o;
    }
}
