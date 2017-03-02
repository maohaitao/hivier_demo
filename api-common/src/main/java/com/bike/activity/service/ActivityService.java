package com.bike.activity.service;


import com.bike.activity.model.ActivityMobileDTO;

/**
 * Created by a700 on 16/12/22.
 */
public interface ActivityService {
    public ActivityMobileDTO getActivityDetail(Long activityId);
}
