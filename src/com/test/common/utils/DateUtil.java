package com.test.common.utils;


import com.aliyun.openservices.shade.org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateUtil {

    public static final String PATTERN_yyyyMM = "yyyyMM";
    public static final String PATTERN_yyyy_MM = "yyyy-MM";
    public static final String PATTERN_yyyyYear_MMDAY = "yyyy年MM月";
    public static final String PATTERN_chinese_yyyyYear_MMDAY = "yyyy年MM月dd日 HH:mm";
    public static final String PATTERN_yyyy = "yyyy";
    public static final String PATTERN_MM = "MM";
    public static final String PATTERN_yyyy_MM_dd = "yyyy-MM-dd";
    public static final String PATTERN_yyyyMMddHHmmss = "yyyyMMddHHmmss";
    public static final String PATTERN_yyyy_MM_dd_HHmmss = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_yyyy_MM_dd_T_HHmmss = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String PATTERN_yyyy_MM_dd_HHmm = "yyyy-MM-dd HH:mm";
    public static final String PATTERN_yyyy_MM_ddHHmmss = "yyyy-MM-ddHH:mm:ss";
    public static final String PATTERN_yyyyMMdd = "yyyyMMdd";
    public static final String PATTERN_yyyyMMddHHmmssSSS = "yyyyMMddHHmmssSSS";
    public static final String PATTERN_HTTP = "EEE, ddl MMM yyyy HH:mm:ss zzz";
    public static final String PATTERN_HHmm = "HH:mm";

    /**
     * 获取当天的yyyy-MM-dd时间
     *
     * @return 当天的yyyy-MM-dd格式时间
     */
    public static String getTodayStr() {
        return parseDateToString(Calendar.getInstance().getTime(), PATTERN_yyyy_MM_dd);
    }

    public static String getCurrentTimeString() {
        return parseDateToString(Calendar.getInstance().getTime(), PATTERN_yyyyMMddHHmmssSSS);
    }

    public static String parseDateToString(Date date, String pattern) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat _df = new SimpleDateFormat(pattern);
        return _df.format(date);
    }

    public static String parseDateToStringDateTime(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat _df = new SimpleDateFormat(PATTERN_yyyy_MM_dd_HHmmss);
        return _df.format(date);
    }

    /**
     * 获取某一天结束时间
     *
     * @param date
     * @return
     */
    public static Date getDayEnd(Date date) {
        if (date == null) {
            date = new Date();
        }
        Calendar currentDate = new GregorianCalendar();
        currentDate.setTime(date);
        currentDate.set(Calendar.HOUR_OF_DAY, 23);
        currentDate.set(Calendar.MINUTE, 59);
        currentDate.set(Calendar.SECOND, 59);
        return currentDate.getTime();
    }

    public static Date getDayStart(Date date) {
        if (date == null) {
            date = new Date();
        }
        Calendar currentDate = new GregorianCalendar();
        currentDate.setTime(date);
        currentDate.set(Calendar.HOUR_OF_DAY, 0);
        currentDate.set(Calendar.MINUTE, 0);
        currentDate.set(Calendar.SECOND, 0);
        currentDate.set(Calendar.MILLISECOND, 0);
        return currentDate.getTime();
    }

    /**
     * 当前剩余时间：秒
     *
     * @return
     */
    public static Long getTodayRemainSeconds() {
        Date currDate = Calendar.getInstance().getTime();
        Date todayEndDate = getDayEnd(currDate);
        Long result = todayEndDate.getTime() - currDate.getTime();
        return result / 1000;
    }

    public final static long getDateLong() {
        return (new Date()).getTime();
    }

    public static Date format(Date date, String pattern) {
        if (date == null) {
            return date;
        }
        SimpleDateFormat _df = new SimpleDateFormat(pattern);
        _df.format(date);
        return date;
    }

    public static double getCurrentTime_fortoken() {
        return Double.parseDouble(getCurrentTimeString().substring(0, 13));
    }

    public static String parseDateToHttp(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat _df = new SimpleDateFormat(PATTERN_HTTP, Locale.US);
        return _df.format(date);
    }

    public static Date addDate(Date date, Integer addCount) {
        if (date == null || null == addCount) {
            return date;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, addCount);
        return calendar.getTime();
    }

    public static Date addHour(Date date, Integer addCount) {
        if (date == null || null == addCount) {
            return date;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, addCount);
        return calendar.getTime();
    }

    public static Date addMinute(Date date, Integer addCount) {
        if (date == null || null == addCount) {
            return date;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, addCount);
        return calendar.getTime();
    }

    public static Date parseLongToDate(long time) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time);
        return cal.getTime();
    }

    public static String parseLongToDateStr(long time, String pattern) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(time);
        Date date = cal.getTime();
        return parseDateToString(date, pattern);
    }

    public static Long parseDateStrToLong(String dateStr, String pattern) throws ParseException {
        Date date = parseStringToDate(dateStr, pattern);
        return date.getTime();
    }

    /**
     * 使用参数Format将字符串转为Date
     *
     * @throws ParseException
     */
    public static Date parseStringToDate(String strDate, String pattern) throws ParseException {
        SimpleDateFormat _df = new SimpleDateFormat(pattern);
        return _df.parse(strDate);
    }

    public static long getTimeDiff(Date begin_date, Date end_date) {
        return end_date.getTime() - begin_date.getTime();
    }

    /**
     * 根据开始时间和结束时间返回时间段内的时间集合
     *
     * @param beginDate
     * @param endDate
     * @return List
     */
    public static List<Date> getDatesBetweenTwoDate(Date beginDate, Date endDate) {
        List<Date> lDate = new ArrayList<Date>();
        lDate.add(beginDate);// 把开始时间加入集合
        Calendar cal = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        cal.setTime(beginDate);
        boolean bContinue = true;
        while (bContinue) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            cal.add(Calendar.DAY_OF_MONTH, 1);
            // 测试此日期是否在指定日期之后
            if (endDate.after(cal.getTime())) {
                lDate.add(cal.getTime());
            } else {
                break;
            }
        }
        lDate.add(endDate);// 把结束时间加入集合
        return lDate;
    }

    /**
     * 根据开始时间和结束时间返回时间段内的时间集合
     *
     * @param beginDate
     * @param endDate
     * @return List
     */
    public static List<String> getDatesBetweenTwoDate(String beginDate, String endDate) {
        List<String> lDate = new ArrayList<String>();
        try {
            if (beginDate.compareTo(endDate) > 0) {
                return lDate;
            }

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            lDate.add(beginDate);// 把开始时间加入集合
            Calendar cal = Calendar.getInstance();
            // 使用给定的 Date 设置此 Calendar 的时间
            cal.setTime(sdf.parse(beginDate));
            Date endDate0 = sdf.parse(endDate);
            boolean bContinue = true;
            while (bContinue) {
                // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
                cal.add(Calendar.DAY_OF_MONTH, 1);
                // 测试此日期是否在指定日期之后
                if (endDate0.after(cal.getTime())) {
                    lDate.add(sdf.format(cal.getTime()));
                } else {
                    break;
                }
            }
            if (!endDate.equals(beginDate)) {
                lDate.add(endDate);// 把结束时间加入集合
            }
        } catch (Exception e) {

        }
        return lDate;
    }

    /**
     * 获取两个日期相差的天数
     *
     * @return
     */
    public static Integer getDifferentDays(Date beginDate, Date endDate) {
        int days = (int) ((endDate.getTime() - beginDate.getTime()) / (1000 * 3600 * 24));
        return days;
    }

    /**
     * 获取日期是周几
     *
     * @param time
     * @return
     */
    public static String getWeekOfDate(Date time) {
        String[] weekDays = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 0;
        }
        return weekDays[w];
    }


    public static int daysBetween(String startDate, String endDate, boolean containEndDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(startDate));
        long time1 = cal.getTimeInMillis();
        cal.setTime(sdf.parse(endDate));
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        int i = Integer.parseInt(String.valueOf(between_days));
        if (containEndDate) {
            i += 1;
        }
        return i;
    }

    public static int daysBetween(Date smdate, Date bdate, boolean containEndDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        smdate = sdf.parse(sdf.format(smdate));
        bdate = sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        if (containEndDate) {
            between_days += 1;
        }
        return Integer.parseInt(String.valueOf(between_days));
    }

    /**
     * 获取两个日期内的所有月份
     *
     * @param minDate
     * @param maxDate
     * @return
     * @throws ParseException
     */
    public static List<String> getMonthBetween(String minDate, String maxDate) throws ParseException {
        ArrayList<String> result = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月

        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();

        min.setTime(sdf.parse(minDate));
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

        max.setTime(sdf.parse(maxDate));
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

        Calendar curr = min;
        while (curr.before(max)) {
            result.add(sdf.format(curr.getTime()));
            curr.add(Calendar.MONTH, 1);
        }

        return result;
    }

    /**
     * 获取两个时间之间的时间差(分钟)
     *
     * @param departureTime
     * @param departureTimeNext
     * @return
     */
    public static Integer getIntervalTime(String departureTime, String departureTimeNext) {
        if (StringUtils.isBlank(departureTime) || StringUtils.isBlank(departureTimeNext)) {
            return null;
        }
        try {
            Date departureTimeDate = DateUtil.parseStringToDate(departureTime, DateUtil.PATTERN_HHmm);
            Date departureTimeNextDate = DateUtil.parseStringToDate(departureTimeNext, DateUtil.PATTERN_HHmm);
            Long intervalTime = departureTimeNextDate.getTime() - departureTimeDate.getTime();
            Long minute = intervalTime / 60 / 1000;
            return minute.intValue();
        } catch (ParseException e) {
//            logger.warn("计算两个时间之间的差出错，exception:{}", ExceptionUtils.getMessage(e));
            return null;
        }
    }

    /**
     * 获取一个月的最后一天
     *
     * @param startDateStr
     * @return
     * @throws ParseException
     */
    public static String getLastDay(String startDateStr) throws ParseException {
        // TODO Auto-generated method stub
        String month = startDateStr.substring(5, 7);
        String year = startDateStr.substring(0, 4);
        Integer currentMonth = Integer.parseInt(month);
        String thismonth = currentMonth.toString();
        if (currentMonth < 10) {
            thismonth = year + "-0" + thismonth;
        } else {
            thismonth = year + "-" + thismonth;
        }
        //拿到月份的第一天
        month = thismonth + "-01";
        Date date = parseStringToDate(month, PATTERN_yyyy_MM_dd);
        Calendar cal = Calendar.getInstance();
        cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, 0);
        return parseDateToString(cal.getTime(), PATTERN_yyyy_MM_dd);
    }

    public static List<String> getMonthFullDay(String date) {
        List<String> fullDayList = new ArrayList<>();
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = 1;// 所有月份从1号开始
        Calendar cal = Calendar.getInstance();// 获得当前日期对象
        cal.clear();// 清除信息
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);// 1月从0开始
        cal.set(Calendar.DAY_OF_MONTH, day);
        int count = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int j = 0; j <= (count - 1); ) {
            if (parseDateToString(cal.getTime(), PATTERN_yyyy_MM_dd).equals(getLastDay(year, month))) {
                break;
            }
            cal.add(Calendar.DAY_OF_MONTH, j == 0 ? +0 : +1);
            j++;
            fullDayList.add(parseDateToString(cal.getTime(), PATTERN_yyyy_MM_dd));
        }
        return fullDayList;
    }

    public static List<Date> getMonthFullDays(String date) {
        List<Date> fullDayList = new ArrayList<>();
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = 1;// 所有月份从1号开始
        Calendar cal = Calendar.getInstance();// 获得当前日期对象
        cal.clear();// 清除信息
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1);// 1月从0开始
        cal.set(Calendar.DAY_OF_MONTH, day);
        int count = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int j = 0; j <= (count - 1); ) {
            if (parseDateToString(cal.getTime(), PATTERN_yyyy_MM_dd).equals(getLastDay(year, month))) {
                break;
            }
            cal.add(Calendar.DAY_OF_MONTH, j == 0 ? +0 : +1);
            j++;
            fullDayList.add(cal.getTime());
        }
        return fullDayList;
    }

    public static String getLastDay(int year, int month) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, 0);
        return parseDateToString(cal.getTime(), PATTERN_yyyy_MM_dd);
    }

    public static String getLastDayOfMonth(String yearMonth) {
        int year = Integer.parseInt(yearMonth.split("-")[0]);  //年
        int month = Integer.parseInt(yearMonth.split("-")[1]); //月
        Calendar cal = Calendar.getInstance();
        // 设置年份
        cal.set(Calendar.YEAR, year);
        // 设置月份
        // cal.set(Calendar.MONTH, month - 1);
        cal.set(Calendar.MONTH, month); //设置当前月的上一个月
        // 获取某月最大天数
        //int lastDay = cal.getActualMaximum(Calendar.DATE);
        int lastDay = cal.getMinimum(Calendar.DATE); //获取月份中的最小值，即第一天
        // 设置日历中月份的最大天数
        //cal.set(Calendar.DAY_OF_MONTH, lastDay);
        cal.set(Calendar.DAY_OF_MONTH, lastDay - 1); //上月的第一天减去1就是当月的最后一天
        // 格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cal.getTime());
    }

    public static Date getLastDayTimeOfMonth(Date date) {
        int year = Integer.parseInt(parseDateToString(date, PATTERN_yyyy));//年
        int month = Integer.parseInt(parseDateToString(date, PATTERN_MM)); //月
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        int lastDay = cal.getMinimum(Calendar.DATE);
        cal.set(Calendar.DAY_OF_MONTH, lastDay - 1);
        return getDayEnd(cal.getTime());
    }

    /**
     * 字符串格式的日期排序（顺序排列）
     *
     * @param dates yyyy-MM-dd格式的时间集
     */
    public static void strDateSortAsc(List<String> dates) {
        //日期顺序排列
        dates.sort((o1, o2) -> {
            if (StringUtils.isBlank(o1) || StringUtils.isBlank(o2)) {
                return 0;
            }
            try {
                Date date1 = DateUtil.parseStringToDate(o1, DateUtil.PATTERN_yyyy_MM_dd);
                Date date2 = DateUtil.parseStringToDate(o2, DateUtil.PATTERN_yyyy_MM_dd);
                if (date1.after(date2)) {
                    return 1;
                } else if (date2.after(date1)) {
                    return -1;
                }
            } catch (Exception e) {
//                logger.error("prePlanSchedule,exception:{}",ExceptionUtils.getMessage(e));
                return 0;
            }
            return 0;
        });
    }

    public static Long subDate(Date date1, Date date2) {
        long time1 = date1.getTime();
        long time2 = date2.getTime();
        long time3 = time1 - time2;
        long time4 = time3 / 1000L / 60L / 60L / 24L;
        return time4;
    }


    public static void main(String[] args) throws ParseException {
        /*List<String> s = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        List<String> list = map.get(null);
        System.out.println(list.add("1"));*/

//        System.out.println("SettlementStatus".toUpperCase());

        String da = "24:00";

        Date date = DateUtil.parseStringToDate(da, DateUtil.PATTERN_HHmm);
        String format = DateUtil.parseDateToString(date, DateUtil.PATTERN_yyyy_MM_dd_HHmmss);
        System.out.println(format);

    }
}
