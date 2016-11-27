package com.cm.project.basic.login.domain;

import com.cm.common.util.MD5Util;

/**
 * @项目名： CM
 * @包名： com.cm.project.basic.login.domain
 * @类名： UserRegisterDTO
 * @类描述：
 * @时间： 2016-11-24
 * @编写者： 修峻青
 */
public class UserRegisterDTO {

    //用户名
    private String UserName;
    //密码
    private String PassWord;
    //验证码
    private String VerifyCode;

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
    public void setPassWord(String passWord) throws Exception { PassWord = MD5Util.convertMD5(passWord);}
    //VerifyCode
    public String getVerifyCode() {
        return VerifyCode;
    }
    public void setVerifyCode(String verifyCode) {
        VerifyCode = verifyCode;
    }
}
