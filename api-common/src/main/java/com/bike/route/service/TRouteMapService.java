package com.bike.route.service;

import com.bike.route.model.TRouteMap;

import java.util.List;

/**
 * Created by a700 on 16/10/9.
 */
public interface TRouteMapService {

    public List<TRouteMap> getAllRouteMap();

    public List<TRouteMap> getRouteMapByLevel(int level);

    public List<TRouteMap> getRouteMapByLevelIdUserId(String userId,int level);

    public TRouteMap getRouteMapById(int id);
}
