package com.bike.sns.service;

import com.bike.user.serializable.PageBean;

/**
 * Created by a700 on 16/10/9.
 */
public interface BasnsAccountLikeService {
    /**
     * 用户点赞数量
     *
     * @param likeWho
     * @param whoLike
     * @return
     */
    public boolean like(String likeWho, String whoLike);

    public PageBean likeAll(String likeWho, Integer pageNam);


    /**
     * 获取点赞的用户数
     *
     * @param likewho
     * @return
     */
    public Integer getBeLikeCount(String likewho);

    /**
     * 定时同步缓存
     * @param likewho
     * @return
     */
    public boolean cacheBeLikeCount(String likewho);

    /**
     * 获取新增点赞用户列表
     *
     * @param likewho
     * @return
     */
    public Integer getNewLikeCount(String likewho);

    public Integer getLikedToday(String likeWho, String whoLike);


    /**
     * 定时同步所有的数据
     * @return
     */
    public boolean cacheLikeAll();
}
