package com.bike.mq;

/**
 * Created by a700 on 16/11/28.
 */
public interface BananaMQProducer {

    public boolean sendDataToQueue(String queueKey, Object message);
}
