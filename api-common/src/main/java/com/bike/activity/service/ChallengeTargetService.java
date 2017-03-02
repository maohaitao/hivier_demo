package com.bike.activity.service;

import com.bike.activity.model.ChallengeBasic;
import com.bike.activity.model.ChallengeTarget;
import com.bike.activity.model.ChallengeTargetResult;
import com.bike.activity.model.TargetResultHessian;
import com.bike.bananacard.bean.CardResult;
import com.bike.dynamic.model.CardImageDynamic;

import java.util.List;

/**
 * Created by allen duan on 17/1/9.
 *
 * 挑战目标接口
 */
public interface ChallengeTargetService {

    /**
     * 挑战目标列表
     * @return
     */
    public List<ChallengeTargetResult> listChallengeTargets(Integer challengeId);

    /**
     * 用户挑战目标达成情况
     * @return
     */
    public List<ChallengeTargetResult> listUserChallengeTargetResults(Integer challengeId,String accountId);

    /**
     * 处理用户打卡对于的挑战
     * @return
     */
    public void doUserChallenge(CardImageDynamic cardImageDynamic);

    /**
     * 初始化用户挑战达标记录
     * @param challengeBasic
     * @param accountId
     * @return
     */
    public boolean addChallengeTargetResult(ChallengeBasic challengeBasic,String accountId);

    /**
     * 刪除用户挑战达标记录
     * @param challengeId
     * @param accountId
     * @return
     */
    public boolean delChallengeTargetResult(Integer challengeId,String accountId);

    /**
     * 0 失败 1 保存成功 2 挑战成功
     * @param targetResultHessian
     * @return
     */
    public int processUserTargetResult(TargetResultHessian targetResultHessian,int status);

    public double getTargetSumWalk(String accountId,String start_time,Integer startWalk);
}
