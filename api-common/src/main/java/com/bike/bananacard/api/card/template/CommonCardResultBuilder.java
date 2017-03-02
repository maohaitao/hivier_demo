package com.bike.bananacard.api.card.template;

import com.bike.bananacard.bean.TCalendarCards;
import com.bike.bananacard.common.tools.AssertUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sf.common.util.CommonUtil;

/**
 * created with bananaCard.
 * time: 上午11:31
 * description: 构建用户常用卡片列表结果
 */
public class CommonCardResultBuilder {
    private final static String RESULT = "result";
    private JsonObject jsonObject = new JsonObject();
    private TCalendarCards tCalendarCards;

    public CommonCardResultBuilder(TCalendarCards tCalendarCards) {
        AssertUtils.assertNull(tCalendarCards, "tCalendarCards");
        this.tCalendarCards = tCalendarCards;
        init();
    }

    private void init() {
        if (tCalendarCards != null) {
            this.jsonObject.addProperty("card_id", tCalendarCards.getId());
            this.jsonObject.addProperty("card_name", tCalendarCards.getCardName());
            if (!CommonUtil.isNull(tCalendarCards.getCardIcon())) {
                this.jsonObject.addProperty("card_icon", tCalendarCards.getCardIcon());
            }
            this.jsonObject.addProperty("card_style", tCalendarCards.getCardStyle());
            this.jsonObject.addProperty("card_desc", tCalendarCards.getCardRecommend());
            this.jsonObject.addProperty("card_unit", tCalendarCards.getCardUnit());
            this.jsonObject.addProperty("is_del", tCalendarCards.getIsDel());
            this.jsonObject.addProperty("is_common", tCalendarCards.getIsCommon());
        }
    }

    private void appendResult(JsonObject jsonObject) {
        if (jsonObject == null) {
            return;
        }
        JsonArray jsonArray = new JsonArray();
        if (this.jsonObject.has(RESULT)) {
            jsonArray = this.jsonObject.getAsJsonArray(RESULT);
        }
        jsonArray.add(jsonObject);
        this.jsonObject.add(RESULT, jsonArray);
    }

    public JsonObject getResult() {
        return this.jsonObject;
    }

}
