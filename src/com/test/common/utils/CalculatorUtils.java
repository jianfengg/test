package com.test.common.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 运算的一些工具方法
 * @Copyright: Copyright (c) 2021  ALL RIGHTS RESERVED.
 * @Company: 宝能汽车销售有限公司
 * @Author: gjf
 * @CreateDate: 2021/5/8 15:53
 * @UpdateDate: 2021/5/8 15:53
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
public abstract class CalculatorUtils {

    private static final List<Character> OPER = Arrays.asList('+','-','*','/');

    /**
     * 判断符号是否是运算符
     * @param oper 符合
     * @return true:运算符，false:不是运算符
     */
    public static boolean checkOper(char oper) {
        return OPER.contains(oper);
    }

    /**
     * 判断是否是运算符
     * @param oper 参数
     * @return true：是，false:不是
     */
    public static boolean isOper(char oper) {
        if(OPER.contains(oper)) {
            return true;
        }
        return false;
    }

    public static BigDecimal calculation(BigDecimal b1, BigDecimal b2, int oper) {
        b1 = BigDecimalUtils.getBigDecimal(b1);
        b2 = BigDecimalUtils.getBigDecimal(b2);
        BigDecimal result;
        switch (oper) {
            case '+' :
                result = b1.add(b2);
                break;
            case '-':
                result = b1.subtract(b2);
                break;
            case '*':
                result = b1.multiply(b2);
                break;
            case '/':
                result = b1.divide(b2).setScale(2, RoundingMode.HALF_UP);
                break;
            default:
                throw new RuntimeException("输入的运算符不合法");
        }
        return result;
    }

    /**
     * 获取符号优先级
     * @param oper1 运算符
     * @return 1:乘除法 0:加减法
     */
    public static int operLevel(int oper1) {
        if('+' == oper1 || '-' == oper1) {
            return 0;
        } else if('*' == oper1 || '/' == oper1) {
            return 1;
        }
        throw new RuntimeException("运算符异常");
    }

}
