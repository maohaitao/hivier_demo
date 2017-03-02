package com.bike.dynamic.service;

import com.bike.dynamic.model.MessagePushSetting;

/**
 * Created by a700 on 16/9/30.
 */
public interface MessagePushSettingService {

    /**
     * 查询用户消息栏推送设置
     * @param accountId
     * @return
     */
    public MessagePushSetting queryMessagePushSetting(String accountId);

    /**
     * 添加用户消息栏设置
     * @return
     */
    public boolean addMessagePushSetting(MessagePushSetting messagePushSetting);

    /**
     * 修改用户消息栏设置
     * @param messagePushSetting
     * @return
     */
    public boolean updateMessagePushSetting(MessagePushSetting messagePushSetting);

    /**
     * 查詢是否需要給接收人推送
     * @param reciver
     * @param other
     * @param type 1 点赞 2 评论
     * @return
     */
    public boolean checkMessageSendSetting(String reciver,String other,int type);
}
