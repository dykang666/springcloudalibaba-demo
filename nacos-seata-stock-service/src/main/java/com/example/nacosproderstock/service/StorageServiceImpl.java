package com.example.nacosproderstock.service;

import com.example.nacosproderstock.dao.StorageMapper;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/23 10:55
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService{

    @Autowired
    private StorageMapper  storageMapper;

    @Override
    public Long selectPrice(String commodityCode) {
      Long price=  storageMapper.selectPrice(commodityCode);
      return price;
    }


    @Override
    public int deductStorage(String commodityCode, int count) {
        log.info("Seata全局事务id=================>{}", RootContext.getXID());
        storageMapper.deductStorage(commodityCode,count);
        return  count;
    }


}
