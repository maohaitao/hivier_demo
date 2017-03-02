package com.bike.route.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by a700 on 16/3/29.
 * 跑步结果对应的能量
 */
public class RunEnergy implements Serializable {

    private TAccountRoute accountRoute;
    private List<RunResulteMesage> messages;
    private int energy;
    private int awardEnergy; // 奖励能量
    private int cardLimit; // 卡片限制 0 未达到上限  1 达到上限
    private int isCheat; // 是否作弊 0 未达  1 作弊
    private List<TAccountProps> propses;
    private int maxEnergy;
    private int firstCardEnergy;

    public RunEnergy() {
        messages = new ArrayList<RunResulteMesage>();
    }

    public TAccountRoute getAccountRoute() {
        return accountRoute;
    }

    public void setAccountRoute(TAccountRoute accountRoute) {
        this.accountRoute = accountRoute;
    }

    public List<RunResulteMesage> getMessages() {
        return messages;
    }

    public void setMessages(List<RunResulteMesage> messages) {
        this.messages = messages;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public List<TAccountProps> getPropses() {
        return propses;
    }

    public void setPropses(List<TAccountProps> propses) {
        this.propses = propses;
    }

    public int getCardLimit() {
        return cardLimit;
    }

    public void setCardLimit(int cardLimit) {
        this.cardLimit = cardLimit;
    }

    public int getIsCheat() {
        return isCheat;
    }

    public void setIsCheat(int isCheat) {
        this.isCheat = isCheat;
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }

    public void setMaxEnergy(int maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    public int getAwardEnergy() {
        return awardEnergy;
    }

    public void setAwardEnergy(int awardEnergy) {
        this.awardEnergy = awardEnergy;
    }

    public int getFirstCardEnergy() {
        return firstCardEnergy;
    }

    public void setFirstCardEnergy(int firstCardEnergy) {
        this.firstCardEnergy = firstCardEnergy;
    }

    @Override
    public String toString() {
        return "RunEnergy{" +
                "accountRoute=" + accountRoute +
                ", messages=" + messages +
                ", energy=" + energy +
                ", awardEnergy=" + awardEnergy +
                ", cardLimit=" + cardLimit +
                ", isCheat=" + isCheat +
                ", propses=" + propses +
                ", maxEnergy=" + maxEnergy +
                '}';
    }
}
