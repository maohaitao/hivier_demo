package com.bike.sns.service;

import com.bike.sns.model.BasnsGameTogether;
import com.bike.sns.model.SnsUserInfo;

import java.util.List;

/**
 * Created by a700 on 16/10/9.
 */
public interface BasnsGameTogetherService {

    /**
     * 同行 取消同行 0 关注 1 取消关注
     *
     * @param followWho
     * @param whoFollow
     * @param type
     * @return
     */
    public boolean together(String followWho, String whoFollow, Integer type);


    /**
     * 批量同行
     *
     * @param whoFollow
     * @param followWhos
     * @return
     */
    public boolean together(String whoFollow, List<String> followWhos);


    /**
     * 根据分页进行批量同行
     *
     * @param whoFollow
     * @param followWhos
     * @return
     */
    public boolean togetherOnPage(String whoFollow, List<String> followWhos,Integer pageNum);

    /**
     * 所有同行用户
     *
     * @param Id
     * @return
     */
    public List<BasnsGameTogether> getAllTogether(String Id);



    /**
     * 同行数据转换
     *
     * @param Id
     * @return
     */
    public List<SnsUserInfo> getTogether(String Id);
}
