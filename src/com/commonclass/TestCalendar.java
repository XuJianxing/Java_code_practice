package com.commonclass;

import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestCalendar {
    public static void main(String[] args){
        GregorianCalendar calendar = new GregorianCalendar(2019, Calendar.JUNE, 3, 3, 4, 5 );
        int year2 = calendar.get(Calendar.YEAR);  // 这是类里的静态常数，不变的
        System.out.println("YEAR: " + Calendar.YEAR + "_" + year2);
        int month = calendar.get(Calendar.MONTH);
        System.out.println("MONTH: " + Calendar.MONTH + "_" + month);    // 一月是0，二月是1，以此类推，12月是11
        int date = calendar.get(Calendar.DATE);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int day2 = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println("DATE: " + Calendar.DATE + "_" + date);
        System.out.println("DAY_OF_MONTH: " + Calendar.DAY_OF_MONTH + "_" + day);
        System.out.println("DAY_OF_WEEK: " + Calendar.DAY_OF_WEEK + "_" + day2);    // 星期从周日开始1，周一是2，周六是7
        // 设置日期
        GregorianCalendar calendar2 = new GregorianCalendar();
        calendar2.set(Calendar.YEAR, 2020);
        calendar2.set(Calendar.MONTH, Calendar.FEBRUARY); // 月份数：0-11
        calendar2.set(Calendar.DATE, 3);
        calendar2.set(Calendar.HOUR_OF_DAY, 10);
        calendar2.set(Calendar.MINUTE, 20);
        calendar2.set(Calendar.SECOND, 23);
        printCalendar(calendar2);
        // 日期计算
        GregorianCalendar calendar3 = new GregorianCalendar(2009, 10, 9, 22, 10, 50);
        calendar3.add(Calendar.MONTH, -7); // 月份减7
        calendar3.add(Calendar.DATE, 7); // 增加7天
        printCalendar(calendar3);
        // 日历对象和时间对象转化
        Date d = calendar3.getTime();
        GregorianCalendar calendar4 = new GregorianCalendar();
        calendar4.setTime(new Date());
        long g = System.currentTimeMillis();
    }
    static void printCalendar(Calendar calendar) {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int date = calendar.get(Calendar.DAY_OF_WEEK) - 1; // 星期几
        String week = "" + ((date == 0) ? "日" : date);
        int hour = calendar.get(Calendar.HOUR);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);
        System.out.printf("%d年%d月%d日,星期%s %d:%d:%d\n", year, month, day,
                week, hour, minute, second);
    }
}
