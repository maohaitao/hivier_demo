package com.bike.bananacard.api.card.service;

import com.bike.bananacard.bean.TDefintionCardResult;
import com.bike.bananacard.bean.UserCard;
import com.bike.bananacard.bean.BaAccountDefintion;
import com.sf.common.exception.AppException;

import java.util.List;

/**
 * created with bananaCard.
 * description: 自定义卡处理
 */
public interface CardDefintionService {

    // 添加自定义卡片
    public String addDefintion(BaAccountDefintion defintion) throws AppException ;


    // 检查自定义卡片是否存在  验证系统自带的卡片
    public boolean checkDefintion(String cardName, String accountId) throws AppException ;

    /**
     * @return
     * @throws AppException
     */

    // 打自定义卡片
    public String uploadDefintionResult(TDefintionCardResult defintionCardResult, String token) throws AppException ;

    // 删除自定义卡片
    public String deleteDefintion(Integer cardId, String accountId) throws AppException ;

    // 删除自定义卡片
    public String deleteDefintionBatch(String cardIds, String accountId) throws AppException ;


    // 获取卡片列表
    public List<UserCard> getUserDefintionCards(String accountId) throws AppException ;



    public List<TDefintionCardResult> getDefintionCardResult(String startDate, String endDate, String accountId) throws AppException ;



    public String deleteDefiontionCardResult(Integer cardId, Integer cardResultId, String accountId) throws AppException ;


    /**
     * 当自定义卡片的设置常用卡片时候,排序为第一位,其他的sort +1
     *
     * @param accountId
     * @return
     */
    public boolean setCommonSort(String accountId) throws AppException ;


}