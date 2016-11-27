package com.cm.project.basic.login.service.impl;

import com.cm.common.interceptor.Constant;
import com.cm.common.interceptor.LoginInterceptor;
import com.cm.common.util.ObjectCopyUtil;
import com.cm.project.basic.login.domain.PassWordDTO;
import com.cm.project.basic.login.domain.UserLoginDTO;
import com.cm.project.basic.login.domain.UserRegisterDTO;
import com.cm.project.basic.login.entity.UserLoginEntity;
import com.cm.project.basic.login.repository.IUserLoginRepository;
import com.cm.project.basic.login.service.inter.IUserLoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @项目名： CM
 * @包名： com.cm.project.basic.login.service.impl
 * @类名： UserLoginServiceImpl
 * @类描述：
 * @时间： 2016-11-24
 * @编写者： 修峻青
 */
@Service
public class UserLoginServiceImpl implements IUserLoginService {

    private static Logger logger = LoggerFactory.getLogger( LoginInterceptor.class );

    @Resource
    private IUserLoginRepository userLoginRepository;

    /**
     * 登录服务
     * @param request
     * @param dto
     * @return
     * @throws Exception
     */
    @Override
    public Map<String,Object> UserLoginService(HttpServletRequest request, UserLoginDTO dto) throws Exception {
        //按照用户名查询用户
        UserLoginEntity login = userLoginRepository.QueryUserInfoByUserName(dto.getUserName());
        logger.info("STO.UserName："+dto.getUserName());
        logger.info("STO.PassWord："+dto.getPassword());
        Map<String,Object> result = new HashMap<>();
        if(login == null){
            //用户不存在，返回0002
            result.put(Constant.RETURN_MESSAGE,Constant.NO_USERNAME);
        }
        else {
            //用户被冻结，返回0003
            if(login.getLoginStatu() == 1){
                result.put(Constant.RETURN_MESSAGE,Constant.USER_HAS_BLOCKED);
            }
            //密码错误，错误次数+1，返回0001
            else if(!dto.getPassword().equals(login.getPassWord())){
                login.setErrorTime(login.getErrorTime()+1);
                result.put(Constant.RETURN_MESSAGE,Constant.PASSWORD_ERROR);
            }
            //登录成功，返回0000
            else{
                login.setErrorTime(0);
                userLoginRepository.save(login);
                result.put(Constant.MANAGER_FLAG,login.getUserType());
                result.put(Constant.USER_AUTH,login.getAuthLevel());
                result.put(Constant.USER_ID,login.getID());
                result.put(Constant.USER_NAME,login.getUserName());
                result.put(Constant.RETURN_MESSAGE,Constant.OPER_SUCCESS);
            }
        }
        return result;
    }

    /**
     * 注册服务
     * @param request
     * @param dto
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, Object> UserRegisterService(HttpServletRequest request, UserRegisterDTO dto) throws Exception {
        Map<String,Object> result = new HashMap<>();
        try {
            UserLoginEntity userLoginEntity = new UserLoginEntity();
            //将用户信息从DTO导入实体类
            ObjectCopyUtil.copyProperties(dto, userLoginEntity);
            //调用持久层进行用户信息查询
            //SQLException
            userLoginRepository.save(userLoginEntity);
            //注册成功，返回0000
            result.put(Constant.RETURN_MESSAGE,Constant.OPER_SUCCESS);
        }
        catch (SQLException e){
            System.out.println(e.getStackTrace());
            //注册失败，用户已经存在，返回0004
            result.put(Constant.RETURN_MESSAGE,Constant.USER_HAS_REGISTED);
        }
        finally {
            return result;
        }
    }

    /**
     * 修改密码服务
     * @param request
     * @param dto
     * @return
     * @throws Exception
     */
    @Override
    public Map<String, Object> ChangePassWordService(HttpServletRequest request, PassWordDTO dto) throws Exception {
        Map<String,Object> result = new HashMap<>();
        //获取用户记录
        UserLoginEntity userLoginEntity = userLoginRepository.QueryUserInfoByUserID(request.getSession().getAttribute(Constant.USER_ID).toString());
        //旧密码匹配正确，修改密码，返回0000
        System.out.println(userLoginEntity.toString());
        if(userLoginEntity.getPassWord().equals(dto.getOldPassWord())){
            userLoginEntity.setPassWord(dto.getNewPassWord());
            userLoginRepository.save(userLoginEntity);
            result.put(Constant.RETURN_MESSAGE,Constant.OPER_SUCCESS);
        }
        else {
            //密码错误，返回0002
            userLoginEntity.setErrorTime(userLoginEntity.getErrorTime()+1);
            if(userLoginEntity.getErrorTime() == 3){
                //如果错误次数达到3次，冻结账户并强制登出
                userLoginEntity.setLoginStatu(1);
                request.getSession().removeAttribute(Constant.USER_ID);
            }
            //将账户信息持久化
            userLoginRepository.save(userLoginEntity);
            result.put(Constant.RETURN_MESSAGE,Constant.PASSWORD_ERROR);
        }
        return result;
    }
}
