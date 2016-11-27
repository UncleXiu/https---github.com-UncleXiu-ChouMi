package com.cm.project.basic.menu.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @项目名： CM
 * @包名： com.cm.project.basic.menu.domain
 * @类名： MenuResultDTO
 * @类描述：
 * @时间： 2016-11-25
 * @编写者： 修峻青
 */
public class MenuResultDTO {

    public MenuResultDTO() {
        MenuName = null;
        MenuURL = null;
        SonList = new ArrayList<>();
    }

    //菜单名
    private String MenuName;
    //菜单URL
    private String MenuURL;
    //儿子列表
    private List<MenuResultDTO> SonList;

    //MenuName
    public String getMenuName() {
        return MenuName;
    }
    public void setMenuName(String menuName) {
        MenuName = menuName;
    }
    //MenuURL
    public String getMenuURL() {
        return MenuURL;
    }
    public void setMenuURL(String menuURL) {
        MenuURL = menuURL;
    }
    //SonList
    public List<MenuResultDTO> getSonList() { return SonList; }
    public void setSonList(List<MenuResultDTO> sonList) { SonList = sonList; }

    @Override
    public String toString() {
        return "MenuResultDTO{" +
                "MenuName='" + MenuName + '\'' +
                ", MenuURL='" + MenuURL + '\'' +
                ", SonList=" + SonList +
                '}';
    }
}
