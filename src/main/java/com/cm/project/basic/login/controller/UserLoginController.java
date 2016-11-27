package com.cm.project.basic.login.controller;

import com.cm.common.interceptor.Constant;
import com.cm.project.basic.login.domain.PassWordDTO;
import com.cm.project.basic.login.domain.UserLoginDTO;
import com.cm.project.basic.login.domain.UserRegisterDTO;
import com.cm.project.basic.login.service.inter.IUserLoginService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @项目名： CM
 * @包名： com.cm.project.basic.login.controller
 * @类名： UserLoginController
 * @类描述： 用户登录类
 * @时间： 2016-11-21
 * @编写者： 修峻青
 */
@Controller
@RequestMapping(value = "/UserLogin")
public class UserLoginController {

    @Resource
    private IUserLoginService userLoginService;

    /**
     * 用户登录控制器
     * @param request
     * @param response
     * @param dto
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/Login.do")
    public ModelAndView LoginController(HttpServletRequest request, HttpServletResponse response, UserLoginDTO dto) throws Exception{
        //向服务层申请登录验证
        Map<String,Object> result = userLoginService.UserLoginService(request,dto);
        return new ModelAndView().addAllObjects(result);
    }

    /**
     * 用户注册控制器
     * @param request
     * @param response
     * @param dto
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/Register.do")
    public ModelAndView RegisterController(HttpServletRequest request, HttpServletResponse response, UserRegisterDTO dto) throws Exception{
        //向服务层申请注册验证
        Map<String,Object> result = userLoginService.UserRegisterService(request,dto);
        return new ModelAndView().addAllObjects(result);
    }

    /**
     * 更改密码控制器
     * @param request
     * @param response
     * @param dto
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/PswChange.do")
    public ModelAndView ChangePassWordController(HttpServletRequest request, HttpServletResponse response, PassWordDTO dto) throws Exception{
        //向服务层申请密码修改
        Map<String,Object> result = userLoginService.ChangePassWordService(request,dto);
        ModelAndView modelAndView = new ModelAndView().addAllObjects(result);
        if(result.get(Constant.RETURN_MESSAGE).equals("0000")){
            modelAndView.setViewName("info");
        }
        else{
            modelAndView.setViewName("index");
        }
        return modelAndView;
    }

}
