package com.bike.activity.service;

import com.bike.activity.model.ChallengeBasic;
import java.util.List;

/**
 * Created by allen duan on 17/1/9.
 *
 * 挑战基本信息接口
 */
public interface ChallengeBasicService {

    public List<ChallengeBasic> listLatestChallenges(Integer size,Integer challengeId);

    /**
     * type 1 、获取正在推广的挑战列表 2 、获取挑战时间降序排列列表
     *
     * @return
     */
    public List<ChallengeBasic> listChallenges(Integer type);

    public List<ChallengeBasic> listChallengesByIds(String challengeIds);


    /**
     * 获取日历广告推广的挑战
     * @return
     */
    public ChallengeBasic getCalendarAdvertChallenge();

    /**
     * 获取挑战基础信息
     * @return
     */
    public ChallengeBasic getChallengeById(Integer challengeId);


}
