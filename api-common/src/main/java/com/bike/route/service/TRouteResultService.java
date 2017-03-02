package com.bike.route.service;

import com.bike.route.model.TRouteResult;

import java.util.List;

/**
 * Created by a700 on 16/10/9.
 */
public interface TRouteResultService {

    public List<TRouteResult> getAllTRouteResult(String accountId);

    public List<TRouteResult> getTRouteResultByCityId(String accountId,Integer cityId);

    public TRouteResult saveTRouteResult(TRouteResult routeResult);

    // 获取到达的最近的名次
    public TRouteResult getMapTRouteResult(String cityId);

    public TRouteResult getMapTRouteResult(String userId,String cityId);

    public int getAllMapTRouteResult(String accountId, Integer mapId);
}
