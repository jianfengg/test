package com.test.objtest;

import com.test.common.utils.DateUtil;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ObjectsTest {

    public static void main(String[] args) {
       /* for (int i = 0; i < args.length; i++) {
            System.out.println(i == 0 ? args[i] : "X " + args[i]);

        }*/

//        testBigD();
//        testD();
        Map<String, Object> map = new HashMap<>(10);
        System.out.println(map.size());
    }



    public static void testStr() {
        String s = Objects.toString("a", "b");
        System.out.println(s);


        String ss = "";
        System.out.println(ss);

        Integer i1 = 2;
        Integer i2 = 2;
        System.err.println(i2.intValue() == i1);

        System.out.println(String.format("配件号：[%s] 为特定件，特定件代码不能为空！！","item.getCode()"));
    }

    public static void testBigD() {
        Integer pageSize = 1000;
        BigDecimal totalVal = new BigDecimal("1155");
        BigDecimal totalPage = totalVal.divide(new BigDecimal(pageSize)).setScale(0, BigDecimal.ROUND_UP);
        System.out.println(totalPage);
    }


    public static void testD() {
        /*
        2021-03-21 09:36:28
    2021-03-22 12:22:32
     */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date inStockTime = null;
        Date endtime = null;
        try {
//            inStockTime = sdf.parse("2021-03-21 09:36:28");
            //明细的时间
            inStockTime = sdf.parse("2020-12-16 13:43:52");
            //job执行时间
            endtime = sdf.parse("2021-03-30 00:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
            return;
        }
        BigDecimal days = new BigDecimal(DateUtil.subDate(endtime, inStockTime));
        if (0 <= days.intValue() && days.intValue() < 1) {
            days = BigDecimal.ONE;
        }
        System.out.printf("days %s \n",days);

        BigDecimal stockQuantityTotal = BigDecimal.ZERO;

        //明细中的库存数
        BigDecimal stockQuantity = new BigDecimal("1887454");
        stockQuantityTotal = stockQuantityTotal.add(stockQuantity.multiply(days));

        if (stockQuantityTotal.intValue() < 0) {
            stockQuantityTotal = new BigDecimal(BigInteger.ZERO);
        }
        //定义库存表的库存数
//        BigDecimal stock = new BigDecimal("0.62");
        BigDecimal stock = new BigDecimal("1887454");
        //库龄天数
        BigDecimal daysAge = BigDecimal.ONE;
        if (stock.intValue() != 0) {
            daysAge = stockQuantityTotal.divide(stock, 6, BigDecimal.ROUND_UP);
            if (daysAge.compareTo(BigDecimal.ZERO) == 0) {
                daysAge = BigDecimal.ONE;
            }
        }else if(stock.intValue() == 0){
            //库存为0，则设置库龄为0
            daysAge = BigDecimal.ZERO;
        }

        System.out.printf("库龄 [%s]",daysAge);
    }
}
