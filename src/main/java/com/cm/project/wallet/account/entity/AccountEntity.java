package com.cm.project.wallet.account.entity;

import com.cm.common.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Administrator on 2016-11-26.
 */
@Entity
@Table(name = "WALLET_USER_INFO")
public class AccountEntity extends BaseEntity {

    public AccountEntity(){
        FailureTime=0;
        Status=true;
        Account=0.00;
    }

    @Column(name = "USER_NAME",length = 30, unique = true, nullable = false)
    private String NickName;
    @Column(name = "PAY_PASSWORD",length = 32, nullable = false)
    private String PayPassword;
    @Column(name = "ERROR_TIME",length = 1, nullable = false)
    private int FailureTime;
    @Column(name = "STATUS",length = 1, nullable = false)
    private boolean Status;
    @Column(name = "ACCOUNT",precision = 10 , scale = 2, nullable = false)
    private double Account;
    @Column(name = "RESERVE1")
    private String Reserve1;
    @Column(name = "RESERVE2")
    private String Reserve2;
    @Column(name = "RESERVE3")
    private String Reserve3;
    //NickName
    public String getNickName() {
        return NickName;
    }
    public void setNickName(String nickName) {
        NickName = nickName;
    }
    //PayPassWord
    public String getPayPassword() {
        return PayPassword;
    }
    public void setPayPassword(String payPassword) {
        PayPassword = payPassword;
    }
    //FailureTime
    public int getFailureTime() {
        return FailureTime;
    }
    public void setFailureTime(int failureTime) {
        FailureTime = failureTime;
    }
    //Statues
    public boolean isStatus() {
        return Status;
    }
    public void setStatus(boolean status) {
        Status = status;
    }
    //Account
    public double getAccount() {
        return Account;
    }
    public void setAccount(double account) {
        Account = account;
    }

    @Override
    public String toString() {
        return "AccountEntity{" +
                "NickName='" + NickName + '\'' +
                ", PayPassword='" + PayPassword + '\'' +
                ", FailureTime=" + FailureTime +
                ", Status=" + Status +
                ", Account=" + Account +
                ", Reserve1='" + Reserve1 + '\'' +
                ", Reserve2='" + Reserve2 + '\'' +
                ", Reserve3='" + Reserve3 + '\'' +
                '}';
    }

}