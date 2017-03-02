package com.bike.route.model;


import java.io.Serializable;

/**
 * Created by a700 on 16/3/31.
 */
public class GameResult implements Serializable {

    private TAccountRoute accountRoute;
    private int runDistance; // 前进的距离
    private int energy; // 能量
    private int overflowenergy; // 溢出能量

    public int getRunDistance() {
        return runDistance;
    }

    public void setRunDistance(int runDistance) {
        this.runDistance = runDistance;
    }

    public TAccountRoute getAccountRoute() {
        return accountRoute;
    }

    public void setAccountRoute(TAccountRoute accountRoute) {
        this.accountRoute = accountRoute;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getOverflowenergy() {
        return overflowenergy;
    }

    public void setOverflowenergy(int overflowenergy) {
        this.overflowenergy = overflowenergy;
    }
}
