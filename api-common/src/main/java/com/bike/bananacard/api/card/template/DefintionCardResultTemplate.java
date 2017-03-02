package com.bike.bananacard.api.card.template;

import com.bike.apicommon.AppContext;
import com.bike.apicommon.cache.RedisService;
import com.bike.bananacard.bean.TDefintionCardResult;
import com.bike.bananacard.common.tools.DateUtils;
import com.bike.bananacard.bean.CardResult;
import com.google.gson.JsonObject;
import com.sf.common.util.CommonUtil;

import java.util.Calendar;

/**
 * Created by a700 on 16/7/13.
 */
public class DefintionCardResultTemplate extends AbstractCardResultTemplate {
    @Override
    protected JsonObject result(CardResult cardResult, String versionid) {
        TDefintionCardResult commonCardResult = (TDefintionCardResult) cardResult;
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("punch_date", DateUtils.getDate(commonCardResult.getStartTime()));
        jsonObject.addProperty("card_result_id", commonCardResult.getId());
        jsonObject.addProperty("card_result", commonCardResult.getResult());
        jsonObject.addProperty("card_plan_result", commonCardResult.getPlanResult());

        jsonObject.addProperty("kcal", commonCardResult.getKcal());
        if (commonCardResult.getEndTime() != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(commonCardResult.getEndTime());
            if (calendar.get(Calendar.HOUR_OF_DAY) == 0 && calendar.get(Calendar.MINUTE) == 0 && calendar.get(Calendar.SECOND) == 0) {
                jsonObject.addProperty("finish_time", commonCardResult.getCreateTime().getTime());
            } else {
                jsonObject.addProperty("finish_time", commonCardResult.getEndTime().getTime());
            }
        } else {
            jsonObject.addProperty("finish_time", commonCardResult.getCreateTime().getTime());
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
        return jsonObject;
    }
}
