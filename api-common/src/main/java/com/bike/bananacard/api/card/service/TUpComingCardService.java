package com.bike.bananacard.api.card.service;

import com.bike.bananacard.bean.TCardUpcoming;
import com.google.gson.JsonArray;
import com.sf.common.exception.AppException;

import java.util.List;

/**
 * Created by a700 on 16/8/30.
 */

public interface TUpComingCardService {


    public boolean updateComingCard(String upcomingtime, String info, String accountId, Integer cardId) throws AppException ;

    public boolean updateComingCardById(String upcomingtime, String info, Integer id) throws AppException ;

    /**
     * 添加修改处理待办事宜
     *
     * @param upcomingtime
     * @param accountId
     * @param cardId
     * @return
     * @throws AppException
     */
    public String addComingCard(String upcomingtime, String info, String accountId, Integer cardId) throws AppException ;


    /**
     * 修改
     *
     * @return
     * @throws AppException
     */
    public String updateUpcoming(String upcomingtime, String info, Integer id) throws AppException ;

    /**
     * 删除
     * @param upcomingId
     * @return
     * @throws AppException
     */
    public String downUpcomingCard(Integer upcomingId,String accountId) throws AppException ;

    /**
     * 获取所有有效的目标
     *
     * @param accountId
     * @return
     * @throws AppException
     */
    public List<TCardUpcoming> getAllTCardUpcoming(String accountId) throws AppException ;

   public TCardUpcoming getTCardUpcomingById(Integer id) throws AppException ;

    public JsonArray dealAllTCardUpcoming(String accountId) throws AppException ;


}
