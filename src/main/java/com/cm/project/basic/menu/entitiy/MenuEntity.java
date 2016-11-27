package com.cm.project.basic.menu.entitiy;

import com.cm.common.entity.BaseEntity;
import com.sun.glass.ui.Menu;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @项目名： CM
 * @包名： com.cm.project.basic.menu.entitiy
 * @类名： MenuEntity
 * @类描述：
 * @时间： 2016-11-25
 * @编写者： 修峻青
 */
@Entity
@Table(name = "MENU_INFO")
public class MenuEntity extends BaseEntity{

    @Column(name = "MENU_NAME", length = 10, nullable = false)
    private String MenuName;
    @Column(name = "MENU_URL")
    private String MenuURL;
    @Column(name = "MENU_AUTH", length = 1, nullable = false)
    private int MenuAuth;
    @Column(name = "MANAGER_MENU", length = 1, nullable = false)
    private int ManengerMune;
    @Column(name = "PARENT_ID", length = 40)
    private String ParentMenuID;
    @Column(name = "MENU_LEVEL", length = 1, nullable = false)
    private int MenuLevel;

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
    //MenuAuth
    public int getMenuAuth() {
        return MenuAuth;
    }
    public void setMenuAuth(int menuAuth) {
        MenuAuth = menuAuth;
    }
    //MangerMenu
    public int getManengerMune() {
        return ManengerMune;
    }
    public void setManengerMune(int manengerMune) {
        ManengerMune = manengerMune;
    }
    //ParentMenuID
    public String getParentMenuID() {
        return ParentMenuID;
    }
    public void setParentMenuID(String parentMenuID) {
        ParentMenuID = parentMenuID;
    }
    //MenuLevel
    public int getMenuLevel() { return MenuLevel; }
    public void setMenuLevel(int menuLevel) { MenuLevel = menuLevel;}

    @Override
    public String toString() {
        return "MenuEntity{" +
                "MenuName='" + MenuName + '\'' +
                ", MenuURL='" + MenuURL + '\'' +
                ", MenuAuth=" + MenuAuth +
                ", ManengerMune=" + ManengerMune +
                ", ParentMenuID='" + ParentMenuID + '\'' +
                ", MenuLevel=" + MenuLevel +
                '}';
    }

}
