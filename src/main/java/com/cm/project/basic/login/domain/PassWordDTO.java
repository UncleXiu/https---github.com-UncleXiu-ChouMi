package com.cm.project.basic.login.domain;

import com.cm.common.util.MD5Util;

/**
 * @项目名： CM
 * @包名： com.cm.project.basic.login.domain
 * @类名： PassWordDTO
 * @类描述：
 * @时间： 2016-11-24
 * @编写者： 修峻青
 */
public class PassWordDTO {

    //新密码
    private String NewPassWord;
    //旧密码
    private String OldPassWord;

    //NewPassWord
    public String getNewPassWord() {
        return NewPassWord;
    }
    public void setNewPassWord(String newPassWord) throws Exception {
        NewPassWord = MD5Util.convertMD5(newPassWord);
    }
    //OldPassWord
    public String getOldPassWord() {
        return OldPassWord;
    }
    public void setOldPassWord(String oldPassWord) throws Exception {
        OldPassWord = MD5Util.convertMD5(oldPassWord);
    }
}
