package com.cm.project.wallet.account.repository;

import com.cm.project.wallet.account.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016-11-26.
 */
@Repository
public interface IAccountRepository extends JpaRepository<AccountEntity,Integer> {

    /**
     * 根据用户ID查询钱包账户
     * @param id
     * @return
     * @throws Exception
     */
    @Query("select act from AccountEntity act where act.ID LIKE ?1")
    public AccountEntity SelectInfoById(String id) throws Exception;

}
