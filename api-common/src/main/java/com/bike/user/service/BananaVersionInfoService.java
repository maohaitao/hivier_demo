package com.bike.user.service;

import com.bike.user.model.BananaVersionInfo;

import java.util.List;

/**
 * Created by a700 on 16/5/9.
 */
public interface BananaVersionInfoService {

    //    public BananaVersionInfo getNewVersionAnd(String versionId,Integer deviceType);
    public BananaVersionInfo getNewVersion(String versionName, Integer deviceType);

    public List<BananaVersionInfo> getLastVersion();

}
