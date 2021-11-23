package com.test.base.date;

import cn.hutool.core.date.DateUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTest {

    public static void main(String[] args) {
        System.out.println(DateUtils.date2Str(getDayStart(Calendar.getInstance().getTime()), DateUtils.YYYY_MM_DD_S));
        System.out.println(DateUtils.date2Str(getDayEnd(Calendar.getInstance().getTime()), DateUtils.YYYY_MM_DD_S));

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        Date tomarrow = calendar.getTime();
        System.out.println(DateUtils.date2Str(getDayStart(tomarrow), DateUtils.YYYY_MM_DD_S));

    }

    public static Date getDayStart(Date date) {
        if (date == null) {
            date = new Date();
        }

        Calendar currentDate = new GregorianCalendar();
        currentDate.setTime(date);
        currentDate.set(11, 0);
        currentDate.set(12, 0);
        currentDate.set(13, 0);
        currentDate.set(14, 0);
        return currentDate.getTime();
    }


    public static Date getDayEnd(Date date) {
        if (date == null) {
            date = new Date();
        }

        Calendar currentDate = new GregorianCalendar();
        currentDate.setTime(date);
        currentDate.set(11, 23);
        currentDate.set(12, 59);
        currentDate.set(13, 59);
        return currentDate.getTime();
    }
}
