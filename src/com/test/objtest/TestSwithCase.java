package com.test.objtest;

/**
 * @Description:
 * @Copyright: Copyright (c) 2020  ALL RIGHTS RESERVED.
 * @Company: 宝能汽车销售有限公司
 * @Author: 龚剑锋
 * @CreateDate: 2020/12/16 11:22
 * @UpdateDate: 2020/12/16 11:22
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu 测试SwithCase
 */
public class TestSwithCase {


    private static final String R = "a";

    private void test(String x) {

        switch (x) {
            case Rx.RR:
                break;
            default:
                return;
        }
    }

    public class Rx {
        public static final String RR = "a";

    }

    public static void main(String[] args) {

    }
}
