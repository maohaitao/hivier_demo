package com.bike.bananacard.common.tools;

import com.sf.common.util.DateCoverd;
import com.sf.common.util.DateUtil;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * created with bananaCard.
 * user: yanghui@700bike.com
 * date: 16/1/18
 * time: 下午12:03
 * description: 日期工具类
 */
public class DateUtils {
    private final static String DEFAULT_FORMART = DateCoverd.FORMART_YYYY_MM_DD;

    public static Date getDate(String date) {
        if (StringUtils.isEmpty(date)) {
            return null;
        }
        return DateCoverd.toDate(date, DEFAULT_FORMART);
    }

    public static String getDate(Date date) {
        if (date == null) {
            return null;
        }
        return DateCoverd.toString(date, DEFAULT_FORMART);
    }

    public static Date getDateFull(String date) {
        if (StringUtils.isEmpty(date)) {
            return null;
        }
        if (date.length() > 10) {
            return DateCoverd.toDate(date, DateCoverd.FORMART_YYYY_MM_DD_HH_MM_SS);
        }
        return DateCoverd.toDate(date, DEFAULT_FORMART);
    }

    public static String getDateFull(Date date) {
        if (date == null) {
            return null;
        }
        return DateCoverd.toString(date, DateCoverd.FORMART_YYYY_MM_DD_HH_MM_SS);
    }


    public static Date getDate() {
        return getDate(getDate(new Date()));
    }

    public static long getTime(String date) {
        if (date == null) {
            return 0;
        }
        return getDate(date).getTime();
    }

    public static void main(String[] args) {
        Date startTime = DateUtils.getDate("2016-08-05 00:00:00");
        Integer i = DateUtils.getDate().compareTo(startTime);
        System.out.println(i);
        System.out.println(getHoursOfDay(new Date()));
    }

    public static long getLeftTimeOfWeek (){
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
       // int [] dOfw = {7,1,2,3,4,5,6};
        int w = cal.get(Calendar.DAY_OF_WEEK)-1 ;
        if (w < 0)
            w = 0;//星期天
        // add方法中的第二个参数n中，正数表示该日期后n天，负数表示该日期的前n天
        cal.add(Calendar.DATE, (6-w));
        Date date2 = DateUtil.getNextDay(cal.getTime());
        return (date2.getTime()-date.getTime())/1000l;
    }

    public static String getFirstDayOfWeek(){
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
      //  int [] dOfw = {7,1,2,3,4,5,6};
        int w = cal.get(Calendar.DAY_OF_WEEK)-1;
        if (w < 0)
            w = 0;//星期天
        // add方法中的第二个参数n中，正数表示该日期后n天，负数表示该日期的前n天
        cal.add(Calendar.DATE, -w);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format( cal.getTime());
    }

    public static int getHoursOfDay(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.HOUR_OF_DAY);
    }

    public static int getMuniteOfDay(Date date){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MINUTE);
    }
}
