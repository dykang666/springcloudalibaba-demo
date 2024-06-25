package com.example.nacosseataaccountservice.service;

import com.example.nacosseataaccountservice.dao.AccountMapper;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/23 12:35
 */
@Service
@Slf4j
public class AccountServiceImpl implements  AccountService{
    @Autowired
    private AccountMapper  accountMapper;

    @Override
    public void deductAccount(Long userId, Long money) {
        log.info("Seata全局事务id=================>{}", RootContext.getXID());
        log.info("[账户服务]>------>扣减账户开始");
        if (10000 == userId) {
            throw new RuntimeException("[库存服务]>------>扣减库存异常");
        }
        accountMapper.deductAccount(userId, money);
        log.info("[账户服务]>------>扣减账户成功!");
    }
}
