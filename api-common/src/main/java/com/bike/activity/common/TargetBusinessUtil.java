package com.bike.activity.common;

import com.bike.activity.model.ChallengeTargetResult;
import com.sf.common.util.CommonUtil;

import java.util.List;

/**
 * Created by a700 on 17/1/16.
 */
public class TargetBusinessUtil {

    /**
     * cardId : -1 所有卡 0 运动卡 1 计步卡 2 跑步卡 50体重卡
     * countType : 1 打卡天数 2 连续打卡天数 3 公里和 4 连续走步天数 5 计步和 6 累计打卡
     *
     * @param challengeTargetResultList
     */
    public static void processTargetTitleForSkin(List<ChallengeTargetResult> challengeTargetResultList){
        if(null!=challengeTargetResultList && challengeTargetResultList.size()>0){
            for (ChallengeTargetResult challengeTargetResult:challengeTargetResultList){
                Integer cardId = challengeTargetResult.getCardId();
                Integer countType = challengeTargetResult.getCountType();
                if(countType==1){
                    challengeTargetResult.setTargetTitle("挑战期间累计打"+getCardName(cardId) +"卡"+challengeTargetResult.getTarget().intValue()+"天");
                }else if(countType==2){
                    challengeTargetResult.setTargetTitle("挑战期间连续打"+getCardName(cardId) +"卡"+challengeTargetResult.getTarget().intValue()+"天");
                }else if(countType==6){
                    challengeTargetResult.setTargetTitle("挑战期间累计打"+getCardName(cardId) +"卡"+challengeTargetResult.getTarget().intValue()+"次");
                }
                if(cardId==1 ){
                    if(countType==4){
                        challengeTargetResult.setTargetTitle("挑战期间连续走路"+challengeTargetResult.getTarget().intValue()+"天");
                    }else if(countType==5){
                        challengeTargetResult.setTargetTitle("挑战期间累计走路"+challengeTargetResult.getTarget().intValue()+"步");
                    }
                }else if(cardId==2 ){
                    if(countType==3){
                        challengeTargetResult.setTargetTitle("挑战期间累计跑步"+challengeTargetResult.getTarget()+"KM");
                    }
                }
            }
        }

    }

    /**
     * cardId : -1 所有卡 0 运动卡 1 计步卡 2 跑步卡 50体重卡
     * countType : 1 打卡天数 2 连续打卡天数 3 公里和 4 连续走步天数 5 计步和 6 累计打卡
     *
     * @param challengeTargetResultList
     */
    public static void processTargetTitleAndCondition(List<ChallengeTargetResult> challengeTargetResultList){
        if(null!=challengeTargetResultList && challengeTargetResultList.size()>0){
            for (ChallengeTargetResult challengeTargetResult:challengeTargetResultList){
                Integer cardId = challengeTargetResult.getCardId();
                Integer countType = challengeTargetResult.getCountType();
                if(countType==1){
                    challengeTargetResult.setTargetTitle("挑战期间，累计打"+getCardName(cardId) +"卡#"+challengeTargetResult.getTarget().intValue()+"#天");
                }else if(countType==2){
                    challengeTargetResult.setTargetTitle("挑战期间，连续打"+getCardName(cardId) +"卡#"+challengeTargetResult.getTarget().intValue()+"#天");
                }else if(countType==6){
                    challengeTargetResult.setTargetTitle("挑战期间，累计打"+getCardName(cardId) +"卡#"+challengeTargetResult.getTarget().intValue()+"#次");
                }
                if(cardId==1 ){
                    if(countType==4){
                        challengeTargetResult.setTargetTitle("挑战期间，连续走路#"+challengeTargetResult.getTarget().intValue()+"#天");
                    }else if(countType==5){
                        challengeTargetResult.setTargetTitle("挑战期间，累计走路#"+challengeTargetResult.getTarget().intValue()+"#步");
                    }
                    if(challengeTargetResult.getStartWalkCount()!=null&&challengeTargetResult.getStartWalkCount()>0){
                        challengeTargetResult.setTargetCondition("计步卡需要超过"+challengeTargetResult.getStartWalkCount()+"步才会计入成绩");
                    }

                }else if(cardId==2 ){
                    if(countType==3){
                        challengeTargetResult.setTargetTitle("挑战期间，累计跑步#"+challengeTargetResult.getTarget()+"#KM");
                    }
                    processCondition(challengeTargetResult);
                }
            }
        }

    }

