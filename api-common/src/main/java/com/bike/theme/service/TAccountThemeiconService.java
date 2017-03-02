package com.bike.theme.service;

import com.bike.activity.model.ChallengeRewardSkin;
import com.bike.theme.model.TAccountThemeicon;

import java.util.List;
import java.util.Map;

/**
 * Created by a700 on 17/1/9.
 * 用户皮肤馆业务
 */
public interface TAccountThemeiconService {

    /**
     * 添加皮肤
     * @param tAccountThemeicon
     * @return
     */
    public TAccountThemeicon addThemeicon(TAccountThemeicon tAccountThemeicon);

    /**
     *
     * @param userId
     * @return
     */
    public List<TAccountThemeicon> queryThemeByUserId(String userId);


    /**
     * 查询用户达成挑战的总数
     * @param userId
     * @return
     */
    public int queryFinishedTheme(String userId);

    /**
     * 查看皮肤详情
     * @param id
     * @return
     */
    public TAccountThemeicon queryThemeicon(Integer id);

    /**
     * 查询用户的挑战获得的皮肤
     * @param userId
     * @param id
     * @return
     */
    public ChallengeRewardSkin queryThemeicon(String userId,Integer id);

    /**
     * 查询达成挑战的总数
     * @param userId
     * @return
     */
    public int queryChallengeRewardTheme(String userId);


    /**
     * 查询用户到达国家的地图
     * @param userId
     * @return
     */
    public List<Map<String, String>> queryCityTheme(String userId);

}
