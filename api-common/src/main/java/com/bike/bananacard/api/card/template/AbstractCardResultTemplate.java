package com.bike.bananacard.api.card.template;

import com.bike.bananacard.bean.CardResult;
import com.google.gson.JsonObject;

/**
 * created with bananaCard.
 * user: yanghui@700bike.com
 * date: 16/1/18
 * time: 上午11:15
 * description: 日历卡片结果模板类
 */
public abstract class AbstractCardResultTemplate {
    protected abstract JsonObject result(CardResult cardResult, String version);
}
