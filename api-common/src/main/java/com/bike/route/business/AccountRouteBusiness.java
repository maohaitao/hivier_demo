package com.bike.route.business;

import com.bike.bananacard.bean.CardWalkEnergyParam;
import com.bike.route.model.*;
import com.sf.common.exception.AppException;

/**
 * Created by a700 on 16/3/29.
 */
public interface AccountRouteBusiness {
    /**
     * @param distance km
     * @param time     ms
     * @param token
     */
    public RunEnergy runEnergy(String distance, String time, String token) throws AppException;

    public GameResult gameRun(String token) throws AppException;

    public TAccountRoute getRoute(String token) throws AppException;

    public CheckEnergy checkEnergy(String token) throws AppException;

    //获取游戏等级
    public TRouteLevel getLevel(String levelId);

    public RunEnergy cardEnergy(String result, String planResult, String token, Integer cardType,Integer card_id,CardWalkEnergyParam param) throws AppException;


    public TAccountRoute toNewCity(Integer oldcityId, Integer cityId, String token) throws AppException;
}
