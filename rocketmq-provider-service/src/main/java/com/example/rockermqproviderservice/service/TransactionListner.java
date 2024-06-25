package com.example.rockermqproviderservice.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.messaging.Message;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/21 14:03
 */
@Slf4j
@RocketMQTransactionListener
public class TransactionListner implements RocketMQLocalTransactionListener {
    //保障线程安全且保证高性能的hashmap，用来记录执行结果
    private static Map<String,RocketMQLocalTransactionState> transStateMap=new ConcurrentHashMap<>();
    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object o) {
        //方法里的object o这个对象是生产者发送消息方法最后一个参数的值
        String transId=(String)message.getHeaders().get(RocketMQHeaders.TRANSACTION_ID);
        log.info("事物id:{}",transId);
        try {
            //模拟执行任务
            Thread.sleep(5000);
            //执行成功后记录执行结果
            transStateMap.put(transId, RocketMQLocalTransactionState.COMMIT);
            return RocketMQLocalTransactionState.COMMIT;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //try以外执行失败后
        transStateMap.put(transId, RocketMQLocalTransactionState.ROLLBACK);
        return RocketMQLocalTransactionState.ROLLBACK;
    }
    //回查
    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
        String transId = (String)message.getHeaders().get(RocketMQHeaders.TRANSACTION_ID);
        System.out.println("回查消息");
        return transStateMap.get(transId);
    }
}
