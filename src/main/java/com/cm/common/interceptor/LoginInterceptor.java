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
 * @类名： LoginInterceptor
 * @类描述： 登录验证拦截器
 * @时间： 2016-9-8
 * @编写者： 修峻青
 */
public class LoginInterceptor implements HandlerInterceptor {

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
        logger.info( "\n——————————————————————————————————进入登录拦截器——————————————————————————————————" );
        String userName = request.getSession().getAttribute( Constant.USER_ID ).toString();
        if(userName==null || userName.equals( "" ) && userName.length()<1){
            String url = request.getSession().getAttribute( Constant.CONTENT_URL ).toString() + "jsp/index.jsp";
            request.getRequestDispatcher( url ).forward( request,response );
            System.out.println("\n不进入分发序列\n");
            return false;
        }
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
        logger.info( "\n——————————————————————————————————结束登录拦截器——————————————————————————————————" );
    }
}
