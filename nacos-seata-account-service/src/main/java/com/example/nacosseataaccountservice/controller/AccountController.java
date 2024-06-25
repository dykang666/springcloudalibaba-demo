package com.example.nacosseataaccountservice.controller;

import com.example.nacosseataaccountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/23 12:58
 */
@RestController
public class AccountController {
    @Autowired
    private AccountService  accountService;
    /**
     * 扣减账户余额
     * @param userId 用户id
     * @param money 金额
     */
    @PostMapping("/deductAccount")
    public void deductAccount(Long userId, Long money)
    {
        accountService.deductAccount(userId,money);
    }
}
