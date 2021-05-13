package com.test.datastructure.stack;

import com.test.common.utils.CalculatorUtils;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * @Copyright: Copyright (c) 2021  ALL RIGHTS RESERVED.
 * @Company: 宝能汽车销售有限公司
 * @Author: gjf
 * @CreateDate: 2021/5/13 9:54
 * @UpdateDate: 2021/5/13 9:54
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
public class CalculatorTest {

    public static void main(String[] args) {
        simpleCalculation("1 + 32 + 5 * 16");
    }

    /**
     * 利用栈实现简单四则运算
     */
    public static void simpleCalculation(String express) {
        // 表达式用空格隔开
        String newExpress = express.replaceAll("\\s*", "");
        System.out.println(newExpress);
        String[] array = newExpress.split("");
//        System.out.println(array.length);
        List<String> list = Arrays.asList(array);
//        System.out.println(list.size());

        ArrayStack numStack = new ArrayStack(10);
        ArrayStack operStack = new ArrayStack(10);

        //计算四则运算 依次获取数据进行判断，如果是数值则压入数值栈，否则再进行判断
        //如果是运算符，判断运算符栈中是否为空，如果为空直接压入运算符栈，否则从判断当前的运算符和顶部运算符优先级
        //如果优先级高于当前顶部运算符则压入符号栈，否则从符号栈pop出一个数，从数值栈pop出两个数，计算出结果压入数值栈，并将
        //当前符号也压入符号栈
        String keepNum = "";
        for (int i = 0; i < array.length; i++) {
            String str = array[i];
            char c = str.charAt(0);
            boolean oper = CalculatorUtils.isOper(c);
            if(oper) {
                if(operStack.isEmpty()) {
                    operStack.push(c);
                } else {
                    //当前优先级大于栈顶则push，否则进行计算
                    int topData = operStack.getTopData();
                    if(CalculatorUtils.operLevel(c) > CalculatorUtils.operLevel(topData)) {
                        operStack.push(c);
                    } else {
                        //还需要判断符号优先级
                        int pop = operStack.pop();
                        int num1 = numStack.pop();
                        int num2 = numStack.pop();
                        BigDecimal calculation = CalculatorUtils.calculation(new BigDecimal(num2), new BigDecimal(num1), pop);
                        numStack.push(calculation.intValue());
                        operStack.push(c);
                    }
                }
            } else {
                //如果不是运算符，则需要判断是否是最后一个
                keepNum += str;
                if(i + 1 == array.length ) {
                    //最后一个，压入栈
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    //判断下一个数据是否也是数值类型
                    char s = array[i + 1].charAt(0);
                    if(CalculatorUtils.isOper(s)) {
                        //下一个是数值，则直接push进去
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
        }

        while(true) {
            //如果符号栈为空，则计算到最后的结果, 数栈中只有一个数字【结果】
            if(operStack.isEmpty()) {
                break;
            }
            int num1 = numStack.pop();
            int num2 = numStack.pop();
            int oper = operStack.pop();
            BigDecimal res = CalculatorUtils.calculation(new BigDecimal(num2), new BigDecimal(num1), oper);
            //入栈
            numStack.push(res.intValue());
        }
        System.out.printf("最终计算结果%d",numStack.pop());
    }

}
