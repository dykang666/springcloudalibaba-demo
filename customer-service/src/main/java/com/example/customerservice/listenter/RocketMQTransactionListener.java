package com.example.customerservice.listenter;

import com.alibaba.fastjson.JSON;
import org.apache.http.util.Args;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author kangdongyang
 * @version 1.0
 * @description:
 * @date 2024/6/13 9:55
 */
@Component
public class RocketMQTransactionListener implements TransactionListener {
    private Logger log = LoggerFactory.getLogger(RocketMQTransactionListener.class);

    @Override
    public LocalTransactionState executeLocalTransaction(Message msg, Object o) {
        log.info("=========本地事务开始执行=============");
        String message = new String(msg.getBody());
        log.info("原始消息体：{}", message);
        // 事务消息id，唯一
        String tid = msg.getTransactionId();
        log.info("事务消息id：{}", tid);
        //模拟执行本地事务begin=======
        //TODO 为了解决重复消息《==》幂等性，可以将tid放入redis，并设置状态,消费端，每次从redis中获取事务id，根据状态并判断是否被消费过
        /**
         * 本地事务执行会有三种可能
         * 1、commit 成功
         * 2、Rollback 失败
         * 3、网络等原因服务宕机收不到返回结果
         */
        log.info("本地事务执行参数，start......----------------------");
        //从消息 Header 中解析到 args 参数，并使用 JSON 反序列化
        Args args = JSON.parseObject(msg.getProperty("args"), Args.class);
        // ... local transaction process, return rollback, commit or unknown
        log.info("[executeLocalTransaction][执行本地事务，消息：{} args：{}]", msg, args);
        log.info("本地事务执行参数，end......------------------------");
//TODO 一般我们会创建一张本地事务表，保存了包含事务id的一条记录，主要是回查的时候方便，只需要根据事务查询即可。
        //模拟执行本地事务end========
        //TODO 根据本地事务执行结果返回
        //LocalTransactionState.COMMIT_MESSAGE 二次确认消息，然后消费者可以消费
        //LocalTransactionState.ROLLBACK_MESSAGE 回滚消息，Broker端会删除半消息
        //LocalTransactionState.UNKNOW Broker端会进行回查消息
        return LocalTransactionState.UNKNOW;
    }

    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt msg) {
        log.info("==========回查接口=========");
// ... check local transaction status and return rollback, commit or unknown
        log.info("[checkLocalTransaction][回查消息：{}]", msg);
        // 事务消息id，唯一
        String tid = msg.getTransactionId();
        log.info("[checkLocalTransaction][事务消息id：{}]", tid);
        //TODO 1、必须根据key先去检查本地事务消息是否完成。
        /**
         * 因为有种情况就是：上面本地事务执行成功了，但是return LocalTransactionState.COMMIT_MESSAGE的时候
         * 服务挂了，那么最终 Brock还未收到消息的二次确定，还是个半消息 ，所以当重新启动的时候还是回调这个回调接口。
         * 如果不先查询上面本地事务的执行情况 直接在执行本地事务，那么就相当于成功执行了两次本地事务了。
         */
        // TODO 2、这里返回要么commit 要么rollback。没有必要再返回 UNKNOW
        return LocalTransactionState.COMMIT_MESSAGE;
    }
}
