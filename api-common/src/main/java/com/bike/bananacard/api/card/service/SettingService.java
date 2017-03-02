package com.bike.bananacard.api.card.service;

import com.sf.common.exception.AppException;

public interface SettingService {

    public String getPlanList(String accountId, String versionid) throws AppException ;


    public boolean updateplan(Integer settingId, double planvalue, String accountId) throws AppException ;

    public String checkSetting(Integer settingId, Double planvalue, String accountId) throws AppException ;

    public String getSetting(String accountId, Integer cardId, String versionid) throws AppException ;

    public boolean updateSetting(Integer settingId, Double planvalue, String accountId, String starttime, String endtime, Double beforeValue) throws AppException ;

    public String changeSetting(Integer settingId, double planvalue, String accountId, String starttime, String endtime, Double beforeValue) throws AppException ;

}
