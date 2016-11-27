package com.cm.project.basic.menu.controller;

import com.alibaba.fastjson.JSON;
import com.cm.project.basic.menu.domain.MenuResultDTO;
import com.cm.project.basic.menu.entitiy.MenuEntity;
import com.cm.project.basic.menu.service.inter.IMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @项目名： CM
 * @包名： com.cm.project.basic.menu.controller
 * @类名： MenuController
 * @类描述：
 * @时间： 2016-11-25
 * @编写者： 修峻青
 */
@Controller
@RequestMapping(value = "/MenuInfo")
public class MenuController {

    @Resource
    private IMenuService menuService;

    /**
     * 获取菜单树控制器
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/GetMenu.do")
    @ResponseBody
    public String GetMenuController(HttpServletRequest request, HttpServletResponse response) throws Exception{
        //申请菜单控制服务
        MenuResultDTO resultDTO = menuService.GetMenuService(request);
        System.out.println("Controller：" +JSON.toJSONString(resultDTO));
        //返回对象JSON
        return JSON.toJSONString(resultDTO);
    }



}
