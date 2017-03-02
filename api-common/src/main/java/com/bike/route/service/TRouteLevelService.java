package com.bike.route.service;

import com.bike.route.model.TRouteLevel;
import com.google.gson.JsonObject;

import java.util.List;

/**
 * Created by a700 on 16/10/9.
 */
public interface TRouteLevelService {
    public List<TRouteLevel> getAllLevel();

    public TRouteLevel getTRouteLevelByLevel(int level);

    public List<TRouteLevel> getAllLevelByStatus();

}
