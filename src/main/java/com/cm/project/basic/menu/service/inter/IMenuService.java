package com.cm.project.basic.menu.service.inter;

import com.cm.project.basic.menu.domain.MenuResultDTO;
import com.cm.project.basic.menu.entitiy.MenuEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @项目名： CM
 * @包名： com.cm.project.basic.menu.service.impl
 * @类名： IMenuService
 * @类描述：
 * @时间： 2016-11-25
 * @编写者： 修峻青
 */
public interface IMenuService {

    /**
     * 获取菜单服务接口
     * @param request
     * @return
     * @throws Exception
     */
    public MenuResultDTO GetMenuService(HttpServletRequest request) throws Exception;

}
