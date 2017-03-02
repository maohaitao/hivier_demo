package com.hi.rest;

import com.bike.activity.model.UserAddressInfo;
import com.bike.apicommon.DES;
import com.bike.sns.model.BasmsAccountTask;
import com.bike.sns.service.BasmsAccountTaskService;
import com.google.gson.JsonObject;
import com.hi.constants.PathConstant;
import com.sf.common.util.JsonUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/activity")
public class ActivityController {
    //    @Resource(name = "challengeBusinessServiceImpl")
    //    ChallengeBusinessService challengeBusinessService;

    @Autowired
    private BasmsAccountTaskService logServerInfoService;

    private static final Logger logger = Logger.getLogger(ActivityController.class);

    @RequestMapping(value = "/index/index", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView index(HttpServletRequest request) {
        System.out.println(logServerInfoService);
        BasmsAccountTask accountTask = new BasmsAccountTask();
        accountTask.settId(11);
        System.out.println(logServerInfoService.addAccountTask(accountTask));
        ModelAndView mv = new ModelAndView("/index/index");
        getMyModelAndView(mv);
        System.out.println("index====");
        return  mv;
    }
        @RequestMapping(value = "/act/share", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView getActShare(HttpServletRequest request, @RequestParam("param") String param) {
        logger.info("/act/share,param=" + param);
        try {
            param = DES.decrypt(param);
        } catch (Exception e) {
            logger.info("Exception=" + e.getMessage());
        }
        JsonObject jsonObject = JsonUtil.parse(param);
        int challengeId = Integer.parseInt(jsonObject.get("challengeId").getAsString());
//		String accountId=jsonObject.get("accountId").getAsString() ;

        ModelAndView mv = new ModelAndView("/act/share");

        //获取挑战详情
//        ChallengeUserSign challengeUserSign = challengeBusinessService.getChallengeBasicBus(challengeId);
//        challengeUserSign.setChallengeId(challengeId);

//        challengeUserSign.setExplain(challengeUserSign.getExplain().replaceAll("\\n","<br>"));
//        mv.addObject("activity", challengeUserSign);

        //格式化开始结束时间
//        mv.addObject("formatStartTime", DateUtil.formatDateString(challengeUserSign.getStartTime()));
//        mv.addObject("formatEndTime", DateUtil.formatDateString(challengeUserSign.getEndTime()));

        //计算倒计时
//        Date date = challengeUserSign.getStartTime();
//        Date now=new Date();
//        boolean isStart = now.after(date);
//        if(isStart){
//            Date endDate = challengeUserSign.getEndTime();
//            boolean isFinish = now.after(endDate);
//            if(isFinish){
//                mv.addObject("status", 2);
//            }else{
//                long timeDifference = DateUtil.getTimeDifference(date,endDate);
//                int day = (int) (timeDifference / (3600 * 24));
//                int hour = (int) ((timeDifference - day * 3600 * 24) / 3600);
//                int minute = (int) ((timeDifference - day * 3600 * 24 - hour * 3600) / 60);
//                mv.addObject("timeDifference", day + "天" + hour + "时" + minute + "分");
//                mv.addObject("status", 1);
//            }
//
//
//        }else {
//            long timeDifference = DateUtil.getTimeDifference(date, new Date());
//            int day = (int) (timeDifference / (3600 * 24));
//            int hour = (int) ((timeDifference - day * 3600 * 24) / 3600);
//            int minute = (int) ((timeDifference - day * 3600 * 24 - hour * 3600) / 60);
//            mv.addObject("timeDifference", day + "天" + hour + "时" + minute + "分");
//            mv.addObject("status", 0);
//        }


        //获取挑战目标
//        List<ChallengeTargetResult> listChallengeTargetResult = challengeBusinessService.listChallengeTargetsBus(challengeId);
//        mv.addObject("listChallengeTargetResult", listChallengeTargetResult);
//
//        //根据挑战id获取对应的奖励列表
//        List<ChallengeRewardInfo> listChallengeRewardInfo = challengeBusinessService.listRewardInfoByChallengeIdBus(challengeId);
//        mv.addObject("listChallengeRewardInfo", listChallengeRewardInfo);
//
//        //获取挑战相关最近n条动态
//        List<CardImageDynamic> listCardImageDynamic = challengeBusinessService.queryChallengeDynamicBus(challengeId, 6);
//        mv.addObject("listCardImageDynamic", listCardImageDynamic);
//
//        //动态截至时间
//        if (listCardImageDynamic != null && listCardImageDynamic.size() > 0) {
//            mv.addObject("dynamicEndTime", DateUtil.formatDateString(listCardImageDynamic.get(0).getPublish_time()));
//        }


        return getMyModelAndView(mv);
    }

    @RequestMapping(value = "/act/result", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView getActResult(HttpServletRequest request, @RequestParam("param") String param) {

        logger.info("/act/result,param=" + param);
        try {
            param = DES.decrypt(param);
        } catch (Exception e) {
            logger.info("Exception=" + e.getMessage());
        }
        JsonObject jsonObject = JsonUtil.parse(param);
        int challengeId = Integer.parseInt(jsonObject.get("challengeId").getAsString());
        String accountId = jsonObject.get("accountId").getAsString();

        ModelAndView mv = new ModelAndView("/act/result");

//        //获取挑战详情
//        ChallengeUserSign challengeUserSign = challengeBusinessService.getChallengeUserSignBus(challengeId, accountId);
//        if (challengeUserSign == null) {
//            //未报名
//            ChallengeUserSign challengeUserSign2 = challengeBusinessService.getChallengeBasicBus(challengeId);
//            challengeUserSign2.setExplain(challengeUserSign2.getExplain().replaceAll("\\n","<br>"));
//            mv.addObject("activity", challengeUserSign2);
//        } else {
//            challengeUserSign.setExplain(challengeUserSign.getExplain().replaceAll("\\n","<br>"));
//            mv.addObject("activity", challengeUserSign);
//        }


//        //挑战是否完成
//        boolean isFinish = false;
//        if (challengeUserSign != null && challengeUserSign.getStatus() != null && challengeUserSign.getStatus() == 3) {
//            isFinish = true;
//        }
//
//        //获取挑战目标
//        List<ChallengeTargetResult> listChallengeTargetResult = challengeBusinessService.listChallengeTargetsBus(challengeId);
//        for (ChallengeTargetResult challengeTargetResult : listChallengeTargetResult) {
//            challengeTargetResult.setTargetTitle(challengeTargetResult.getTargetTitle().replaceAll("#", ""));
//        }
//        mv.addObject("listChallengeTargetResult", listChallengeTargetResult);
//
//
//        if (challengeUserSign != null) {
//            Date now = new Date();
//            boolean isEnd = now.after(challengeUserSign.getEndTime());
//            if (isEnd) {
//                mv.addObject("isEnd", 1);
//                //挑战结束时间
//                if (challengeUserSign.getEndTime() != null) {
//                    try {
//                        mv.addObject("formatEndTime", DateUtil.formatDateFullString(challengeUserSign.getEndTime()));
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//
//                }
//            } else {
//                mv.addObject("isEnd", 0);
//                //挑战完成时间
//                if (challengeUserSign.getSuccessTime() != null) {
//                    try {
//                        mv.addObject("formatEndTime", DateUtil.formatDateFullString(challengeUserSign.getSuccessTime()));
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//
//                }
//            }
//        }
//
//
//        //获取实物奖励者
//        List<TAccount> listTAccount = challengeBusinessService.listChallengeRewardEntityUsersBus(challengeId, 6);
//        mv.addObject("listTAccount", listTAccount);
//
//        //挑战奖品
//        boolean entityObtain = false;//有没有实物中奖
//        List<Integer> listObtain = new ArrayList<Integer>();//是否获奖
//        List<String> listRewardTime = new ArrayList<String>();//开奖时间
//        List<ChallengeRewardInfo> listChallengeRewardInfo = challengeBusinessService.listRewardInfoByChallengeIdBus(challengeId);
//        ChallengeRewardEntity ChallengeRewardEntity = challengeBusinessService.getChallengeRewardEntityBus(accountId, challengeId);
//        UserAddressInfo userAddressInfo = challengeBusinessService.getUserAddressInfoBus(accountId);
//
//        for (ChallengeRewardInfo challengeRewardInfo : listChallengeRewardInfo) {
//
//            if (challengeRewardInfo.getRewardType() != null && challengeRewardInfo.getRewardType() == 1) {
//                //皮肤
//                //默认已经开奖,中奖
//                listObtain.add(1);
//
//                listRewardTime.add("");
//            } else {
//                Date rewardTime = challengeRewardInfo.getRewardTime();
//                listRewardTime.add(DateUtil.formatDateFullString(rewardTime));
//                //实物
//                boolean kaijiang = new Date().after(rewardTime);
//                if (kaijiang) {
//
//                    if (ChallengeRewardEntity == null) {
//                        //已经开奖,未中奖
//                        listObtain.add(-1);
//                    } else {
//                        //已经开奖,中奖
//                        entityObtain = true;
//                        listObtain.add(1);
//                    }
//                } else {
//                    //没开奖
//                    listObtain.add(0);
//                }
//            }
//        }
//        mv.addObject("ListRewardTime", listRewardTime);
//        mv.addObject("listObtain", listObtain);
//        mv.addObject("listChallengeRewardInfo", listChallengeRewardInfo);
//
//        int kaijiangStatus = 0;     //是否实物开奖
//        for (ChallengeRewardInfo challengeRewardInfo : listChallengeRewardInfo) {
//
//            if (challengeRewardInfo.getRewardType() != null && challengeRewardInfo.getRewardType() == 2) {
//                Date rewardTime = challengeRewardInfo.getRewardTime();
//                //实物,已经开奖
//                boolean kaijiang = new Date().after(rewardTime);
//                if (kaijiang) {
//                    kaijiangStatus = 1;
//                    break;
//                }
//
//            }
//        }
//        //是否实物开奖
//        mv.addObject("kaijiangStatus", kaijiangStatus);
//
//        //status=1;//未报名,未达标
//        //status=2;//已达标,未到实物开奖时间
//        //status=3;//已开奖,未中奖
//        //status=4;//已中奖,未填写资料
//        //status=5;//已经填写资料
//        int status = 0;
//        if (isFinish == false) {
//            status = 1;
//        } else {
//            boolean isObtain = false;//是否达到实物开奖时间,只要有一个到达,都算到达
//            for (int i = 0; i < listObtain.size(); i++) {
//                int kaijiang = listObtain.get(i);
//                //实物,并且开奖
//                if (kaijiang == 1 && listChallengeRewardInfo.get(i).getRewardType() == 2) {
//                    isObtain = true;
//                }
//            }
//            if (isObtain == false) {
//                status = 2;
//            } else {
//                if (entityObtain == false) {
//                    status = 3;
//                } else {
//                    if (userAddressInfo == null) {
//                        status = 4;
//                    } else {
//                        status = 5;
//                    }
//                }
//            }
//        }
//        try {
//            status = jsonObject.get("status").getAsInt();
//        } catch (Exception e) {
//
//        }
//
//        if (userAddressInfo != null) {
//            mv.addObject("userAddressInfo", userAddressInfo);
//        }
//        mv.addObject("status", status);

        return getMyModelAndView(mv);
    }

    @RequestMapping(value = "/act/result_share", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView getActResultShare(HttpServletRequest request, @RequestParam("param") String param) {
        logger.info("/act/result_share,param=" + param);
        try {
            param = DES.decrypt(param);
        } catch (Exception e) {
            logger.info("Exception=" + e.getMessage());
        }
        JsonObject jsonObject = JsonUtil.parse(param);
        int challengeId = Integer.parseInt(jsonObject.get("challengeId").getAsString());
        String accountId = jsonObject.get("accountId").getAsString();

        ModelAndView mv = new ModelAndView("/act/result_share");

//        //获取挑战详情
//        ChallengeUserSign challengeUserSign = challengeBusinessService.getChallengeUserSignBus(challengeId, accountId);
//        challengeUserSign.setExplain(challengeUserSign.getExplain().replaceAll("\\n","<br>"));
//        mv.addObject("activity", challengeUserSign);
//
//
//        //挑战是否完成
//        boolean isFinish = false;
//        if (challengeUserSign.getStatus() != null && challengeUserSign.getStatus() == 3) {
//            isFinish = true;
//        }
//        //获取挑战目标
//        List<ChallengeTargetResult> listChallengeTargetResult = challengeBusinessService.listChallengeTargetsBus(challengeId);
//        for (ChallengeTargetResult challengeTargetResult : listChallengeTargetResult) {
//            challengeTargetResult.setTargetTitle(challengeTargetResult.getTargetTitle().replaceAll("#", ""));
//        }
//        mv.addObject("listChallengeTargetResult", listChallengeTargetResult);
//
//        //挑战结束时间
//        String endTime = null;
//        try {
//            endTime = DateUtil.formatDateFullString(challengeUserSign.getEndTime());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        mv.addObject("formatEndTime", endTime);

        return getMyModelAndView(mv);
    }

    @RequestMapping(value = "/act/address", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView getActAddress(HttpServletRequest request, @RequestParam("param") String param) {
        logger.info("/act/address,param=" + param);
        try {
            param = DES.decrypt(param);
        } catch (Exception e) {
            logger.info("Exception=" + e.getMessage());
        }
        JsonObject jsonObject = JsonUtil.parse(param);
        int challengeId = Integer.parseInt(jsonObject.get("challengeId").getAsString());
        String accountId = jsonObject.get("accountId").getAsString();

        ModelAndView mv = new ModelAndView("/act/address");

//        UserAddressInfo userAddressInfo = challengeBusinessService.getUserAddressInfoBus(accountId);
//        if (userAddressInfo != null) {
//            mv.addObject("userAddressInfo", userAddressInfo);
//        }
//        try {
//            accountId = DES.encrypt(accountId);
//        } catch (Exception e) {
//
//        }
        mv.addObject("accountId", accountId);

        return getMyModelAndView(mv);
    }

    @RequestMapping(value = "/act/saveActAddress", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String saveActAddress(HttpServletRequest request, @RequestParam("param") String param) {
        logger.info("/act/saveActAddress,param=" + param);
        JsonObject jsonObject = JsonUtil.parse(param);
        String accountId = jsonObject.get("accountId").getAsString();
        String relName = jsonObject.get("relName").getAsString();
        String phone_num = jsonObject.get("phone_num").getAsString();
        String citypicker = jsonObject.get("citypicker").getAsString();
        String detail_address = jsonObject.get("detail_address").getAsString();

        try {
            accountId = DES.decrypt(accountId);
        } catch (Exception e) {
            logger.info("Exception=" + e.getMessage());
        }
        UserAddressInfo userAddressInfo = new UserAddressInfo();
        userAddressInfo.setAccountId(accountId);
        userAddressInfo.setRelName(relName);
        userAddressInfo.setPhoneNum(phone_num);
        if (citypicker != null) {
            String[] text = citypicker.split("/");
            if (text[0] != null) {
                userAddressInfo.setProvince(text[0]);
            }
            if (text[1] != null) {
                userAddressInfo.setCity(text[1]);
            }
            if (text[2] != null) {
                userAddressInfo.setCounty(text[2]);
            }
        }

        userAddressInfo.setDetailAddress(detail_address);
        userAddressInfo.setSex(1);

        UserAddressInfo userAddressInfo2 = null;//challengeBusinessService.saveUserAddressInfoBus(userAddressInfo);

        if (userAddressInfo2 != null) {
            logger.info("/act/saveActAddress,saveResult=1");
            return "1";
        } else {
            logger.info("/act/saveActAddress,saveResult=0");
            return "0";
        }
    }

    //为静态资源文件添加前缀,读取PathConstant.PROJECTPATH为项目名称
    private ModelAndView getMyModelAndView(ModelAndView mv) {
        mv.addObject("staticResourcePath", PathConstant.PROJECTPATH + "/item/static");
        mv.addObject("projectPath", PathConstant.PROJECTPATH);
        return mv;
    }

}
