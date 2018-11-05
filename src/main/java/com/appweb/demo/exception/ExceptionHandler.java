package com.appweb.demo.exception;

import com.appweb.demo.common.ErrorCode;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 统一异常处理
 * Created by zhangxiaoman on 2018/11/5.
 */
@Component
public class ExceptionHandler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        MappingJackson2JsonView view = new MappingJackson2JsonView();
        Map<String, Object> attributes = new HashMap<String, Object>();

        if(e instanceof SessionException){
            attributes.put("code", ErrorCode.SESSION_ERROR.getCode());
            attributes.put("msg", ErrorCode.SESSION_ERROR.getDesc());
        }
        view.setAttributesMap(attributes);
        ModelAndView mav = new ModelAndView();

        mav.setView(view);
        return mav;
    }
}
