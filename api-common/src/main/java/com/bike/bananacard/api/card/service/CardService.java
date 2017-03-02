package com.bike.bananacard.api.card.service;

import com.bike.bananacard.bean.TCalendarCards;
import com.sf.common.exception.AppException;

import java.util.Date;

/**
 * created with bananaCard.
 * user: yanghui@700bike.com
 * date: 16/1/12
 * time: 下午9:13
 * description: 卡片service
 */
public interface CardService {

    public String list() throws AppException ;

    public String add(TCalendarCards calendarCards, String accountId) throws AppException ;

    public String add(TCalendarCards calendarCards, String accountId, boolean isCheckRepeat) throws AppException ;

    public boolean checkUserCard(String accountId, Integer cardId, Date startDate) throws AppException ;


    public String delete(Integer cardId, String accountId) throws AppException ;

    /**
     * 获取系统默认常用的卡片列表
     *
     * @return
     */
    public String getCommonCard(String account_id) ;


}
