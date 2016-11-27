package com.cm.project.basic.personalinfo.repository;

import com.cm.project.basic.personalinfo.entity.UserPersonalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @项目名： CM
 * @包名： com.cm.project.basic.personalinfo.repository
 * @类名： IUserPersonalInfoRepository
 * @类描述：
 * @时间： 2016-11-24
 * @编写者： 修峻青
 */
@Repository
public interface IUserPersonalInfoRepository extends JpaRepository<UserPersonalEntity,Integer> {

    /**
     * 根据用户ID查询用户个人信息
     * @param username
     * @return
     */
    @Query("select upi from UserPersonalEntity upi where upi.UserID like ?1")
    public UserPersonalEntity QueryUserPersonalInfoByUserName(String username);

}
