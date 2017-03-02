package com.bike.route.service;

import com.bike.route.model.TAccountProps;

import java.util.List;

/**
 * Created by a700 on 16/10/9.
 */
public interface TAccountPropsService {

    public List<TAccountProps> getAllTAccountProps();

    public TAccountProps getTAccountPropsById(int id);

    public List<TAccountProps> getTAccountPropsByAccountId(String accountId);

    public boolean updateTAccountPropsById(TAccountProps accountProps);

    public boolean saveTAccountProps(TAccountProps accountProps);
}
