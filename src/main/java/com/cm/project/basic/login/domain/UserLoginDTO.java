package com.cm.project.basic.login.domain;

import com.cm.common.util.MD5Util;

/**
 * @项目名： CM
 * @包名： com.cm.project.basic.login.entity
 * @类名： UserLoginDTO
 * @类描述：
 * @时间： 2016-11-21
 * @编写者： 修峻青
 */
public class UserLoginDTO {

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
    public String getPassword() {
        return PassWord;
    }
    public void setPassWord(String password) throws Exception { PassWord = MD5Util.convertMD5(password);}
    //VerifyCode
    public String getVerifyCode() {
        return VerifyCode;
    }
    public void setVerifyCode(String verifyCode) {
        VerifyCode = verifyCode;
    }
    
}
