package com.cm.project.basic.login.repository;

import com.cm.project.basic.login.entity.UserLoginEntity;
import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @项目名： CM
 * @包名： com.cm.project.basic.login.repository
 * @类名： UserLoginRepository
 * @类描述：
 * @时间： 2016-11-24
 * @编写者： 修峻青
 */
@Repository
public interface IUserLoginRepository extends JpaRepository<UserLoginEntity,Integer> {

    /**
     * 根据用户名查询用户信息
     * @param userName
     * @return
     * @throws Exception
     */
    @Query("select userlogin from UserLoginEntity userlogin where userlogin.UserName like ?1")
    public UserLoginEntity QueryUserInfoByUserName(String userName) throws Exception;

    /**
     * 根据用户ID查询用户信息
     * @param userID
     * @return
     * @throws Exception
     */
    @Query("select userlogin from UserLoginEntity userlogin where userlogin.ID like ?1")
    public UserLoginEntity QueryUserInfoByUserID(String userID) throws Exception;

}
