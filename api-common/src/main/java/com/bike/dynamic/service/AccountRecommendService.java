package com.bike.dynamic.service;

import com.bike.user.serializable.PageBean;

/**
 * Created by Allen duan on 16/9/25.
 * 推荐用户相关接口
 *
 */
public interface AccountRecommendService {

    /**
     * 根据用户id分页获取推荐用户
     * @param accountId
     * @param pageNum
     * @return
     */
    public PageBean getAccountRecommendList(String accountId, Integer pageNum);

    public boolean recommendUser(String accountId,String comment , Integer isTop );

    public boolean recommendDynamic(Integer dynamicId ,String accountId,String comment,Integer isTop );
}
