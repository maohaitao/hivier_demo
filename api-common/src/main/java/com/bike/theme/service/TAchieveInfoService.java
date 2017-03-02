package com.bike.theme.service;

import com.bike.theme.model.TAchieveInfo;

import java.util.List;

/**
 * Created by a700 on 17/1/9.
 */
public interface TAchieveInfoService {

    /**
     * 定时查询所有设置成功的成就策略
     * @return
     */
    public List<TAchieveInfo> queryDB();

    /**
     * 更新所有的成就策略
     * @return
     */
    public List<TAchieveInfo> queryAllAchieve();

    public List<TAchieveInfo> queryNoDoAchieveByUserId(String userId);

    public TAchieveInfo queryAchieveByAchieveId(Integer id);

    public TAchieveInfo queryAchieveById(Integer id);
}
