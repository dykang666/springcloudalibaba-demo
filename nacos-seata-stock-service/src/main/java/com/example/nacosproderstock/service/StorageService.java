package com.example.nacosproderstock.service;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/23 10:53
 */
public interface StorageService {
    /**
     * 根据商品编码查询商品价格。
     *
     * 本方法通过调用数据库查询特定商品的定价。商品编码是唯一标识商品的字符串，
     * 通过这个编码可以在数据库中准确找到对应的商品记录，从而获取其价格信息。
     *
     * @param commodityCode 商品的唯一编码。这个编码是商品在系统中的标识，
     *                      必须是唯一的，且不应为空或无效。
     * @return 返回查询到的商品价格。如果商品编码无效或查询失败，则返回null。
     */
    Long  selectPrice(String  commodityCode);
    /**
     * 扣减库存方法
     *
     * @param commodityCode 商品代码
     *                   商品的唯一标识符，用于准确指定要扣减库存的商品。
     * @param count 扣减数量
     *             需要从库存中扣减的商品数量。如果数量大于库存，则表示扣减失败。
     */
    int deductStorage(String commodityCode, int count);

}
