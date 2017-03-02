package com.bike.user.service;

import com.bike.user.entity.TAccountHuanxin;

/**
 * Created by a700 on 16/9/29.
 */
public interface TAccountHuanxinService {

    //新增环信帐号
    public String add(TAccountHuanxin account);

    //环信帐号
    public String get(String accountId);

    //查询用户是否已经注册过环信帐号
    public TAccountHuanxin queryTAccountHuanxinById(String accountId);
}
