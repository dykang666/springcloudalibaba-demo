package com.example.nacosproderstock.controller;

import com.example.nacosproderstock.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/23 11:12
 */
@RestController
public class StorageController {
    @Autowired
    private StorageService  storageService;
    @GetMapping("/selectPrice")
    public Long selectPrice(String commodityCode)
    {
        Long price = storageService.selectPrice(commodityCode);
        return price;
    }
    @PostMapping("/deductStorage")
    public int deductStorage(String commodityCode, int count){
        return storageService.deductStorage(commodityCode,count);
    }
}
