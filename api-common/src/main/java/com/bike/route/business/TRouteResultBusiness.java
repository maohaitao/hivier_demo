package com.bike.route.business;

import com.bike.route.model.TRouteResult;
import com.sf.common.exception.AppException;

import java.util.List;

/**
 * Created by a700 on 16/4/15.
 */
public interface TRouteResultBusiness {

    public List<TRouteResult> getRouteResultById(String token) throws AppException;

    
}
