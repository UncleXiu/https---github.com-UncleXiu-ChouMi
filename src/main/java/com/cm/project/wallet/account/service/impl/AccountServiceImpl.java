package com.cm.project.wallet.account.service.impl;

import com.cm.common.interceptor.Constant;
import com.cm.common.util.ObjectCopyUtil;
import com.cm.project.wallet.account.domain.AccountDTO;
import com.cm.project.wallet.account.entity.AccountEntity;
import com.cm.project.wallet.account.repository.IAccountRepository;
import com.cm.project.wallet.account.service.inter.IAccountService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016-11-26.
 */
@Service
public class AccountServiceImpl implements IAccountService {

    @Resource
    private IAccountRepository iAccountRepository;

    /**
     * 新增钱包账户服务
     * @param request
     * @param accountDTO
     * @return
     * @throws Exception
     */
    @Override
    public String AccountSerciceFunction(HttpServletRequest request, AccountDTO accountDTO) throws Exception {
        //数据格式转换DTO->Entity
        AccountEntity accountEntity=new AccountEntity();
        ObjectCopyUtil.copyProperties(accountDTO,accountEntity);
        accountEntity.setID(request.getSession().getAttribute(Constant.USER_ID).toString());
        //保存数据
        //唯一性验证异常处理
        try {
            iAccountRepository.save(accountEntity);
        } catch (DataIntegrityViolationException e) {
            //打印栈信息，返回0101
            e.printStackTrace();
            return Constant.WALLET_HAS_EXIT;
        }
        //正确保存，返回0000
        return Constant.OPER_SUCCESS;
    }
}


