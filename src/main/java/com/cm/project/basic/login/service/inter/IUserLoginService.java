package com.cm.project.basic.login.service.inter;

import com.cm.project.basic.login.domain.PassWordDTO;
import com.cm.project.basic.login.domain.UserLoginDTO;
import com.cm.project.basic.login.domain.UserRegisterDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @项目名： CM
 * @包名： com.cm.project.basic.login.service.inter
 * @类名： IUserLoginService
 * @类描述：
 * @时间： 2016-11-24
 * @编写者： 修峻青
 */
public interface IUserLoginService {

    /**
     * 登录服务接口
     * @param request
     * @param dto
     * @return
     * @throws Exception
     */
    public Map<String,Object> UserLoginService(HttpServletRequest request, UserLoginDTO dto) throws Exception;

    /**
     * 注册服务接口
     * @param request
     * @param dto
     * @return
     * @throws Exception
     */
    public Map<String,Object> UserRegisterService(HttpServletRequest request, UserRegisterDTO dto) throws Exception;

    /**
     * 修改密码服务接口
     * @param request
     * @param dto
     * @return
     * @throws Exception
     */
    public Map<String,Object> ChangePassWordService(HttpServletRequest request, PassWordDTO dto) throws Exception;

}
