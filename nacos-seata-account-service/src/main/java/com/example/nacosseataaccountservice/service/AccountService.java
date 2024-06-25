package com.example.nacosseataaccountservice.service;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/23 11:59
 */
public interface AccountService {
    /**
     * 扣减账户余额
     * @param userId 用户id
     * @param money 金额
     */
    void deductAccount(Long userId, Long money);
}
