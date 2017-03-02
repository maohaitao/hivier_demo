package com.bike.theme.service;

import com.bike.theme.model.TAccountAchieve;

/**
 * Created by a700 on 17/1/10.
 */

public interface TAccountAchieveService {

    public TAccountAchieve addTAccountAchieve(TAccountAchieve tAccountThemeicon);

    public TAccountAchieve queryTAccountAchieve(String userId,Integer achieveId);

}
