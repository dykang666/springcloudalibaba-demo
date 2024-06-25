package com.example.nacosproderorder.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/23 13:05
 */
@Component
@Slf4j
public class AccountRemoteFeignClientFallback  implements  AccountRemoteFeignClient{
    public void deductAccount(Long userId, Long money) {
        //System.out.println("seata-account-service降级了");
        log.info("seata-account-service降级了");
    }
}
