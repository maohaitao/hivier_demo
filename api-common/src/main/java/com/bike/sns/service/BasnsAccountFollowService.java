package com.bike.sns.service;

import com.bike.sns.model.BasnsAccountFollow;
import com.bike.user.serializable.PageBean;

import java.util.List;

/**
 * Created by a700 on 16/10/9.
 */
public interface BasnsAccountFollowService {

    /**
     * 查询所有关注用户
     *
     * @param accoutId
     * @return
     */
    public List<BasnsAccountFollow> getAllFollowList(String accoutId);

    /**
     * 关注列表 分页
     *
     * @param accountId
     * @param pageNam
     * @return
     */
    public PageBean getAllFollowWho(String accountId, Integer pageNam);

    /**
     * 关注列表 分页 2.8
     *
     * @param accountId
     * @param pageNam
     * @return
     */
    public PageBean getAllFollowWhoOnPage(String accountId, Integer pageNam);

    public List<BasnsAccountFollow> getAllFollowWhoOnPrePage(String accountId, Integer pageNam);

    // 粉丝列表
    public PageBean getAllWhoFollow(String accountId, Integer pageNam);

    /**
     * 查询互相关注的用户
     *
     * @param accountId
     * @param pageNam
     * @return
     */
    public PageBean getAllEachFollow(String accountId, Integer pageNam);

    /**
     * 查询互相关注的用户总数
     *
     * @param accountId
     * @return
     */
    public int getAllEachFollowCount(String accountId);

    /**
     * 关注取消关注 0 关注 1 取消关注
     *
     * @param followWho
     * @param whoFollow
     * @param type
     * @return
     */
    public Integer followWho(String followWho, String whoFollow, Integer type,String version);

    public boolean isFollow(String followWho, String whoFollow);

    public boolean isBeFollow(String followWho, String whoFollow);

    public Integer getFollowStatus(String followWho, String whoFollow);

    /*
     * 关注用户缓存自增信息
     * @param followWho
     * @param whoFollow
     * @return

    private void dealCacheFollowCount(String followWho, String whoFollow);*/

    public List<String> getNewFollowList(String followWho);

    public Long getNewFansCount(String followWho);

    public void deleteNewFollowCount(String id, List<String> ids);

    /**
     * 获取用户关注用户数量
     *
     * @param Id
     * @return
     */
    public Integer getFollowCount(String Id);

/*    *//**
     * 数据库查询关注的用户数
     * @param Id
     * @return
     *//*
    private Integer getFollowCountById(String Id);*/

    /**
     * 获取被关注的用户数(粉丝数)
     * @param Id
     * @return
     */
    public Integer getFansCount(String Id);

    /**
     * 定时更新所有的粉丝数和关注数
     * @param Id
     * @return
     */
    public boolean cacheFans(String Id);

    /**
     * 所有粉丝缓存同步
     * @return
     */
    public boolean cacheBeFollowAll();

    public boolean cacheFollow(String Id);

    /**
     * 所有粉丝缓存同步
     * @return
     */
    public boolean cacheFollowAll();

    /**
     * 数据查询被关注(粉丝)用户数
     *
     * @param Id
     * @return
     */
    /*private Integer getBeFollowCountById(String Id);*/
}
