package com.bike.bananacard.api.card.template;

import com.bike.apicommon.AppContext;
import com.bike.apicommon.cache.RedisService;
import com.bike.bananacard.bean.CardResult;
import com.bike.bananacard.bean.TCommonCardResult;
import com.bike.bananacard.common.tools.DateUtils;
import com.google.gson.JsonObject;
import com.sf.common.util.CommonUtil;
import com.sf.common.util.DateCoverd;

import java.util.Calendar;
import java.util.Date;

/**
 * created with bananaCard.
 * user: yanghui@700bike.com
 * date: 16/1/18
 * time: 上午11:32
 * description: 通用结果模板
 */
public class CommonCardResultTemplate extends AbstractCardResultTemplate {

    public static void main(String[] args) {
        DateCoverd.toDate(DateCoverd.toString(new Date(), DateCoverd.FORMART_YYYY_MM_DD), DateCoverd.FORMART_YYYY_MM_DD);
        String FORMART_HH_MM_SS = "HH:mm:ss";
        Long date = DateCoverd.toDate("2016-06-18 12:34:45").getTime() - DateCoverd.toDate("2016-06-18 12:34:45", DateCoverd.FORMART_YYYY_MM_DD).getTime();
        System.out.println(date);
    }

    @Override
    public JsonObject result(CardResult cardResult, String versionid) {
        TCommonCardResult commonCardResult = (TCommonCardResult) cardResult;
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("punch_date", DateUtils.getDate(commonCardResult.getStartTime()));
        jsonObject.addProperty("card_result_id", commonCardResult.getId());
        if (!CommonUtil.isNull(versionid) && versionid.compareTo("2.0") >= 0) { // TODO 2.0版本后区分
            jsonObject.addProperty("card_result", commonCardResult.getResult());
            jsonObject.addProperty("card_plan_result", commonCardResult.getPlanResult());
        } else {
            jsonObject.addProperty("card_result", commonCardResult.getResult() != null ? commonCardResult.getResult().intValue() : 0);
            jsonObject.addProperty("card_plan_result", commonCardResult.getPlanResult() != null ? commonCardResult.getPlanResult().intValue() : 0);
        }

        if (!CommonUtil.isNull(versionid) && versionid.compareTo("3.0") >= 0) {//3.0 dynamic_id xia fa
            String dynamicId = RedisService.getJedisCache().get( commonCardResult.getCardId()+"##"+commonCardResult.getId());
            if(!CommonUtil.isNull(dynamicId)&&dynamicId.contains(AppContext.KEY_MAP)){
                dynamicId = dynamicId.replace(AppContext.KEY_MAP,"");
                if(CommonUtil.isNumber(dynamicId)){
                    jsonObject.addProperty("dynamicId",Integer.parseInt(dynamicId));
                }

            }
        }

        jsonObject.addProperty("plan_before_result", commonCardResult.getPlanBeforeResult());
        if (commonCardResult.getPlanStartTime() != null) {
            jsonObject.addProperty("plan_start_time", DateCoverd.toString(commonCardResult.getPlanStartTime(), DateCoverd.FORMART_YYYY_MM_DD));
        }
        jsonObject.addProperty("kcal", commonCardResult.getKcal());
        jsonObject.addProperty("sequence", commonCardResult.getSequence());
        if (commonCardResult.getEndTime() != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(commonCardResult.getEndTime());
            if (calendar.get(Calendar.HOUR_OF_DAY) == 0 && calendar.get(Calendar.MINUTE) == 0 && calendar.get(Calendar.SECOND) == 0) {
                jsonObject.addProperty("finish_time", commonCardResult.getCreateTime().getTime());//TODO HESIN
            } else {
                jsonObject.addProperty("finish_time", commonCardResult.getEndTime().getTime());//TODO HESIN
            }
        } else {
            jsonObject.addProperty("finish_time", commonCardResult.getCreateTime().getTime());//TODO HESIN
        }
        jsonObject.addProperty("isCheat", commonCardResult.getIsCheat());
        return jsonObject;
    }
}
