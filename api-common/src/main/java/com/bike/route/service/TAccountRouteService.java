package com.bike.route.service;

import com.bike.route.model.TAccountRoute;
import com.bike.route.model.TRouteMap;

/**
 * Created by a700 on 16/10/9.
 */
public interface TAccountRouteService {

    public TAccountRoute initAccountRoute(String accountId,Integer eng);

    public TAccountRoute getTAccountRouteByAccountId(String accountId);

    public TAccountRoute saveTAccountRoute(TAccountRoute accountRoute);

    public boolean updateTAccountRoute(TAccountRoute accountRoute);

    public boolean updateContinueCount(String accountId,Integer continueCount);

    public TAccountRoute dealEnergy(TAccountRoute accountRoute, Integer energy);

    public TAccountRoute dealCity(TAccountRoute accountRoute);

    public TRouteMap getTRouteMapByCityId(Integer cityId);

    public TAccountRoute getRouteByAccountId(String accountId);
}


