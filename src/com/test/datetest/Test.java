package com.test.datetest;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Test {

    public static final String YYYY_MM_DD_MM_HH_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYYMMDD = "yyyyMMdd";
    public static final String YYYYMMDDMMHHSS = "yyyyMMddHHmmss";
    public static final String MMDD = "MM.dd";

    public static void main(String[] args) throws ParseException {
//        testDateUtil();

        Tsa tsa = null;
        /*try {
            tsa = Tsa.class.newInstance();
        } catch (InstantiationException e) {

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(tsa.toString());*/

        /*Integer i1 = null;
        if(i1 > 1) {
            System.out.println(i1);
        }*/

        /*BigDecimal b1 = BigDecimal.ZERO;
        testBigDecimalAdd(b1);
        System.out.println(b1);*/

        /*List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("e");

        System.out.println(String.join(",",list));*/


        /*Date time = getNight();
        Calendar calendar  = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date calTime = calendar.getTime();
        calendar.add(Calendar.DATE, -90);
        Date time1 = calendar.getTime();
        new SimpleDateFormat("");
        System.out.println(time);

        DateFormat dateFormat = getDateFormat("yyyy-MM-dd HH:mm:ss");

        String format = dateFormat.format(time);
        String format1 = dateFormat.format(calTime);
        System.out.println(format);
        System.out.println(format1);
        System.out.println(dateFormat.format(time1));

        System.out.println(BigDecimal.ZERO.intValue());

        int after = time1.compareTo(time1);
        System.out.println(after);*/

        /*long startTime = System.currentTimeMillis();
//        Thread.sleep(3000);

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - startTime);*/

        /*String format = String.format("估价单追加配件参数校验：【isAppendParts】=【%s】，【appendHour】=【%s】，【isAppend】=【%s】", true, false, true);
        System.out.println(format);*/

        System.out.println(Boolean.parseBoolean("null1"));

        String tet = "BQdwdwq";
        String tet1 = "wdBQdwdwq";
        System.out.println(tet.startsWith("BQ"));
        System.out.println(tet1.startsWith("BQ"));

    }

    public static DateFormat getDateFormat(String formatText) {
        return new SimpleDateFormat(formatText);
    }

    public static Date getNight() {
        Calendar cal = Calendar.getInstance();
        cal.set(11, 24);
        cal.set(13, 0);
        cal.set(12, 0);
        cal.set(14, 0);
        return cal.getTime();
    }

    public static void testDateUtil() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        DateTime dateTime = DateUtil.beginOfDay(date);

        System.out.println(sdf.format(date));


        System.out.println(sdf.format(dateTime));

        DateTime endOfDay = DateUtil.endOfDay(date);
        System.out.println(sdf.format(dateTime));
    }

    public static class Tsa {
        private String dr = "0";

        private String dd;

        public String getDr() {
            return dr;
        }

        public void setDr(String dr) {
            this.dr = dr;
        }

        public String getDd() {
            return dd;
        }

        public void setDd(String dd) {
            this.dd = dd;
        }

        @Override
        public String toString() {
            return "Tsa{" +
                    "dr='" + dr + '\'' +
                    ", dd='" + dd + '\'' +
                    '}';
        }
    }

    public static void testBigDecimalAdd(BigDecimal bigDecimal) {
        bigDecimal = bigDecimal.add(new BigDecimal("21"));
    }
}
