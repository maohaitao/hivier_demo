package com.bike.dynamic.service;

import com.bike.bananacard.bean.CardResult;
import com.bike.dynamic.model.CardImageDynamic;
import com.bike.dynamic.model.CollectionInfo;
import com.bike.user.serializable.PageBean;

import java.util.Collections;
import java.util.List;

/**
 * Created by allen duan on 16/9/25.
 * 打卡动态相关接口
 */
public interface CardImageDynamicService {

    /**
     * 根据卡片id及打卡结果获取为发布动态内容
     * @param cardResultId
     * @param cardId
     * @return
     */
    public CardImageDynamic getUnPublishDynamic(Integer cardResultId,Integer cardId);

    /**
     * 打卡成功保存默认未发布的动态
     * @param cardResult
     * @param type
     * @param addOrUpdate 0 add ,1 update
     * @return
     */
    public CardImageDynamic saveDefaultDynamic(CardResult cardResult, Integer type, Integer addOrUpdate);

    /**
     * 保存发布动态
     * @param dynamic
     * @return
     */
    public CardImageDynamic saveDynamic(CardImageDynamic dynamic);

    /**
     * 修改动态
     * @param dynamic
     * @return
     */
    public boolean updateDynamic(CardImageDynamic dynamic);

    /**
     * 删除动态
     * @param dynamic
     * @return
     */
    public boolean deleteDynamic(CardImageDynamic dynamic,Integer isFb);

    @Deprecated
    public boolean fobidDynamic(int id, int is_yellow, int is_default_yellow);

    /**
     * 根据打卡结果id及卡片id删除对于打卡动态
     * @param card_result_id
     * @param card_id
     * @param card_style
     * @return
     */
    public  boolean deleteDynamicByCardResult(Integer card_result_id,Integer card_id,Integer card_style);

    /**
     * 修改动态私密性
     * @param dynamicId
     * @param type
     * @return
     */
    @Deprecated
    public boolean updateDynamicOpenType(Integer dynamicId,Integer type);

    /**
     * 根据动态id获取动态
     * @param
     * @return
     */
    public CardImageDynamic queryDynamicById(Integer dynamicId);

    /**
     * 根据打卡结果id获取动态
     * @param card_result_id
     * @param card_id
     * @param isPublish 1 已发布 , 0 未发布
     * @return
     */
    public CardImageDynamic queryDynamicByResultId(Integer card_result_id,Integer card_id,Integer isPublish);



    /**
     * 获取动态列表
     * @param accountId
     * @param type 1.本人 2.他人 3.推荐列表
     * @return
     */
    public List<CardImageDynamic> queryDynamicListByDate(String accountId, Integer type, Integer size,String dateString);

    public List<CardImageDynamic> queryDynamicTimeLineByDate(String accountId, Integer size,String start_time ,String end_time);

    /**
     * 获取动态列表
     * @param accountId
     * @param type 1.本人 2.他人 3.推荐列表
     * @return
     */
    public int queryDynamicListCountDate(String accountId, Integer type,String dateString);

    /**
     * 查询关注列表
     * @param accountId
     * @param size
     * @param dateString
     * @return
     */
    public List<CardImageDynamic> queryFollowUserDynamicList(String accountId, Integer size,String dateString,Integer type);



    /**
     * 获取最近发布的动态图片列表
     * @param accountId
     * @param size
     * @return
     */
    public List<CardImageDynamic> queryLatestDynamicImageUrl(String accountId,Integer size);

    public PageBean getTimeLineList(String accountId, Integer pageNum,Integer cardId);


    /**
     * 关注的用户是否有新动态
     * @param accountId
     * @return
     */
    public int getFollowUserDynamicCount(String accountId,String dateString);

    /**
     * 查询挑战相关动态总数
     * @param challengeId
     * @return
     */
    public Integer queryChallengeDynamicCount(Integer challengeId );

    /**
     * 查询挑战相关动态
     * @param challengeId
     * @param size
     * @param limitDate
     * @param type 1 所有的 2 带图的
     * @return
     */
    public List<CardImageDynamic> queryChallengeDynamic(Integer challengeId,Integer size,String limitDate,Integer type,String accountId);

    /**
     * 查询挑战相关动态
     * @param collectionId
     * @param size
     * @param limitDate
     * @return
     */
    public List<CardImageDynamic> queryCollectionDynamics(Integer collectionId,Integer size,String limitDate);

    /**
     * 查询合集列表
     * @return
     */
    public List<CollectionInfo> queryCollectionInfos();
}