    /**
     * cardId : -1 所有卡 0 运动卡 1 计步卡 2 跑步卡 50体重卡
     * countType : 1 打卡天数 2 连续打卡天数 3 公里和 4 连续走步天数 5 计步和
     *
     * @param challengeTargetResultList
     */
    public static  void processTargetTitleAndConditionJoin(List<ChallengeTargetResult> challengeTargetResultList) {
        if (null != challengeTargetResultList && challengeTargetResultList.size() > 0) {
            for (ChallengeTargetResult challengeTargetResult : challengeTargetResultList) {
                Integer cardId = challengeTargetResult.getCardId();

                Integer countType = challengeTargetResult.getCountType();
                if (countType == 1) {
                    challengeTargetResult.setTargetTitle("累计打" + getCardName(cardId) + "卡天数");
                } else if (countType == 2) {
                    challengeTargetResult.setTargetTitle("连续打" + getCardName(cardId)  + "卡天数");
                }else if (countType == 6) {
                    challengeTargetResult.setTargetTitle("累计打" + getCardName(cardId)  + "卡次数");
                }
                if (cardId == 1) {
                    if (countType == 4) {
                        challengeTargetResult.setTargetTitle("连续走路天数");
                    } else if (countType == 5) {
                        challengeTargetResult.setTargetTitle("累计走路步数");
                    }
                    if (challengeTargetResult.getStartWalkCount() != null && challengeTargetResult.getStartWalkCount() > 0) {
                        challengeTargetResult.setTargetCondition("计步卡需要超过" + challengeTargetResult.getStartWalkCount() + "步才会计入成绩");
                    }
                } else if (cardId == 2) {
                    if (countType == 3) {
                        challengeTargetResult.setTargetTitle("累计跑步公里数");
                    }
                    processCondition(challengeTargetResult);
                }
            }
        }
    }


    public static void processCondition(ChallengeTargetResult challengeTargetResult){
        String condition = "";
        if (!CommonUtil.isNull(challengeTargetResult.getStartRunPace())) {
            condition = condition + "跑步配速>" + challengeTargetResult.getStartRunPace() + "";
        }
        if (!CommonUtil.isNull(challengeTargetResult.getEndRunPace())) {
            if (CommonUtil.isNull(challengeTargetResult.getStartRunPace())) {
                condition = condition + "跑步配速<" + challengeTargetResult.getStartRunPace() + "";
            } else {
                condition = condition + "且配速<" + challengeTargetResult.getEndRunPace() + "";
            }
        }
        if (challengeTargetResult.getStartPerDistance() != null && challengeTargetResult.getStartPerDistance() > 0) {
            condition = condition + "   单次跑步>" + challengeTargetResult.getStartPerDistance() + "KM";
        }
        if (challengeTargetResult.getEndPerDistance() != null && challengeTargetResult.getEndPerDistance() > 0) {
            if (challengeTargetResult.getStartPerDistance() != null && challengeTargetResult.getStartPerDistance() > 0) {
                condition = condition + "且单次跑步<" + challengeTargetResult.getEndPerDistance() + "KM";
            } else {
                condition = condition + "   单次跑步<" + challengeTargetResult.getEndPerDistance() + "KM";
            }
        }
        if (!CommonUtil.isNull(condition)) {
            condition = condition + "才会计入成绩";
            challengeTargetResult.setTargetCondition(condition);
        }
    }

    private static String getCardName (Integer cardId){
        String cardName = "";
        if (cardId == 0) {
            cardName = "运动";
        } else if (cardId == 1) {
            cardName = "计步";
        } else if (cardId == 2) {
            cardName = "跑步";
        } else if (cardId == 50) {
            cardName = "体重";
        }
        return cardName;
    }
}
