package com.test.datetest;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

    public static void main(String[] args) {
//        testDateUtil();

        Tsa tsa = null;
        try {
            tsa = Tsa.class.newInstance();
        } catch (InstantiationException e) {

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(tsa.toString());
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
}
