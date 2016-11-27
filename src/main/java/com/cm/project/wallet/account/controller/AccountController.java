package com.cm.project.wallet.account.controller;

import com.cm.project.wallet.account.domain.AccountDTO;
import com.cm.project.wallet.account.service.inter.IAccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2016-11-26.
 */
@Controller
@RequestMapping(value="/account")
public class AccountController {
    @Resource
    private IAccountService iAccountService;

    /**
     * 新增钱包账户控制器类
     * @param request
     * @param accountDTO
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/account.do")
    @ResponseBody
    public String AccountControllerFunction(HttpServletRequest request , AccountDTO accountDTO)throws Exception{
        //申请新增钱包账户服务
        String act=iAccountService.AccountSerciceFunction(request,accountDTO);
        return act;
    }

}