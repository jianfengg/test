package com.test.common.utils;

import java.util.*;

/**
 * @Description: 时间工具类
 * @Copyright: Copyright (c) 2021  ALL RIGHTS RESERVED.
 * @Company: 宝能汽车销售有限公司
 * @Author: gjf
 * @CreateDate: 2021/3/25 15:56
 * @UpdateDate: 2021/3/25 15:56
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
public class DateUtils {

    public static void main(String[] args) {
        /*List<String> s = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        List<String> list = map.get(null);
        System.out.println(list.add("1"));*/

        System.out.println("SettlementStatus".toUpperCase());


    }

    public static Long subDate(Date date1, Date date2) {
        long time1 = date1.getTime();
        long time2 = date2.getTime();
        long time3 = time1 - time2;
        long time4 = time3 / 1000L / 60L / 60L / 24L;
        return time4;
    }
}
