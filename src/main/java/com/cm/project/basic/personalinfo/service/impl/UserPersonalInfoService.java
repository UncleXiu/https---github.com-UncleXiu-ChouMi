package com.cm.project.basic.personalinfo.service.impl;

import com.cm.common.interceptor.Constant;
import com.cm.common.util.ObjectCopyUtil;
import com.cm.project.basic.personalinfo.domain.AddressDTO;
import com.cm.project.basic.personalinfo.domain.UserPersonalDTO;
import com.cm.project.basic.personalinfo.entity.AddressEntity;
import com.cm.project.basic.personalinfo.entity.UserPersonalEntity;
import com.cm.project.basic.personalinfo.repository.IAddressRepository;
import com.cm.project.basic.personalinfo.repository.IUserPersonalInfoRepository;
import com.cm.project.basic.personalinfo.service.inter.IUserPersonalInfoService;
import com.sun.org.apache.bcel.internal.generic.IADD;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * @项目名： CM
 * @包名： com.cm.project.basic.personalinfo.service.impl
 * @类名： UserPersonalInfoService
 * @类描述：
 * @时间： 2016-11-24
 * @编写者： 修峻青
 */
@Service
public class UserPersonalInfoService implements IUserPersonalInfoService {

    @Resource
    private IUserPersonalInfoRepository userPersonalInfoRepository;
    @Resource
    private IAddressRepository addressRepository;

    /**
     * 新增用户详细信息服务
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public String InsertUserPersonalService(HttpServletRequest request, UserPersonalDTO dto1, AddressDTO dto2) throws Exception {
        //移植DTO数据
        UserPersonalEntity userPersonalEntity = new UserPersonalEntity();
        AddressEntity addressEntity = new AddressEntity();
        ObjectCopyUtil.copyProperties(dto1,userPersonalEntity);
        //保存用户地址信息
        ObjectCopyUtil.copyProperties(dto2,addressEntity);
        addressRepository.save(addressEntity);
        //自动生成用户ID
        try {
            userPersonalEntity.setUserID(request.getSession().getAttribute(Constant.USER_ID).toString());
            userPersonalEntity.setAddressID(addressEntity.getID());
            userPersonalInfoRepository.save(userPersonalEntity);
            //成功新增信息，返回0000
            return Constant.OPER_SUCCESS;
        }
        catch (Exception e){
            e.getStackTrace();
            //用户信息已存在，返回0005
            return Constant.USER_INFO_HAS_EXIT;
        }
    }

    /**
     * 更新用户详细信息服务
     * @param request
     * @param dto1
     * @param dto2
     * @return
     * @throws Exception
     */
    @Override
    public String UpdateUserPersonalService(HttpServletRequest request, UserPersonalDTO dto1, AddressDTO dto2) throws Exception {
        //获取用户详细信息
        UserPersonalEntity userPersonalEntity = userPersonalInfoRepository.QueryUserPersonalInfoByUserName(
                request.getSession().getAttribute(Constant.USER_ID).toString());
        AddressEntity addressEntity = addressRepository.SelectAddressByID(userPersonalEntity.getAddressID());
        //移植DTO数据
        ObjectCopyUtil.copyProperties(dto1,userPersonalEntity);
        ObjectCopyUtil.copyProperties(dto2,addressEntity);
        //更新数据
        addressRepository.save(addressEntity);
        userPersonalInfoRepository.save(userPersonalEntity);
        //更新成功，返回0000
        return Constant.OPER_SUCCESS;
    }
}
