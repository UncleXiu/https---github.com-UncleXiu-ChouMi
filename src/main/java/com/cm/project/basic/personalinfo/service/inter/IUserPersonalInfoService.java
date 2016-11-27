package com.cm.project.basic.personalinfo.service.inter;

import com.cm.project.basic.personalinfo.domain.AddressDTO;
import com.cm.project.basic.personalinfo.domain.UserPersonalDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @项目名： CM
 * @包名： com.cm.project.basic.personalinfo.service.inter
 * @类名： IUserPersonalInfoService
 * @类描述：
 * @时间： 2016-11-24
 * @编写者： 修峻青
 */
public interface IUserPersonalInfoService {

    /**
     * 新增用户详细信息服务接口
     * @param request
     * @return
     * @throws Exception
     */
    public String InsertUserPersonalService(HttpServletRequest request, UserPersonalDTO dto, AddressDTO dto2) throws Exception;

    /**
     * 更新用户详细信息服务接口
     * @param request
     * @param dto1
     * @return
     * @throws Exception
     */
    public String UpdateUserPersonalService(HttpServletRequest request, UserPersonalDTO dto1, AddressDTO dto2) throws Exception;




}
