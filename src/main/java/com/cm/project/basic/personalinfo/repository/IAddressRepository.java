package com.cm.project.basic.personalinfo.repository;

import com.cm.project.basic.personalinfo.entity.AddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @项目名： CM
 * @包名： com.cm.project.basic.personalinfo.repository
 * @类名： IAddressRepository
 * @类描述：
 * @时间： 2016-11-25
 * @编写者： 修峻青
 */
@Repository
public interface IAddressRepository extends JpaRepository<AddressEntity,Integer> {

    /**
     * 根据ID获取地址信息
     * @param ID
     * @return
     * @throws Exception
     */
    @Query("select add from AddressEntity add where add.ID like ?1")
    public AddressEntity SelectAddressByID(String ID) throws Exception;

}
