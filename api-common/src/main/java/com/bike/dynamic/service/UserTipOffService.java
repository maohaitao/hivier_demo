package com.bike.dynamic.service;

import com.bike.dynamic.model.UserTipOff;

/**
 * Created by allen duan on 16/9/28.
 * 用户举报接口
 */
public interface UserTipOffService {
    /**
     * 保存动态举报
     * @param userTipOff
     * @return
     */
    public UserTipOff saveUserTipoff(UserTipOff userTipOff);


}
