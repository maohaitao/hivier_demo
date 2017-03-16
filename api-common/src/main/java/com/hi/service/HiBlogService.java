package com.hi.service;

import com.hi.model.HiBlog;
import com.hi.model.HiUserInfo;

import java.util.List;

/**
 * Created by a700 on 17/3/3.
 */
public interface HiBlogService {

    public boolean addHiBlog(HiBlog hiBlog);

    public HiBlog queryHiBlog(Integer id);

    public List<HiBlog> queryAllHiBlog();
}
