package com.bike.dynamic.service;

import com.bike.dynamic.model.DynamicThumbsup;

import java.util.List;

/**
 * Created by allen duan on 16/9/25.
 * 用户动态点赞相关接口
 */
public interface DynamicThumbsupService {

    /**
     * 給动态点赞
     * @param dynamicThumbsup
     * @return
     */
    public DynamicThumbsup  saveDynamicThumbsup(DynamicThumbsup dynamicThumbsup);

    /**
     * 給个人点赞
     * @param
     * @return
     */
    public DynamicThumbsup  saveUserThumbsup(DynamicThumbsup dynamicThumbsup);

    /**
     * 删除动态点赞
     * @param dynamicThumbsup
     * @return
     */
    public boolean  deleteDynamicThumbsup(DynamicThumbsup dynamicThumbsup);

    /**
     * 查询用户是否点赞该动态
     * @param accountId
     * @param dynamic
     * @return 0否 1是
     */
    public int  checkThumbsup(String accountId,Integer dynamic);


    /**
     * 获取动态点赞总数
     * @param dynamicId
     * @return
     */
    public int getDynamicThumbsupCountById(Integer dynamicId);

    /**
     * 获取用户点赞数
     * @param accountId
     * @return
     */
    public int getThumbsupCountByUserId(String accountId);


    /**
     * 获取用户点赞列表
     * @param start_time
     * @param end_time
     * @param size
     * @return
     */
    public List<DynamicThumbsup> getThumbsupListByDate(String account_id,String start_time,String end_time ,int size,int startEqual);


    /**
     * 获取动态点赞列表
     * @param dynamicId
     * @param limit_time
     * @param size
     * @param type
     * @return
     */
    public List<DynamicThumbsup> getThumbsupListByDynamicId(Integer dynamicId,String limit_time,int size,int type);
}
