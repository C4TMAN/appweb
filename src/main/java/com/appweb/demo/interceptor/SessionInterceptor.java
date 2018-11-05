package com.appweb.demo.interceptor;

import com.appweb.demo.common.SpringUtils;
import com.appweb.demo.service.SessionService;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangxiaoman on 2018/11/5.
 */

public class SessionInterceptor extends HandlerInterceptorAdapter {

    //不需要校验session的url
    private static List<String> excludePathPatterns = new ArrayList<String>();
    static {
        excludePathPatterns.add("/index");
    }

    /**
     * preHandle在业务处理器处理请求之前被调用。预处理。
     * 这里校验session
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
        if (excludePathPatterns.contains(request.getRequestURI())) {
            return true;
        }
        String sessionId = request.getHeader("sessionId");
        SessionService sessionService = SpringUtils.getBean(SessionService.class);

        return  (sessionService.check(sessionId));
    }

    /**
     * postHandle在业务处理器处理请求执行完成后，生成视图之前执行。
     * 请求后处理（调用了Service并返回ModelAndView，但未进行页面渲染），有机会修改ModelAndView；
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * afterCompletion在DispatcherServlet
     * 完全处理完请求后被调用，可用于清理资源等。
     * 返回处理（已经渲染了页面），可以根据ex是否为null判断是否发生了异常，进行日志记录；
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
