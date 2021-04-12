package com.test.objtest.com.test.timetest;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description:
 * @Copyright: Copyright (c) 2021  ALL RIGHTS RESERVED.
 * @Company: 宝能汽车销售有限公司
 * @Author: gjf
 * @CreateDate: 2021/3/22 14:29
 * @UpdateDate: 2021/3/22 14:29
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
public class TimeTest {

    public static void main(String[] args) {
//        long aLong = 1615787069000L; //2021-03-15 13:44:29
        long aLong = 1601435784000L; //2021-03-15 13:44:29

        Date date = new Date(aLong);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));
    }
}
