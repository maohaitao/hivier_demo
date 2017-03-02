package com.bike.activity.model;

import java.io.Serializable;

/**
 * Created by a700 on 17/1/22.
 */
public class ChallengeBean implements Serializable {

    private Integer id;

    private String challengeName;//'挑战名称'

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChallengeName() {
        return challengeName;
    }

    public void setChallengeName(String challengeName) {
        this.challengeName = challengeName;
    }
}
