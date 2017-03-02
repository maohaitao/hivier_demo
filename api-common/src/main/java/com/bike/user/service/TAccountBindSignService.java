package com.bike.user.service;

import com.bike.user.model.TAccountBindSign;

import java.util.List;

/**
 * Created by a700 on 16/1/11.
 */
public interface TAccountBindSignService {

    public boolean add(TAccountBindSign sign);

    public List<TAccountBindSign> queryByType(int type);
}
