package com.bike.bananacard.api.card.service;

import com.bike.bananacard.bean.CardResult;
import com.bike.bananacard.bean.TPlanCard;
import com.google.gson.JsonArray;
import com.sf.common.exception.AppException;

import java.util.List;

/**
 * Created by a700 on 16/8/30.
 */

public interface TPlanCardService {


    public boolean updatePlanCard(Integer planvalue, Integer isClock, String clocktime,
                                  String planday, String accountId, Integer cardId) throws AppException ;

    public boolean updatePlanCardById(Integer planvalue, Integer isClock, String clocktime,
                                      String planday, Integer id) throws AppException ;

    public String addPlandCard(Integer planvalue, Integer isClock, String clocktime,
                               String planday, String accountId, Integer cardId) throws AppException ;

    /**
     * 当自定义卡片的设置常用卡片时候,排序为第一位,其他的sort +1
     *
     * @param accountId TODO 设置目标是 设置为常用卡片 并序号修改
     * @return
     */
    public boolean setCommonSort(String accountId, int id) throws AppException ;

    /**
     * 修改
     *
     * @return
     * @throws AppException
     */
    public String updatePladCard(Integer planvalue, Integer isClock, String clocktime,
                                 String planday, Integer id) throws AppException ;

    /**
     * 删除
     *
     * @param planId
     * @return
     * @throws AppException
     */
    public String downPlanCard(Integer planId) throws AppException ;

    /**
     * 批量修改目标
     *
     * @param cardIds
     * @return
     * @throws AppException
     */
    public boolean downBathPlanCard(List<String> cardIds, String accountId) throws AppException ;

    /**
     * 获取所有有效的目标
     *
     * @param accountId
     * @return
     * @throws AppException
     */
    public List<TPlanCard> getAllTPlanCard(String accountId) throws AppException ;

    public List<TPlanCard> getOldTPlanCard(String accountId) throws AppException ;

    public JsonArray dealAllTPlan(String accountId) ;

    public JsonArray dealAllTPlan(JsonArray jsonArray, TPlanCard planCard, List<CardResult> result) ;

    public TPlanCard getTPlanCardById(int cardid,String accountId);

}
