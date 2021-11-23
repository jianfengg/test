package com.test.base.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtils {

    public static final String YYYY_MM_DD = "yyyy-MM-dd";
    public static final String YYYY_MM_DD_S = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_yyyyMM = "yyyyMM";
    public static final String PATTERN_yyyy_MM = "yyyy-MM";
    public static final String PATTERN_yyyy_MM_dd = "yyyy-MM-dd";
    public static final String PATTERN_yyyyMMddHHmmss = "yyyyMMddHHmmss";
    public static final String PATTERN_yyyy_MM_dd_HHmmss = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_yyyy_MM_dd_HHmm = "yyyy-MM-dd HH:mm";
    public static final String PATTERN_yyyy_MM_ddHHmmss = "yyyy-MM-ddHH:mm:ss";
    public static final String PATTERN_yyyyMMdd = "yyyyMMdd";
    public static final String PATTERN_yyyyMMddHHmmssSSS = "yyyyMMddHHmmssSSS";
    public static final String PATTERN_HTTP = "EEE, dd MMM yyyy HH:mm:ss zzz";
    public static final String PATTERN_HHmm = "HH:mm";


    private static String DA = "2021-07-09 07:08:42";
    public static String date2Str(Date date, String formate) {


        SimpleDateFormat sdf = new SimpleDateFormat(formate);



        return sdf.format(date);
    }


    public static Date str2Date(String date, String formate) throws ParseException {


        SimpleDateFormat sdf = new SimpleDateFormat(formate);
        return sdf.parse(date);
    }

    public static List<Date> getDatesBetweenTwoDate(Date beginDate, Date endDate) {
        List<Date> lDate = new ArrayList();
        lDate.add(beginDate);
        Calendar cal = Calendar.getInstance();
        cal.setTime(beginDate);
        boolean bContinue = true;

        while(bContinue) {
            cal.add(5, 1);
            if (!endDate.after(cal.getTime())) {
                break;
            }

            lDate.add(cal.getTime());
        }

        lDate.add(endDate);
        return lDate;
    }

    public static Date parseStringToDate(String strDate, String pattern) throws ParseException {
        SimpleDateFormat _df = new SimpleDateFormat(pattern);
        return _df.parse(strDate);
    }


    public static void main(String[] args) throws ParseException {
//        System.out.println(str2Date(DA, YYYY_MM_DD_S).getTime());
//        System.out.println(501/500);

        String start = "";
        String end = "";
//        Date beginDate = parseStringToDate(startTime, PATTERN_yyyy_MM_dd);
//        Date endDate = parseStringToDate(endTime, PATTERN_yyyy_MM_dd);

    }
}
