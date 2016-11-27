package com.cm.project.basic.menu.service.impl;

import com.alibaba.fastjson.JSON;
import com.cm.common.interceptor.Constant;
import com.cm.common.util.ObjectCopyUtil;
import com.cm.project.basic.menu.domain.BTreeNode;
import com.cm.project.basic.menu.domain.MenuResultDTO;
import com.cm.project.basic.menu.entitiy.MenuEntity;
import com.cm.project.basic.menu.repository.IMenuRepository;
import com.cm.project.basic.menu.service.inter.IMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @项目名： CM
 * @包名： com.cm.project.basic.menu.service.inter
 * @类名： MenuService
 * @类描述：
 * @时间： 2016-11-25
 * @编写者： 修峻青
 */
@Service
public class MenuService implements IMenuService {

    @Resource
    private IMenuRepository menuRepository;

    /**
     * 获取菜单服务
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public MenuResultDTO GetMenuService(HttpServletRequest request) throws Exception {
        //获取用户权限和身份信息
        HttpSession session = request.getSession();
        int AuthLevel = Integer.parseInt(session.getAttribute(Constant.USER_AUTH).toString());
        int ManagerFlag = Integer.parseInt(session.getAttribute(Constant.MANAGER_FLAG).toString());
        //持久层获取数据，并数据转换：Entity->DTO
        List<MenuEntity> result = menuRepository.SelectMenuInfoByAuthAndManager(AuthLevel,ManagerFlag);
        //BTree树排序
        BTreeNode root = new BTreeNode();
        for(MenuEntity me:result){
            BTree.insertMenuEntity(root,me);
        }
        //DTO转换
        MenuResultDTO dto = BTree.turnNodeType(root);
        System.out.println("root="+ JSON.toJSONString(dto));
        return dto;
    }

    /**
     * 类型赋值转换方法
     * @param menuEntities
     * @return
     * @throws Exception
     */
    public List<MenuResultDTO> ObjectTurn(List<MenuEntity> menuEntities) throws Exception{
        List<MenuResultDTO> DTOresult = new ArrayList<>();
        MenuResultDTO dto = new MenuResultDTO();
        for(MenuEntity mrd:menuEntities){
            ObjectCopyUtil.copyProperties(mrd,dto);
            DTOresult.add(dto);
        }
        return DTOresult;
    }
}
