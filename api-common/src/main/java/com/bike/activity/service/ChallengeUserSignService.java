package com.bike.activity.service;

import com.bike.activity.model.ChallengeBasic;
import com.bike.activity.model.ChallengeUserSign;
import com.bike.user.model.TAccount;

import java.util.List;

/**
 * Created by allen duan on 17/1/9.
 *
 * 用户挑战接口
 */
public interface ChallengeUserSignService {

    /**
     * 用户参与或退出挑战
     * @param accountId
     * @param challengeBasic
     * @param type 0 参与挑战  1 退出挑战
     * @return
     */
      public ChallengeUserSign joinQuitchallenge(String accountId, ChallengeBasic challengeBasic, Integer type);

    /**
     * 获取用户挑战信息
     * @return
     */
    public ChallengeUserSign getChallengeUserSign(String accountId,Integer challengeId);


    /**
     * 获取用户挑战列表
     * @param accountId
     * @param type 1 所有参与的挑战 2 进行中的挑战
     * @return
     */
    public List<ChallengeUserSign> listChallengeUserSigns(String accountId,Integer type);


    /**
     *
     * @param challengeId
     * @param type 1、参与挑战 2、完成挑战
     * @return
     */
    public Integer getUserChallengeCount(Integer challengeId,Integer type);


    /**
     * 获取完成挑战用户列表
     * @param challengeId
     * @param size
     * @return
     */
    public List<TAccount> listFinishChallengeUsers(Integer challengeId, Integer size);
}
