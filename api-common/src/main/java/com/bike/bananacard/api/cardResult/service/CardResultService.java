package com.bike.bananacard.api.cardResult.service;

import com.bike.bananacard.bean.CardWalkEnergyParam;
import com.bike.bananacard.bean.TCommonCardResult;
import com.bike.bananacard.bean.TRunCardResult;
import com.bike.route.model.RunEnergy;
import com.sf.common.exception.AppException;

import java.util.Date;

/**
 * created with bananaCard.
 * user: yanghui@700bike.com
 * date: 16/1/12
 * time: 下午9:13
 * description: 卡片数据上传service
 */
public interface CardResultService {


    public RunEnergy rsyncCard(Double result, Double plan_result, String token, Integer cardType, Integer cardId, CardWalkEnergyParam param);

    public String uploadCommonResult(TCommonCardResult commonCardResult, String token,String v) throws AppException ;

    public String uploadRunResult(TRunCardResult runCardResult, String token, Integer isCheat) throws AppException ;

    public void noExistAddCard(Integer cardId, String accountId, Date startDate) throws AppException ;

    public String deleteCardResult(Integer cardId, Integer cardResultId, String accountId) throws AppException ;


    public boolean updateRuncardImange(Integer id ,String runCardImage) throws AppException ;
}
