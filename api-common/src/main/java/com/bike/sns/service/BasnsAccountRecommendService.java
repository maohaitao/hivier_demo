package com.bike.sns.service;

import com.bike.sns.model.BasnsAccountRecommend;

import java.util.List;

/**
 * Created by a700 on 16/10/9.
 */
public interface BasnsAccountRecommendService {

    public List<BasnsAccountRecommend> getAll();

    public BasnsAccountRecommend getAllById(String accountId);

}
