package com.cm.common.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @项目名： CM
 * @包名： com.cm.common.interceptor
 * @类名： LoginOperInterceptor
 * @类描述：
 * @时间： 2016-11-24
 * @编写者： 修峻青
 */
public class LoginOperInterceptor implements HandlerInterceptor {

    private static Logger logger = LoggerFactory.getLogger( LoginInterceptor.class );

    /**
     * 请求分发前处理方法
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info( "\n——————————————————————————————————进入登录逻辑拦截器——————————————————————————————————" );
        return true;
    }

    /**
     * 请求处理完，分发ModelandView前方法
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //如果登录验证通过
        if(modelAndView.getModel().get(Constant.RETURN_MESSAGE).equals(Constant.OPER_SUCCESS)) {
            //保存用户名,用户类型和用户权限等级信息到Session
            request.getSession().setAttribute(Constant.USER_ID, modelAndView.getModel().get(Constant.USER_ID));
            request.getSession().setAttribute(Constant.MANAGER_FLAG,modelAndView.getModel().get(Constant.MANAGER_FLAG));
            request.getSession().setAttribute(Constant.USER_AUTH,modelAndView.getModel().get(Constant.USER_AUTH));
            request.getSession().setAttribute(Constant.USER_NAME,modelAndView.getModel().get(Constant.USER_NAME));
            modelAndView.setViewName("info");
        }
        else {
            modelAndView.setViewName("index");
        }
    }

    /**
     * 分发ModelandView后方法
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info( "\n——————————————————————————————————结束登录逻辑拦截器——————————————————————————————————" );
    }

}
