package com.bike.bananacard.api.card.template;

import com.bike.bananacard.bean.*;
import com.bike.bananacard.common.cache.data.CardCache;
import com.bike.bananacard.common.cache.data.CourseCache;
import com.bike.bananacard.common.cache.data.QueryCache;
import com.bike.bananacard.common.constant.AppContext;
import com.bike.bananacard.common.constant.CardStyle;
import com.bike.bananacard.common.tools.AssertUtils;
import com.bike.bananacard.common.tools.json.JsonUtils;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sf.common.util.CommonUtil;

/**
 * created with bananaCard.
 * user: yanghui@700bike.com
 * date: 16/1/25
 * time: 上午11:31
 * description: 构建用户卡片列表结果
 */
public class CardResultBuilder {
    private final static String RESULT = "result";
    private JsonObject jsonObject = new JsonObject();
    private UserCard userCard;

    public CardResultBuilder(UserCard userCard) {
        AssertUtils.assertNull(userCard, "userCard");
        this.userCard = userCard;
        init();
    }

    private void init() {
        if (userCard != null) {
            this.jsonObject.addProperty("card_id", userCard.getId());
            TCalendarCards tCalndarCards = QueryCache.get(CardCache.CALENDAR_CARDS_KEY, userCard.getId());
            if(tCalndarCards!=null){
                this.jsonObject.addProperty("isExtend",tCalndarCards.getIsExtend());
                this.jsonObject.addProperty("extendImage",tCalndarCards.getExtendImage());
            }
            this.jsonObject.addProperty("card_name", userCard.getCardName());
            if (!CommonUtil.isNull(userCard.getCardIcon())) {
                this.jsonObject.addProperty("card_icon", userCard.getCardIcon());
            }
            this.jsonObject.addProperty("card_style", userCard.getCardStyle());
            this.jsonObject.addProperty("card_desc", userCard.getCardRecommend());
            this.jsonObject.addProperty("card_unit", userCard.getCardUnit());
            this.jsonObject.addProperty("is_del", userCard.getIsDel());
            // 体重卡 跑步卡 走路卡设置为非常用卡片
            if (CardStyle.CARD_STYLE_WALK.equals(userCard.getCardStyle()) ||
                    CardStyle.CARD_STYLE_RUN.equals(userCard.getCardStyle())
                    || userCard.getId()== AppContext.WEIGHT_CARDID) {
                this.jsonObject.addProperty("is_common", AppContext.IS_COMMON_CARD_NO);
            } else {
                this.jsonObject.addProperty("is_common", userCard.getIsCommon());
            }
            if (CardStyle.CARD_STYLE_COURSE_RUNN.equals(userCard.getCardStyle())) {
                initCourceData();
            }
            Object[] validDates = userCard.getValidDates() != null ? userCard.getValidDates().toArray() : null;
            initValidData(validDates);
        }
    }

    private void initValidData(Object[] validDates) {
        if (validDates != null && validDates.length > 0) {
            ValidDate validDate = (ValidDate) validDates[validDates.length - 1];
            this.jsonObject.addProperty("is_day_card", validDate.getIsDayCard());
            if (AppContext.IS_DAY_CARD_YES == validDate.getIsDayCard()) {
                this.jsonObject.addProperty("every_start_date", validDate.getStartDate());
            }
        } else {
            this.jsonObject.addProperty("is_day_card", userCard.getIsDayCard());
        }
        this.jsonObject.add("valid_dates", JsonUtils.toJson(validDates));
    }

    private void initCourceData() {
        TCourse course = QueryCache.get(CourseCache.COURSE_KEY, userCard.getCourseId());
        if (course != null) {
            this.jsonObject.addProperty("course_id", course.getId());
            this.jsonObject.addProperty("course_version", course.getVersion());
            this.jsonObject.addProperty("course_config_file", course.getConfigFlie());
            this.jsonObject.addProperty("course_total_lesson", course.getLesson());
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

    public void appendResult(CardResult cardResult, String versionId) {
        AbstractCardResultTemplate abstractCardResultTemplate = null;
        if (cardResult instanceof TCommonCardResult) { // 自定义卡
            abstractCardResultTemplate = new CommonCardResultTemplate();
        } else if (cardResult instanceof TDefintionCardResult) { // 自定义卡
            abstractCardResultTemplate = new DefintionCardResultTemplate();
        } else if (cardResult instanceof TRunCardResult) {
            abstractCardResultTemplate = new RunCardResultTemplate();
        } else {
            abstractCardResultTemplate = new AbstractCardResultTemplate() {
                @Override
                protected JsonObject result(CardResult cardResult, String versionId) {
                    return null;
                }
            };
        }
        appendResult(abstractCardResultTemplate.result(cardResult, versionId));
    }

}
