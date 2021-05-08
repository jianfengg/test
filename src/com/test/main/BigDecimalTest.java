package com.test.main;

import java.math.BigDecimal;

/**
 * @Description:
 * @Copyright: Copyright (c) 2021  ALL RIGHTS RESERVED.
 * @Company: 宝能汽车销售有限公司
 * @Author: gjf
 * @CreateDate: 2021/4/29 16:54
 * @UpdateDate: 2021/4/29 16:54
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
public class BigDecimalTest {

    public static void main(String[] args) {
        BigDecimal b1 = new BigDecimal(0.1);
        BigDecimal b2 = new BigDecimal(0.2);

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b1.add(b2));
    }
}
