package com.bike.dynamic.service;

import com.bike.activity.model.TargetResultHessian;
import com.bike.dynamic.model.UserMessage;
import com.bike.mq.MQType;
import com.bike.user.serializable.PageBean;
import com.google.gson.JsonObject;

import java.util.List;

/**
 * Created by a700 on 16/11/29.
 */
public interface UserMessageService {

    /**
     * 查看用户消息列表
     * @param userId
     * @return
     */
    public PageBean queryMessageByUserId(String userId,Integer pageNam);

    /**
     * 查看某类型的用户消息
     * @param userId
     * @param startTime
     * @return
     */
    public PageBean queryMessageByUserIdType(String userId,String startTime,Integer pageNam);

    /**
     * 添加消息
     * @param userMessage
     * @return
     */
    public UserMessage addUserMessage(UserMessage userMessage);

    /**
     *
     * @param userId
     * @return
     */
    public boolean addNoReadMessage(String userId);

    /**
     * @param title
     * @param content
     * @param alias
     * @param typeId
     * @param value
     * @param mqType
     * @return
     */

    public boolean addMQ(String title,String content,String alias,Integer typeId,Integer value,MQType mqType);


    public boolean addChallengeCountMQ(TargetResultHessian targetResultHessian);

    /**
     * 删除用户消息
     * @param messageId
     * @param type  0 已读 1删除
     * @return
     */
    public boolean updateDelUserMessageById(String userId,Integer messageId,Integer type);

//  public JsonObject objectMessage2json(UserMessage userMessage);

    public boolean updateBatchUserMessageReaded(List<Integer> ids);

}
