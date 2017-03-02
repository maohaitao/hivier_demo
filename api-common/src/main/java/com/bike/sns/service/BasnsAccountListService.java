package com.bike.sns.service;

import com.bike.sns.model.BasnsAccountList;
import com.bike.sns.model.BoardUserinfo;
import com.bike.user.model.TAccount;
import com.bike.user.serializable.PageBean;

import java.util.List;

/**
 * Created by a700 on 16/10/9.
 */
public interface BasnsAccountListService {

    public List<BasnsAccountList> getAll();

    /**
     * 通过Id 获取用户的榜单位置
     *
     * @param Id
     * @return
     */
    public BasnsAccountList getById(String Id);

    public PageBean getAllUserList(Integer pageNam);

    public PageBean getAllUserRankList(Integer pageNam, Integer label, Integer tag, String id);

    public BoardUserinfo getByIdOfType(String Id, Integer label, Integer tag);

    /**
     * 数据库查询关注的用户数
     *
     * @param Id
     * @return
     */
    public Integer getFollowCountByIdInBD(String Id,Integer label,Integer tag);

    public List<TAccount> getFollowCountByIdNotInBD(String Id, Integer label, Integer tag, BoardUserinfo info);
}

