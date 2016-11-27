package com.cm.project.basic.menu.service.impl;

import com.cm.project.basic.menu.domain.BTreeNode;
import com.cm.project.basic.menu.domain.MenuResultDTO;
import com.cm.project.basic.menu.entitiy.MenuEntity;

/**
 * @项目名： CM
 * @包名： com.cm.project.basic.menu.service.impl
 * @类名： BTree
 * @类描述：
 * @时间： 2016-11-25
 * @编写者： 修峻青
 */
public class BTree {

    /**
     * 入口方法
     * @param root
     * @param entity
     */
    public static void insertMenuEntity(BTreeNode root, MenuEntity entity){
        BTreeNode node = new BTreeNode();
        node.setData(entity);
        insertNode(root,node);
    }

    /**
     * 递归寻子
     * @param root
     * @param node
     */
    public static void insertNode(BTreeNode root, BTreeNode node){
        //容错判定
        if(node==null)
            return;
        if(root==null)
            return;
        //对根目录判定
        if(root.getData()==null){
            if(node.getData().getMenuLevel()==1){
                root.getSons().add(node);
                return;
            }
        //递归逻辑判定
        }else if(root.getData().getID().equals(node.getData().getParentMenuID())){
            root.getSons().add(node);
            return;
        }
        //递归
        for (BTreeNode son:root.getSons()){
            insertNode(son,node);
        }
    }

    /**
     * 简化树节点
     * @param root
     * @throws Exception
     */
    public static MenuResultDTO turnNodeType(BTreeNode root)throws Exception{
        //容错判定
        if(root==null)
            return null;
        //创建返回值
        MenuResultDTO dto = new MenuResultDTO();
        //判定最终节点
        if (root.getSons().size() == 0) {
        }
        //非最终节点递归
        else{
            for(BTreeNode btn:root.getSons()){
                dto.getSonList().add(turnNodeType(btn));
            }
        }
        //节点赋值需排除根节点
        if(root.getData()!=null) {
            dto.setMenuURL(root.getData().getMenuURL());
            dto.setMenuName(root.getData().getMenuName());
        }
        return dto;
    }

}
