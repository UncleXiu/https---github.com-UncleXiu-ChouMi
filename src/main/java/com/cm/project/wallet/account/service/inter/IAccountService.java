package com.cm.project.wallet.account.service.inter;

import com.cm.project.wallet.account.domain.AccountDTO;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016-11-26.
 */
public interface IAccountService {

    /**
     * 新增钱包账户接口
     * @param request
     * @param accountDTO
     * @return
     * @throws Exception
     */
    public String AccountSerciceFunction(HttpServletRequest request, AccountDTO accountDTO) throws Exception;

}

