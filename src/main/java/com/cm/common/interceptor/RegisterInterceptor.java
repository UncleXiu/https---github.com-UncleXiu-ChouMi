package com.cm.common.interceptor;

import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @项目名： CM
 * @包名： com.cm.common.interceptor
 * @类名： RegisterInterceptor
 * @类描述：
 * @时间： 2016-11-24
 * @编写者： 修峻青
 */
public class RegisterInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if(modelAndView.getModelMap().get(Constant.RETURN_MESSAGE).equals(Constant.OPER_SUCCESS)){
            modelAndView.setViewName("info");
            System.out.println("注册成功");
        }
        else {
            modelAndView.setViewName("index");
            System.out.println("注册失败");
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
