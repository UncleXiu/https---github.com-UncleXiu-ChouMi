package com.cm.project.basic.personalinfo.controller;

import com.alibaba.fastjson.JSON;
import com.cm.common.interceptor.LoginInterceptor;
import com.cm.project.basic.personalinfo.domain.AddressDTO;
import com.cm.project.basic.personalinfo.domain.UserPersonalDTO;
import com.cm.project.basic.personalinfo.service.inter.IUserPersonalInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @项目名： CM
 * @包名： com.cm.project.basic.personalinfo.controller
 * @类名： UserPersonalController
 * @类描述：
 * @时间： 2016-11-24
 * @编写者： 修峻青
 */
@Controller
@RequestMapping(value = "/UserInfo")
public class UserPersonalController {

    private static Logger logger = LoggerFactory.getLogger( UserPersonalController.class );

    @Resource
    private IUserPersonalInfoService userPersonalInfoService;

    /**
     * 新增用户详细信息控制器
     * @param request
     * @param response
     * @param dto1
     * @param dto2
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/InsertInfo.do")
    @ResponseBody
    public String InsertPersonalInfoController(HttpServletRequest request, HttpServletResponse response, UserPersonalDTO dto1, AddressDTO dto2) throws Exception{
        //申请新增用户信息服务
        String result = userPersonalInfoService.InsertUserPersonalService(request,dto1,dto2);
        return JSON.toJSONString(result);
    }

    /**
     * 更新用户详细信息控制器
     * @param request
     * @param response
     * @param dto
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/UpdateInfo.do")
    @ResponseBody
    public String UpdatePersonalInfoController(HttpServletRequest request, HttpServletResponse response, UserPersonalDTO dto1, AddressDTO dto2) throws Exception{
        //申请更新用户信息服务
        String result = userPersonalInfoService.UpdateUserPersonalService(request, dto1, dto2);
        return JSON.toJSONString(result);
    }

}
