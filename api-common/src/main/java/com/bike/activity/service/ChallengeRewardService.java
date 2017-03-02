package com.bike.activity.service;

import com.bike.activity.model.ChallengeRewardEntity;
import com.bike.activity.model.ChallengeRewardInfo;
import com.bike.activity.model.ChallengeRewardSkin;
import com.bike.activity.model.UserAddressInfo;
import com.bike.user.model.TAccount;

import java.util.List;

/**
 * Created by allen duan on 17/1/9.
 * 挑战奖励信息
 */
public interface ChallengeRewardService {

    /**
     * 根据挑战id获取对应的奖励列表
     * @param challengeId
     * @return
     */
    public List<ChallengeRewardInfo> listRewardInfoByChallengeId(Integer challengeId);


    /**
     * 用戶皮肤馆挑战相关皮肤
     * @return
     */
    public List<ChallengeRewardSkin> listRewardSkinsByUserId(String accountId);

    /**
     * 用户挑战实物奖励
     * @param accountId
     * @param challengeId
     * @return
     */
    public ChallengeRewardEntity getChallengeRewardEntity(String accountId,Integer challengeId);

    /**
     * 根据挑战id获取实物用户奖励列表
     * @param challengeId
     * @return
     */
    public List<TAccount> listChallengeRewardEntityUsers(Integer challengeId,Integer size);


    /**
     * 获取用户真实地址信息
     * @param accountId
     * @return
     */
    public UserAddressInfo getUserAddressInfo(String accountId);

    /**
     * 添加用户真实地址信息
     *
     * @return
     */
    public UserAddressInfo saveUserAddressInfo(UserAddressInfo userAddressInfo);


}
