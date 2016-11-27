package com.cm.common.interceptor;


/**
 * @项目名： CM
 * @包名： com.cm.common.interceptor
 * @类名： Constant
 * @类描述： 系统常量
 * @时间： 2016-8-17
 * @编写者： 修峻青
 */
public class Constant {

    /*===================================== 系统变量 ========================================*/
    //项目根目录
    public static final String CONTENT_URL = "ctx";
    //用户名
    public static final String USER_NAME = "UserName";
    //权限等级
    public static final String USER_AUTH = "UserAuth";
    //返回码
    public static final String BACK_ECORDING = "Ecording";
    //验证码
    public static final String VERIFY_CODE = "ValidateCode";
    //返回信息
    public static final String RETURN_MESSAGE = "ResultMessage";
    //管理员标示
    public static final String MANAGER_FLAG = "ManagerFlag";
    //空字符串
    public static final String BLANK_STRING = "";
    //用户ID
    public static final String USER_ID = "UserID";

    /*===================================== 系统密钥 ========================================*/
    //DES密钥1
    public static final String PASSWORD_CRYPT_KEY_ONE = "r3oRiHqUn8tyNbJSLCs1ux6dYv5fl94DZKzkBTVEGwQphPAIc2jOe7MgX0aFmW";
    //DES密钥2
    public static final String PASSWORD_CRYPT_KEY_TWO = "MUiEfyVh1Nuls93rzJSIBxAZcT8wD2mPaoGpC7k6YbeFdQqj4LgHvtO0XRWn5K";
    //DES密钥3
    public static final String PASSWORD_CRYPT_KEY_TRE = "1FmZt86lQu5KUAjBdGbNVrJEhMxWDIqOickS74LRnXpPYe3ofv2C0HgyaTwz9s";

    /*===================================== 基础模块返回码 ========================================*/
    //操作成功
    public static final String OPER_SUCCESS = "0000";
    //密码错误
    public static final String PASSWORD_ERROR = "0001";
    //用户名不存在
    public static final String NO_USERNAME = "0002";
    //账户被冻结
    public static final String USER_HAS_BLOCKED = "0003";
    //用户名已存在
    public static final String USER_HAS_REGISTED = "0004";
    //用户信息已存在
    public static final String USER_INFO_HAS_EXIT = "0005";
    /*===================================== 钱包模块返回码 ========================================*/
    public static final String WALLET_HAS_EXIT = "0101";

}
