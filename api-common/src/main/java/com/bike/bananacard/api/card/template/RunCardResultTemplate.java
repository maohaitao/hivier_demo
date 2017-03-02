package com.bike.bananacard.api.card.template;

import com.bike.apicommon.AppContext;
import com.bike.apicommon.cache.RedisService;
import com.bike.bananacard.bean.CardResult;
import com.bike.bananacard.bean.TRunCardResult;
import com.bike.bananacard.common.tools.DateUtils;
import com.g3.common.util.CommonUtil;
import com.google.gson.JsonObject;
import com.sf.common.util.DateCoverd;

/**
 * created with bananaCard.
 * user: yanghui@700bike.com
 * date: 16/1/18
 * time: 上午11:32
 * description: 跑步结果模板
 */
public class RunCardResultTemplate extends AbstractCardResultTemplate {

    @Override
    public JsonObject result(CardResult cardResult, String versionId) {
        TRunCardResult runCardResult = (TRunCardResult) cardResult;
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("punch_date", DateUtils.getDate(runCardResult.getStartTime()));
        jsonObject.addProperty("card_result_id", runCardResult.getId());
        jsonObject.addProperty("speed", runCardResult.getSpeed());
        jsonObject.addProperty("fast_speed", runCardResult.getFastSpeed());
        jsonObject.addProperty("total_time", runCardResult.getTotalTime());
        jsonObject.addProperty("total_distance", runCardResult.getTotalDistance());
        jsonObject.addProperty("course_week", runCardResult.getCourseWeek());
        jsonObject.addProperty("course_lesson", runCardResult.getCourseLesson());
        jsonObject.addProperty("course_day", runCardResult.getCourseDay());
        jsonObject.addProperty("course_lesson_name", runCardResult.getCourseLessonName());
        jsonObject.addProperty("kcal", runCardResult.getKcal());
        jsonObject.addProperty("start_time", DateCoverd.toString(runCardResult.getStartTime()));
        jsonObject.addProperty("end_time", DateCoverd.toString(runCardResult.getEndTime()));
        jsonObject.addProperty("run_pace", runCardResult.getRunPace());
        jsonObject.addProperty("city_name", CommonUtil.isNull(runCardResult.getCityName())?"":runCardResult.getCityName());
        jsonObject.addProperty("run_type", runCardResult.getRunType());
        jsonObject.addProperty("runCardImage", runCardResult.getRunCardImage());
        jsonObject.addProperty("isCheat", runCardResult.getIsCheat());
        if (!com.sf.common.util.CommonUtil.isNull(versionId) && versionId.compareTo("3.0") >= 0) {//3.0 dynamic_id xia fa
            String dynamicId = RedisService.getJedisCache().get( runCardResult.getCardId()+"##"+runCardResult.getId());
            if(!com.sf.common.util.CommonUtil.isNull(dynamicId)&&dynamicId.contains(AppContext.KEY_MAP)){
                dynamicId = dynamicId.replace(AppContext.KEY_MAP,"");
                if(com.sf.common.util.CommonUtil.isNumber(dynamicId)){
                    jsonObject.addProperty("dynamicId",Integer.parseInt(dynamicId));
                }

            }
        }
        return jsonObject;
    }
}
