package com.bike.activity.service;

import com.bike.activity.model.*;
import com.bike.dynamic.model.CardImageDynamic;
import com.bike.user.model.TAccount;

import java.util.List;

/**
 * Created by allen duan on 17/1/16.
 *
 *  成就相关数据处理接口(h5调用)
 */
public interface ChallengeBusinessService {

    /**
     * 获取挑战基本信息
     * @param challengeId
     * @return
     */
    public ChallengeUserSign getChallengeBasicBus(Integer challengeId);

    /**
     * 获取用户挑战详情
     * @param challengeId
     * @return
     */
    public ChallengeUserSign getChallengeUserSignBus(Integer challengeId,String accountId);

    /**
     * 获取挑战相关目标信息、处理目标头及条件
     * @param challengeId
     * @return
     */
    public List<ChallengeTargetResult> listChallengeTargetsBus(Integer challengeId) ;



    /**
     * 根据挑战id获取对应的奖励列表
     * @param challengeId
     * @return
     */
    public List<ChallengeRewardInfo> listRewardInfoByChallengeIdBus(Integer challengeId);

    /**
     * 获取实体奖励信息
     * @param accountId
     * @param challengeId
     * @return
     */
    public ChallengeRewardEntity getChallengeRewardEntityBus(String accountId, Integer challengeId) ;

    /**
     * 获取挑战相关最近n条动态
     * @param challengeId
     * @param size
     * @return
     */
    public List<CardImageDynamic> queryChallengeDynamicBus(Integer challengeId,Integer size);

    /**
     * 获取用户真实地址信息
     * @param accountId
     * @return
     */
    public UserAddressInfo getUserAddressInfoBus(String accountId);

    /**
     * 添加用户真实地址信息
     *
     * @return
     */
    public UserAddressInfo saveUserAddressInfoBus(UserAddressInfo userAddressInfo);

    /**
     * 获取完成挑战相关用户列表
     * @param challengeId
     * @param size
     * @return
     */
    public List<TAccount> listFinishChallengeUsersBus(Integer challengeId, Integer size);


    public List<TAccount> listChallengeRewardEntityUsersBus(Integer challengeId,Integer size);
}
