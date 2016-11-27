package com.cm.project.basic.login.entity;

import com.cm.common.entity.BaseEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @项目名： CM
 * @包名： com.cm.project.basic.login.entity
 * @类名： UserLoginEntity
 * @类描述： 用户登录信息表实体类
 * @时间： 2016-11-21
 * @编写者： 修峻青
 */
@Entity
@Table(name = "BASIC_USER_LOGIN")
public class UserLoginEntity extends BaseEntity {

    public UserLoginEntity() {
        ErrorTime = 0;
        LoginStatu = 0;
        UserType = 0;
        AuthLevel = 1;
        AuthPoint = 0;
    }

    @Column(name = "USER_NAME",length = 30, unique = true, nullable = false)
    private String UserName;
    @Column(name = "PASS_WORD",length = 32, nullable = false)
    private String PassWord;
    @Column(name = "ERROR_TIME",length = 1, nullable = false)
    private int ErrorTime;
    @Column(name = "LOGIN_STATU",length = 1, nullable = false)
    private int LoginStatu;
    @Column(name = "USER_TYPE",length = 1, nullable = false)
    private int UserType;
    @Column(name = "AUTH_LEVEL",length = 1, nullable = false)
    private int AuthLevel;
    @Column(name = "AUTH_POINT",length = 1, nullable = false)
    private int AuthPoint;
    @Column(name = "RESERVE1")
    private String Reserve1;
    @Column(name = "RESERVE2")
    private String Reserve2;
    @Column(name = "RESERVE3")
    private String Reserve3;

    //UserName
    public String getUserName() {
        return UserName;
    }
    public void setUserName(String userName) {
        UserName = userName;
    }
    //PassWord
    public String getPassWord() {
        return PassWord;
    }
    public void setPassWord(String passWord) {
        PassWord = passWord;
    }
    //ErrorTime
    public int getErrorTime() {
        return ErrorTime;
    }
    public void setErrorTime(int errorTime) {
        ErrorTime = errorTime;
    }
    //LoginStatu
    public int getLoginStatu() {
        return LoginStatu;
    }
    public void setLoginStatu(int loginStatu) {
        LoginStatu = loginStatu;
    }
    //UserType
    public int getUserType() {
        return UserType;
    }
    public void setUserType(int userType) {
        UserType = userType;
    }
    //AuthLevel
    public int getAuthLevel() {
        return AuthLevel;
    }
    public void setAuthLevel(int authLevel) {
        AuthLevel = authLevel;
    }
    //AuthPoint
    public int getAuthPoint() {
        return AuthPoint;
    }
    public void setAuthPoint(int authPoint) {
        AuthPoint = authPoint;
    }
    //Reserve1
    public String getReserve1() {
        return Reserve1;
    }
    public void setReserve1(String reserve1) {
        Reserve1 = reserve1;
    }
    //Reserve2
    public String getReserve2() {
        return Reserve2;
    }
    public void setReserve2(String reserve2) {
        Reserve2 = reserve2;
    }
    //Reserve3
    public String getReserve3() {
        return Reserve3;
    }
    public void setReserve3(String reserve3) {
        Reserve3 = reserve3;
    }

    @Override
    public String toString() {
        return "UserLoginEntity{" +
                "UserName='" + UserName + '\'' +
                ", PassWord='" + PassWord + '\'' +
                ", ErrorTime=" + ErrorTime +
                ", LoginStatu=" + LoginStatu +
                ", UserType=" + UserType +
                ", AuthLevel=" + AuthLevel +
                ", AuthPoint=" + AuthPoint +
                ", Reserve1='" + Reserve1 + '\'' +
                ", Reserve2='" + Reserve2 + '\'' +
                ", Reserve3='" + Reserve3 + '\'' +
                '}';
    }
}
