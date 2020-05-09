package com.atuan.datepickerlibrary;

import android.annotation.SuppressLint;
import android.text.TextUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by atuan on 2018/9/1.
 */

public class CalendarUtil {

    private static final long ONE_DAY = 1000 * 3600 * 24;

    public static String getTwoDay(String sj1, String sj2) {
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
        long day = 0;
        try {
            java.util.Date date = myFormatter.parse(sj1);
            java.util.Date mydate = myFormatter.parse(sj2);
            day = (date.getTime() - mydate.getTime()) / (24 * 60 * 60 * 1000);
        } catch (Exception e) {
            return "";
        }
        return day + "";
    }


    /**
     * 判断当前日期是星期几
     *
     * @param pTime 设置的需要判断的时间  //格式如2012-09-08
     * @return dayForWeek 判断结果
     * @Exception 发生异常
     */
    public static int getWeekNoFormat(String pTime) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(format.parse(pTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return c.get(Calendar.DAY_OF_WEEK);
    }

    public static Calendar toDate(String pTime) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(format.parse(pTime));
            return c;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 参数格式：2012-12-1
     * return 12月1日
     *
     * @param date
     */
    public static String FormatDateMD(String date) {
        if (TextUtils.isEmpty(date)) {
            new Throwable();
        }
        String month = date.split("-")[1];
        String day = date.split("-")[2];
        return month + "月" + day + "日";
    }

    /**
     * 参数格式：2012-12-1
     * return 2012年12月1日
     *
     * @param date
     */
    public static String FormatDateYMD(String date) {
        if (TextUtils.isEmpty(date)) {
            new Throwable();
        }
        String year = date.split("-")[0];
        String month = date.split("-")[1];
        String day = date.split("-")[2];
        return year + "年" + month + "月" + day + "日";
    }

    /**
     * 判断当前日期是星期几
     *
     * @param pTime 设置的需要判断的时间  //格式如2012-09-08
     * @return dayForWeek 判断结果
     * @Exception 发生异常
     */
    @SuppressLint("SimpleDateFormat")
    public static String getWeekByFormat(String pTime) {
        String week = "";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(format.parse(pTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            week += "日";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 2) {
            week += "一";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 3) {
            week += "二";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 4) {
            week += "三";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 5) {
            week += "四";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 6) {
            week += "五";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 7) {
            week += "六";
        }
        return week;
    }
    /**
     * 运算 calendar1 - calendar2
     * test Pass
     *
     * @param calendar1 calendar1
     * @param calendar2 calendar2
     * @return calendar1 - calendar2
     */
    static int differ(com.atuan.datepickerlibrary.Calendar  calendar1, com.atuan.datepickerlibrary.Calendar  calendar2) {
        if (calendar1 == null) {
            return Integer.MIN_VALUE;
        }
        if (calendar2 == null) {
            return Integer.MAX_VALUE;
        }
        java.util.Calendar date = java.util.Calendar.getInstance();

        date.set(calendar1.getYear(), calendar1.getMonth() - 1, calendar1.getDay(), 12, 0, 0);//

        long startTimeMills = date.getTimeInMillis();//获得起始时间戳

        date.set(calendar2.getYear(), calendar2.getMonth() - 1, calendar2.getDay(), 12, 0, 0);//

        long endTimeMills = date.getTimeInMillis();//获得结束时间戳

        return (int) ((startTimeMills - endTimeMills) / ONE_DAY);
    }

    /**
     * 判断一个日期是否是周末，即周六日
     *
     * @param calendar calendar
     * @return 判断一个日期是否是周末，即周六日
     */
    static boolean isWeekend(com.atuan.datepickerlibrary.Calendar calendar) {
        int week = getWeekFormCalendar(calendar);
        return week == 0 || week == 6;
    }

    /**
     * 获取某个日期是星期几
     * 测试通过
     *
     * @param calendar 某个日期
     * @return 返回某个日期是星期几
     */
    static int getWeekFormCalendar(com.atuan.datepickerlibrary.Calendar calendar) {
        java.util.Calendar date = java.util.Calendar.getInstance();
        date.set(calendar.getYear(), calendar.getMonth() - 1, calendar.getDay());
        return date.get(java.util.Calendar.DAY_OF_WEEK) - 1;
    }

    /**
     * 是否是闰年
     *
     * @param year year
     * @return 是否是闰年
     */
    static boolean isLeapYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }

}
