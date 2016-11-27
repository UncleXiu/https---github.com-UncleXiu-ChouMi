package com.cm.project.basic.menu.domain;

import com.cm.project.basic.menu.entitiy.MenuEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @项目名： CM
 * @包名： com.cm.project.basic.menu.domain
 * @类名： BTreeNode
 * @类描述：
 * @时间： 2016-11-25
 * @编写者： 修峻青
 */
public class BTreeNode {

    public BTreeNode() {
        this.sons = new ArrayList<>();
        this.father = null;
        this.data = null;
    }

    List<BTreeNode> sons;
    BTreeNode father;
    MenuEntity data;

    public List<BTreeNode> getSons() {
        return sons;
    }
    public void setSons(List<BTreeNode> sons) {
        this.sons = sons;
    }

    public BTreeNode getFather() {
        return father;
    }
    public void setFather(BTreeNode father) {
        this.father = father;
    }

    public MenuEntity getData() {
        return data;
    }
    public void setData(MenuEntity data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BTreeNode{" +
                "sons=" + sons +
                ", father=" + father +
                ", data=" + data +
                '}';
    }
}
