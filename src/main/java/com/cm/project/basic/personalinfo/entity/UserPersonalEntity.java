package com.cm.project.basic.personalinfo.entity;

import com.cm.common.entity.BaseEntity;

import javax.persistence.*;
import java.util.Date;

/**
 * @项目名： CM
 * @包名： com.cm.project.basic.personalinfo.entity
 * @类名： UserPersonalEntity
 * @类描述：
 * @时间： 2016-11-24
 * @编写者： 修峻青
 */
@Entity
@Table(name = "BASIC_USER_INFO")
public class UserPersonalEntity extends BaseEntity {

    public UserPersonalEntity() {
        InfoHide = 0;
    }

    @Column(name = "USER_ID", length = 40, unique = true, nullable = false)
    private String UserID;
    @Column(name = "USER_RAEL_NAME", length = 30, nullable = false)
    private String UserRealName;
    @Column(name = "USER_CARD_TYPE", length = 1)
    private int UserCardType;
    @Column(name = "USER_CARD_ID", length = 18)
    private String UserCardID;
    @Column(name = "USER_PHONE", length = 11)
    private String UserPhone;
    @Column(name = "ADDRESS_ID", length = 40, unique = true)
    private String AddressID;
    @Column(name = "BIRTH_DATE")
    @Temporal(TemporalType.DATE)
    private Date BirthDate;
    @Column(name = "AGE",length = 3)
    private int Age;
    @Column(name = "INFO_HIDE", length = 1, nullable = false)
    private int InfoHide;

    //UserID
    public String getUserID() {
        return UserID;
    }
    public void setUserID(String userID) {
        UserID = userID;
    }
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
    //AddressID
    public String getAddressID() {
        return AddressID;
    }
    public void setAddressID(String addressID) {
        AddressID = addressID;
    }
}
