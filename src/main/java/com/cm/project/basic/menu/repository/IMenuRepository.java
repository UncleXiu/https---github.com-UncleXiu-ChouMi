package com.cm.project.basic.menu.repository;

import com.cm.project.basic.menu.entitiy.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @项目名： CM
 * @包名： com.cm.project.basic.menu.repository
 * @类名： IMenuRepository
 * @类描述：
 * @时间： 2016-11-25
 * @编写者： 修峻青
 */
@Repository
public interface IMenuRepository extends JpaRepository<MenuEntity,Integer> {

    /**
     * 根据用户权限和用户类型搜索菜单
     * @param UserAuth
     * @param UserType
     * @return
     * @throws Exception
     */
    @Query("select me from MenuEntity me where me.MenuAuth <= ?1 and me.ManengerMune = ?2 order by me.MenuLevel")
    public List<MenuEntity> SelectMenuInfoByAuthAndManager(int UserAuth,int UserType) throws Exception;

}
