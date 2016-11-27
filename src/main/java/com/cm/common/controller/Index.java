package com.cm.common.controller;

import com.cm.common.interceptor.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * @项目名： ChouMi
 * @包名： com.cm.common.controller
 * @类名： Index
 * @类描述： 项目入口类
 * @时间： 2016-8-16
 * @编写者： 修峻青
 */
@Controller
@RequestMapping(value = "/")
public class Index {

    /**
     * 入口Bean
     * @param httpServletRequest
     * @param httpServletResponse
     * @return
     */
    @RequestMapping(value = "index.do")
    public ModelAndView index(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse){
        //将项目请求的根目录存入Session
        System.out.println("本项目的根目录为"+ httpServletRequest.getRequestURL());
        httpServletRequest.getSession().setAttribute( Constant.CONTENT_URL,httpServletRequest.getRequestURL() );
        //跳转至主页
        return new ModelAndView( "index" );
    }

}
