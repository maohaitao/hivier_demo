package com.bike.bananacard.api.detail.service;

import com.sf.common.exception.AppException;

/**
 * created with bananaCard.
 * user: yanghui@700bike.com
 * date: 16/1/12
 * time: 下午9:13
 * description: 卡片详情service
 */
public interface DetailService {


    public String runDetail(Integer cardId, Integer cardResultId, String accountId) throws AppException ;

    public String walkDetail(Integer cardId, Integer cardResultId, String accountId) throws AppException ;
}
