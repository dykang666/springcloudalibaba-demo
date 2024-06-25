package com.example.nacosproderorder.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/23 13:04
 */
@FeignClient(name = "seata-account-service", fallback = AccountRemoteFeignClientFallback.class)
public interface AccountRemoteFeignClient {

    @PostMapping("/seata-account-service/deductAccount")
    void deductAccount(@RequestParam("userId") Long userId, @RequestParam("money")Long money);

}
