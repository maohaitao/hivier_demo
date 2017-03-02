package com.hi.tools;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by wushipan on 17/1/17.
 */
public class DateUtil {
//    public static final String DATE_FORMAT_FULL = "yyyy-MM-dd HH:mm:ss";
//    public static final String DATE_FORMAT_PART = "yyyy-MM-dd";
    public static final String DATE_FORMAT_MONTH = "MM月dd日";
    public static final String DATE_FORMAT_FULL = "yyyy年MM月dd日";

    public static String formatDateString(Date date) {
        return new SimpleDateFormat(DATE_FORMAT_MONTH).format(date);
    }
    public static String formatDateFullString(Date date) {
        return new SimpleDateFormat(DATE_FORMAT_FULL).format(date);
    }

    //计算两个时间相差多少秒
    public static int getTimeDifference(Date date1, Date date2) {
        long timeDelta = (date1.getTime() - date2.getTime()) / 1000;// 单位是秒
        int secondsDelta = timeDelta > 0 ? (int) timeDelta : (int) Math.abs(timeDelta);
        return secondsDelta;
    }


    /**
     * date2比date1多的天数
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDays(Date date1,Date date2)
    {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1= cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if(year1 != year2)   //同一年
        {
            int timeDistance = 0 ;
            for(int i = year1 ; i < year2 ; i ++)
            {
                if(i%4==0 && i%100!=0 || i%400==0)    //闰年
                {
                    timeDistance += 366;
                }
                else    //不是闰年
                {
                    timeDistance += 365;
                }
            }

            return timeDistance + (day2-day1) ;
        }
        else    //不同年
        {
            return day2-day1;
        }
    }
}
