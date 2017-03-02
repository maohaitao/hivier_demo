package com.bike.sns.service;

import com.bike.sns.model.BasmsAccountTask;

/**
 * Created by a700 on 16/10/9.
 */
public interface BasmsAccountTaskService {
    public BasmsAccountTask addAccountTask(BasmsAccountTask accountTask);

    public BasmsAccountTask addAccountTask(String acc_id, String assoc_acc_id, Integer u_type);
}
