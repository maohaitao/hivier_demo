package com.hi.service;

import com.hi.model.HiUserInfo;

import java.util.List;

/**
 * Created by a700 on 17/3/3.
 */
public interface HiUserInfoService {

    public boolean addHiUserInfo(HiUserInfo hiUserInfo);

    public HiUserInfo queryHiUserInfo(Integer id);

    public List<HiUserInfo> queryAllHiUserInfo();
}
