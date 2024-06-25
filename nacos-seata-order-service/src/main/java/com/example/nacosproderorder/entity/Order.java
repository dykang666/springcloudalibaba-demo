package com.example.nacosproderorder.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/22 18:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private  Long id;
    private  Long userId;
    private  String commodityCode;
    private  Integer count;
    private  Long money;

}
