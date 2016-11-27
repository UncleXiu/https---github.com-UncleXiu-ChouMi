package com.cm.project.wallet.account.domain;

/**
 * Created by Administrator on 2016-11-26.
 */
public class AccountDTO {

    //昵称
    private String NickName;
    //支付密码
    private String PayPassword;
    //NickName
    public String getNickName() {
        return NickName;
    }
    public void setNickName(String nickName) {
        NickName = nickName;
    }
    //PayPassword
    public String getPayPassword() {
        return PayPassword;
    }
    public void setPayPassword(String payPassword) {
        PayPassword = payPassword;
    }

}
