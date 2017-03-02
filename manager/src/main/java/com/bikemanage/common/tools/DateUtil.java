package com.bikemanage.common.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName DateUtil
 * @Description 日期工具类
 * @dateTime 2014-12-1 下午6:17:29
 */
public final class DateUtil {

    public static final String PATTERN_DATE_SHORT = "yyyyMMdd";
    public static final String PATTERN_DATE_MS = "yyMMddHHmmssss";
    public static final String PATTERN_DATE_HH = "yyMMddHH";
    public static final String PATTERN_DATE = "yyyy-MM-dd";
    public static final String PATTERN_MONTH = "yyyy-MM";
    public static final String PATTERN_DATE_TIME_MS = "yyyy-MM-dd HH:mm:ssss";
    public static final String PATTERN_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_DATE_MINUTES = "yyyy-MM-dd HH:mm";
    public static final String PATTERN_DATE_TIME_SHORT = "yyyy-MM-dd-HH-mm-ss";

    private DateUtil() {

    }

    /**
     * @param d
     * @return
     * @Title dateToStryyyymmddhhmmssss
     * @Description 格式化日期 yyyy-MM-dd HH:mm:ssss
     * @dateTime 2014-12-2 下午2:47:49
     */
    public static String dateToStryyyymmddhhmmssss(Date d) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN_DATE_TIME_MS);
        return dateFormat.format(d);
    }

    /**
     * @param d
     * @param formatPattern 格式
     * @return
     * @Title formatDateToString
     * @Description 格式化日期
     * @dateTime 2014-12-2 下午2:49:04
     */
    public static String formatDateToString(Date d, String formatPattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(formatPattern);
        return dateFormat.format(d);
    }

    /**
     * @param d
     * @return
     * @Title formatDateToStringShort
     * @Description 格式化日期
     * @dateTime 2014-12-2 下午2:49:27
     */
    public static String formatDateToStringShort(Date d) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN_DATE);
        return dateFormat.format(d);
    }

    /**
     * @param d
     * @return
     * @Title formatDateToStringHH
     * @Description 格式化日期
     * @dateTime 2014-12-2 下午2:49:25
     */
    public static String formatDateToStringHH(Date d) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN_DATE_HH);
        return dateFormat.format(d);
    }

    /**
     * @param d
     * @return
     * @Title formatDateToStringMs
     * @Description 格式化日期
     * @dateTime 2014-12-2 下午2:50:02
     */
    public static String formatDateToStringMs(Date d) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN_DATE_MS);
        return dateFormat.format(d);
    }

    /**
     * @param d
     * @return
     * @Title formatDateToStringDefault
     * @Description 格式化日期
     * @dateTime 2014-12-2 下午2:50:11
     */
    public static String formatDateToStringDefault(Date d) {
        if (d == null) {
            return "";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN_DATE_TIME);
        return dateFormat.format(d);
    }

    /**
     * @param dateString
     * @param formatPattern
     * @return
     * @throws ParseException
     * @Title formatStringToDate
     * @Description 格式化日期
     * @dateTime 2014-12-2 下午2:50:21
     */
    public static Date formatStringToDate(String dateString, String formatPattern) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(formatPattern);
        return dateFormat.parse(dateString);
    }

    /**
     * @param dateString
     * @return
     * @throws ParseException
     * @Title formatStringToDateDefault
     * @Description 格式化日期
     * @dateTime 2014-12-2 下午2:50:35
     */
    public static Date formatStringToDateDefault(String dateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(PATTERN_DATE_TIME);
        return dateFormat.parse(dateString);
    }

    /**
     * @return
     * @Title getCurrentMonth
     * @Description 获取当前月
     * @dateTime 2014-12-2 下午3:02:26
     */
    public static Date getCurrentMonth() {
        Calendar thisMonthStart = Calendar.getInstance();
        thisMonthStart.set(Calendar.DAY_OF_MONTH, 1);
        thisMonthStart.set(Calendar.HOUR_OF_DAY, 0);
        thisMonthStart.set(Calendar.MINUTE, 0);
        thisMonthStart.set(Calendar.SECOND, 0);
        thisMonthStart.set(Calendar.MILLISECOND, 0);
        return thisMonthStart.getTime();
    }

    /**
     * @return
     * @Title getCurrentDate
     * @Description 获取当天日期
     * @dateTime 2014-12-2 下午3:02:01
     */
    public static Date getCurrentDate() {
        Calendar thisMonthStart = Calendar.getInstance();
        return thisMonthStart.getTime();
    }

    /**
     * @param calendarType type of Calendar
     * @return
     * @Title getFistTimeByCalType
     * @Description 获取第一天
     * @dateTime 2014-12-2 下午3:01:37
     */
    public static Date getFistTimeByCalType(int calendarType) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());

        if (calendarType != Calendar.WEEK_OF_YEAR) {
            switch (calendarType) {
                case Calendar.YEAR:
                    cal.set(Calendar.MONTH, 0);
                case Calendar.MONTH:
                    cal.set(Calendar.DAY_OF_MONTH, 1);
                case Calendar.DAY_OF_MONTH:
                    cal.set(Calendar.HOUR_OF_DAY, 0);
                case Calendar.HOUR_OF_DAY:
                    cal.set(Calendar.MINUTE, 0);
                    cal.set(Calendar.SECOND, 0);
                    cal.set(Calendar.MILLISECOND, 0);
                    break;
                default:
                    throw new IllegalArgumentException("The date cut type parameter is wrong.");
            }
        } else {
            cal.set(Calendar.DAY_OF_WEEK, 1);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
        }
        return cal.getTime();
    }

    /**
     * @return
     * @Title getLastMonth
     * @Description 上一个月
     * @dateTime 2014-12-2 下午3:01:08
     */
    public static Date getLastMonth() {
        Calendar lastMonthStart = Calendar.getInstance();

        lastMonthStart.set(Calendar.DAY_OF_MONTH, 1);
        lastMonthStart.set(Calendar.HOUR_OF_DAY, 0);
        lastMonthStart.set(Calendar.MINUTE, 0);
        lastMonthStart.set(Calendar.SECOND, 0);
        lastMonthStart.set(Calendar.MILLISECOND, 0);
        lastMonthStart.add(Calendar.MONTH, -1);

        return lastMonthStart.getTime();
    }

    /**
     * @return
     * @Title getNextMonth
     * @Description 下一个月
     * @dateTime 2014-12-2 下午3:00:57
     */
    public static Date getNextMonth() {
        Calendar nextMonthStart = Calendar.getInstance();

        nextMonthStart.set(Calendar.DAY_OF_MONTH, 1);
        nextMonthStart.set(Calendar.HOUR_OF_DAY, 0);
        nextMonthStart.set(Calendar.MINUTE, 0);
        nextMonthStart.set(Calendar.SECOND, 0);
        nextMonthStart.set(Calendar.MILLISECOND, 0);
        nextMonthStart.add(Calendar.MONTH, 1);

        return nextMonthStart.getTime();
    }

    /**
     * 根据给定的日期查找下一个月的开始时间
     *
     * @param d
     * @return
     */
    public static Date getNextMonth(Date d) {
        Calendar cal = Calendar.getInstance();

        cal.setTime(d);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + 1);

        return cal.getTime();
    }

    /**
     * 根据给定日期找出本月开始时间
     *
     * @param d
     * @return
     */
    public static Date getCurrentMonth(Date d) {
        Calendar cal = Calendar.getInstance();

        cal.setTime(d);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTime();
    }

    /**
     * @return
     * @Title getTomorrow
     * @Description 获取明天时间
     * @dateTime 2014-12-2 下午2:59:34
     */
    public static Date getTomorrow() {
        return getNextDay(new Date());
    }

    /**
     * @return
     * @Title getAfterTomorrow
     * @Description 获取后天时间
     * @dateTime 2014-12-2 下午2:59:52
     */
    public static Date getAfterTomorrow() {
        Calendar cal = Calendar.getInstance();

        cal.setTime(new Date());
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 2);

        return cal.getTime();
    }

    /**
     * @param d
     * @return
     * @Title getNextDay
     * @Description 获取下一天
     * @dateTime 2014-12-2 下午3:00:28
     */
    public static Date getNextDay(Date d) {
        Calendar cal = Calendar.getInstance();

        cal.setTime(d);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 1);

        return cal.getTime();
    }

    /**
     * 判断统计的是否是当年的数据
     */
    public static boolean isBeforeYear(Date startdate) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int curryear = cal.get(Calendar.YEAR);
        cal.setTime(startdate);
        int flagyear = cal.get(Calendar.YEAR);
        return flagyear < curryear;
    }

    /**
     * 判断统计的是否是当年的数据
     */
    public static boolean isBeforeDay(Date startdate) {

        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int currDay = cal.get(Calendar.DAY_OF_YEAR);
        int currYear = cal.get(Calendar.YEAR);
        cal.setTime(startdate);
        int flagDay = cal.get(Calendar.DAY_OF_YEAR);
        int flagYear = cal.get(Calendar.YEAR);

        if (flagYear < currYear) {
            return true;
        }

        if (flagYear > currYear) {
            return false;
        }

        return flagDay <= currDay;
    }

    /**
     * 判断统计的是否是当年的数据
     */
    public static boolean isBeforeMonth(Date startdate) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int currmonth = cal.get(Calendar.MONTH);
        int currYear = cal.get(Calendar.YEAR);
        cal.setTime(startdate);
        int flagmonth = cal.get(Calendar.MONTH);
        int flagYear = cal.get(Calendar.YEAR);

        if (flagYear < currYear) {
            return true;
        } else if (flagYear > currYear) {
            return false;
        } else {
            return flagmonth <= currmonth;
        }
    }

    /**
     * 判断月份是否在当前月后
     */
    public static boolean isAfterMonth(Date startdate) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int currmonth = cal.get(Calendar.MONTH);
        int currYear = cal.get(Calendar.YEAR);
        cal.setTime(startdate);
        int flagmonth = cal.get(Calendar.MONTH);
        int flagYear = cal.get(Calendar.YEAR);

        if (flagYear > currYear) {
            return true;
        }

        if (flagYear < currYear) {
            return false;
        }
        return flagmonth >= currmonth;
    }

    /**
     * 判断日期是否在当前日后
     */
    public static boolean isAfterDay(Date startdate) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int currday = cal.get(Calendar.DAY_OF_YEAR);
        int currYear = cal.get(Calendar.YEAR);
        cal.setTime(startdate);
        int flagday = cal.get(Calendar.DAY_OF_YEAR);
        int flagYear = cal.get(Calendar.YEAR);

        if (flagYear > currYear) {
            return true;
        }

        if (flagYear < currYear) {
            return false;
        }
        return flagday >= currday;
    }

    /**
     * 判断是否是当月的数据
     */
    public static boolean isCurrentMonth(Date startdate) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int currmonth = cal.get(Calendar.MONTH);
        int currYear = cal.get(Calendar.YEAR);
        cal.setTime(startdate);
        int flagmonth = cal.get(Calendar.MONTH);
        int flagYear = cal.get(Calendar.YEAR);

        if (flagYear == currYear) {
            if (currmonth == flagmonth) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否是当月的数据
     */
    public static boolean isCurrentWeek(Date startdate) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int currweek = cal.get(Calendar.WEEK_OF_YEAR);
        int currYear = cal.get(Calendar.YEAR);
        cal.setTime(startdate);
        int flagweek = cal.get(Calendar.WEEK_OF_YEAR);
        int flagYear = cal.get(Calendar.YEAR);

        if (flagYear == currYear) {
            if (currweek == flagweek) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否是当日
     *
     * @param startdate
     */
    public static boolean isCurrentDay(Date startdate) {
        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int currDay = cal.get(Calendar.DAY_OF_YEAR);
        int currYear = cal.get(Calendar.YEAR);
        cal.setTime(startdate);
        int flagDay = cal.get(Calendar.DAY_OF_YEAR);
        int flagYear = cal.get(Calendar.YEAR);

        if (flagYear == currYear) {
            if (currDay == flagDay) {
                return true;
            }
        }
        return false;
    }

    /**
     * 得到当月的第一天
     */
    public static Date getStartDateMonth(Date d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 得到当月的最后一天
     */
    public static Date lastDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.add(Calendar.MONTH, 1);
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    /**
     * 得到上月的最后一天
     */
    public static Date getEndDateOfLastMonth(Date d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.set(Calendar.DAY_OF_MONTH, 0);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 得到下月的第一天
     */
    public static Date getStartDateOfNextMonth(Date d) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 得到昨天零点的date
     */
    public static Date getZeroOfYesterday() {
        Calendar yesterdayCal = Calendar.getInstance();
        yesterdayCal.add(Calendar.DAY_OF_MONTH, -1);
        yesterdayCal.set(Calendar.HOUR_OF_DAY, 0);
        yesterdayCal.set(Calendar.MINUTE, 0);
        yesterdayCal.set(Calendar.SECOND, 0);
        yesterdayCal.set(Calendar.MILLISECOND, 0);
        return yesterdayCal.getTime();
    }

    /**
     * 得到今天零点的date
     */
    public static Date getZeroOfToday() {
        Calendar todayCal = Calendar.getInstance();
        todayCal.set(Calendar.HOUR_OF_DAY, 0);
        todayCal.set(Calendar.MINUTE, 0);
        todayCal.set(Calendar.SECOND, 0);
        todayCal.set(Calendar.MILLISECOND, 0);
        return todayCal.getTime();
    }

    /**
     * 得到时间的零点date
     */
    public static Date getZeroOfToday(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 得到上周一零点的date
     */
    public static Date getZeroOfLastMonday() {
        Calendar lastMondayCal = Calendar.getInstance();

        lastMondayCal.add(Calendar.WEEK_OF_MONTH, -1);
        lastMondayCal.set(Calendar.DAY_OF_WEEK, 2);
        lastMondayCal.set(Calendar.HOUR_OF_DAY, 0);
        lastMondayCal.set(Calendar.MINUTE, 0);
        lastMondayCal.set(Calendar.SECOND, 0);
        lastMondayCal.set(Calendar.MILLISECOND, 0);

        return lastMondayCal.getTime();
    }

    /**
     * 得到上周日零点的date
     */
    public static Date getZeroOfLastSunday() {
        Calendar lastSundayCal = Calendar.getInstance();

        lastSundayCal.set(Calendar.DAY_OF_WEEK, 1);
        lastSundayCal.set(Calendar.HOUR_OF_DAY, 0);
        lastSundayCal.set(Calendar.MINUTE, 0);
        lastSundayCal.set(Calendar.SECOND, 0);
        lastSundayCal.set(Calendar.MILLISECOND, 0);

        return lastSundayCal.getTime();
    }

    /**
     * 得到时间零点的date
     */
    public static Date getZeroDate(Date date) throws ParseException {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTime();
    }

    /**
     * 增加或减少时间的月数
     */
    public static Date addMonth(Date date, int m) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date.getTime());
        cal.add(Calendar.MONTH, m);

        return cal.getTime();
    }

    /**
     * 增加或减少时间的天数
     */
    public static Date addDay(Date date, int d) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(date.getTime());
        cal.add(Calendar.DATE, d);

        return cal.getTime();
    }

    public static Date addHour(Date date, int v) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, v);

        return cal.getTime();
    }

    public static Date addMinute(Date date, int v) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, v);

        return cal.getTime();
    }

    public static Date addSecond(Date date, int v) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.SECOND, v);

        return cal.getTime();
    }

    // is the fisrt day of the month
    public static boolean isFirstDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        return cal.get(Calendar.DAY_OF_MONTH) == 1;
    }

    /**
     * 求两个月时间差
     */
    public static long getDaysBetweenMonth(Date date, Date now) {
        long l = now.getTime() - date.getTime();

        return l / (24 * 60 * 60 * 1000);
    }

    /**
     * @param num
     * @return
     * @Title Days
     * @Description 获取天数对应的秒数
     * @dateTime 2014-12-2 下午2:58:10
     */
    public static int days(int num) {
        return num * 24 * 60 * 60;
    }

    /**
     * @param num
     * @return
     * @Title Hours
     * @Description 获取小时数对应的秒数
     * @dateTime 2014-12-2 下午2:58:44
     */
    public static int hours(int num) {
        return num * 60 * 60;
    }

    /**
     * @param num
     * @return
     * @Title Minutes
     * @Description 获取分钟数对应的秒数
     * @dateTime 2014-12-2 下午2:58:56
     */
    public static int minutes(int num) {
        return num * 60;
    }

    /**
     * @param num
     * @return
     * @Title Seconds
     * @Description 获取秒数
     * @dateTime 2014-12-2 下午2:59:06
     */
    public static int seconds(int num) {
        return num;
    }

    /**
     * 获取当前日期是星期几<br>
     *
     * @return 当前日期是星期几
     */
    public static int getDayOfWeek() {
        Calendar now = Calendar.getInstance();
        //一周第一天是否为星期天
        boolean isFirstSunday = (now.getFirstDayOfWeek() == Calendar.SUNDAY);
        //获取周几
        int weekDay = now.get(Calendar.DAY_OF_WEEK);
        //若一周第一天为星期天，则-1
        if (isFirstSunday) {
            weekDay = weekDay - 1;
            if(weekDay == 0) {
                weekDay = 7;
            }
        }
        return weekDay;
    }

    public static String getDateStringOfWeek(String date, int dayOfWeek) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(PATTERN_DATE);
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(date));
        cal.set(Calendar.DAY_OF_WEEK, dayOfWeek); //获取本周日的日期
        return sdf.format(cal.getTime());
    }

    /**
     * 获取当前日期的下一个整点时间，如：09: 00
     *
     * @return
     */
    public static String getCurrentHours(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY) + 1);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        return dateFormat.format(cal.getTime());
    }

    public static void main(String[] args) {
        System.out.println("----------" + DateUtil.getCurrentDate());
        try {
            System.out.println("----------" + DateUtil.formatStringToDateDefault(DateUtil.formatDateToStringDefault(DateUtil.getCurrentDate())));
            System.out.println(getDateStringOfWeek("2016-09-12", Calendar.SUNDAY));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
