package com.bike.bananacard.api.card.service;

import com.bike.bananacard.bean.CardResult;
import com.google.gson.JsonArray;
import com.sf.common.exception.AppException;

import java.util.List;
import com.bike.bananacard.bean.TRunCardResultOnMonth;
/**
 * created with bananaCard.
 * user: yanghui@700bike.com
 * date: 16/1/12
 * time: 下午9:13
 * description: 卡片列表service
 */
public interface CardListService {


    public String list(String accountId, String startDate, String endDate, String versionid) throws AppException ;

    public String listRun(String accountId, String startDate, String endDate, String versionid) throws AppException ;


    // IOS 1.1以前的版本
    public String listIOS(String accountId, String startDate, String endDate, String versionid) throws AppException ;


    /**
     * 用户常用卡片数据转换
     *
     * @param accountId
     * @return
     * @throws AppException
     */
    public String getUserCommonCard(String accountId) throws AppException ;


    /**
     * 获取系统卡片 标签分组
     * @param accountId
     * @return
     * @throws AppException
     */
    public String getCardTagList(String accountId,String version) throws AppException ;

    /**
     * 设置常用卡片
     *
     * @param accountId
     * @param addCards
     * @param cancelCards
     * @return
     * @throws AppException
     */
    public String setCommon(String accountId, java.util.List addCards, java.util.List cancelCards) throws AppException ;

    /**
     * 获取一段时间内用户打某张卡列表
     * @param startDate
     * @param endDate
     * @param accountId
     * @param card_id
     * @return
     * @throws AppException
     */
    public List<CardResult> getCardResult(String startDate, String endDate, String accountId, int card_id) throws AppException ;


    public List<TRunCardResultOnMonth> getTRunCardResultOnMonth(String startDate, String endDate, String accountId) throws AppException ;

    /**
     * 非常用卡片下架
     * @param accountId
     * @param cardId
     * @return
     */
    public boolean downNoCommonCard(String accountId,Integer cardId) throws AppException ;

}
