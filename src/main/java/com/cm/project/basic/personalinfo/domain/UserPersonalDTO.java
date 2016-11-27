package com.cm.project.basic.personalinfo.domain;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * @项目名： CM
 * @包名： com.cm.project.basic.personalinfo.domain
 * @类名： UserPersonalDTO
 * @类描述：
 * @时间： 2016-11-24
 * @编写者： 修峻青
 */
public class UserPersonalDTO {

    //用户姓名
    private String UserRealName;
    //用户证件类型
    private int UserCardType;
    //用户证件号
    private String UserCardID;
    //用户电话
    private String UserPhone;
    //用户出生日期
    private Date BirthDate;
    //年龄
    private int Age;
    //信息隐藏标示
    private int InfoHide;

    //UserRealName
    public String getUserRealName() {
        return UserRealName;
    }
    public void setUserRealName(String userRealName) {
        UserRealName = userRealName;
    }
    //UserCardType
    public int getUserCardType() {
        return UserCardType;
    }
    public void setUserCardType(int userCardType) {
        UserCardType = userCardType;
    }
    //UserCardID
    public String getUserCardID() {
        return UserCardID;
    }
    public void setUserCardID(String userCardID) {
        UserCardID = userCardID;
    }
    //UserPhone
    public String getUserPhone() {
        return UserPhone;
    }
    public void setUserPhone(String userPhone) {
        UserPhone = userPhone;
    }
    //BirthDate
    public Date getBirthDate() {
        return BirthDate;
    }
    public void setBirthDate(Date birthDate) {
        BirthDate = birthDate;
    }
    //Age
    public int getAge() {
        return Age;
    }
    public void setAge(int age) {
        Age = age;
    }
    //InfoHide
    public int getInfoHide() {
        return InfoHide;
    }
    public void setInfoHide(int infoHide) {
        InfoHide = infoHide;
    }

    @Override
    public String toString() {
        return "UserPersonalDTO{" +
                "UserRealName='" + UserRealName + '\'' +
                ", UserCardType=" + UserCardType +
                ", UserCardID='" + UserCardID + '\'' +
                ", UserPhone='" + UserPhone + '\'' +
                ", BirthDate=" + BirthDate +
                ", Age=" + Age +
                ", InfoHide=" + InfoHide +
                '}';
    }
}
