package com.test.common.utils;

import cn.hutool.core.collection.CollectionUtil;
import com.test.constants.CommonConstants;
import com.test.datastructure.stack.ArrayStack;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

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

    /**
     * 四则运算符
     */
    public static final List<Character> OPER = Arrays.asList('+','-','*','/');

    /**
     * 括号
     */
    public static final List<Character> TOP_OPER = Arrays.asList('{','}','(',')');

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
     * @return 0:加减法 1:乘除法  2：括号
     */
    public static int operLevel(int oper1) {
        if('+' == oper1 || '-' == oper1) {
            return 0;
        } else if('*' == oper1 || '/' == oper1) {
            return 1;
        } else if(TOP_OPER.contains((char)oper1)) {
            return 2;
        }
        throw new RuntimeException("运算符异常");
    }

    /**
     * 传入一个表示式，解析其格式，返回list，此list就是每个元素
     * @param express 字符串格式表达式
     * @return 将表达式拆分成list
     */
    public static List<String> getExpressList(String express) {
        List<String> expressList = new ArrayList<>();
        //去除表达式中的所有空格
        String newExpress = express.replaceAll(CommonConstants.EMPTY_REGIX, CommonConstants.EMPTY_STR);
        //分隔表达式，重新组装
        String[] split = newExpress.split(CommonConstants.EMPTY_STR);
        String numStr = CommonConstants.EMPTY_STR;
        for (int i = 0; i < split.length; i++) {
            String str = split[i];
            if(str.matches(CommonConstants.NUMBER_REGIX)) {
                //是数值，需要判断下一个是否依旧是数值
                numStr += str;
                if(!split[i+1].matches(CommonConstants.NUMBER_REGIX)) {
                    expressList.add(numStr);
                    numStr = CommonConstants.EMPTY_STR;
                }
            } else {
                //运算符直接放list即可
                expressList.add(str);
            }
        }
        return expressList;
    }

    /**
     * 传入后缀表达式，计算结果
     * @param express 后缀表达式拆分的list
     * @return 计算结果
     */
    public static BigDecimal calculationPoland(List<String> express) {
        if(CollectionUtil.isEmpty(express)) {
            throw new RuntimeException("表达式为空");
        }
        ArrayStack numStack = new ArrayStack(10);
        // 匹配数值
        String re = "\\d+";
        for (String str : express) {
            char c = str.charAt(0);
            boolean matches = str.matches(re);
            if (!matches) {
                int num1 = numStack.pop();
                int num2 = numStack.pop();
                BigDecimal calculation = CalculatorUtils.calculation(new BigDecimal(num2), new BigDecimal(num1), c);
                numStack.push(calculation.intValue());
            } else {
                //如果不是运算符，则需要判断是否是最后一个
                numStack.push(Integer.parseInt(str));
            }
        }
        return new BigDecimal(numStack.pop());
    }

    /**
     * 传入表达式解析出来的list，转换成逆波兰表达式:
     * 1) 初始化两个栈：运算符栈s1和储存中间结果的栈s2；
     * 2) 从左至右扫描中缀表达式；
     * 3) 遇到操作数时，将其压s2；
     * 4) 遇到运算符时，比较其与s1栈顶运算符的优先级：
     * 1.如果s1为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈；
     * 2.否则，若优先级比栈顶运算符的高，也将运算符压入s1；
     * 3.否则，将s1栈顶的运算符弹出并压入到s2中，再次转到(4.1步骤)与s1中新的栈顶运算符相比较；
     * 5) 遇到括号时：  (1) 如果是左括号“(”，则直接压入s1 (2) 如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
     * 6) 重复步骤2至5，直到表达式的最右边
     * 7) 将s1中剩余的运算符依次弹出并压入s2
     * 8)  依次弹出s2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
     * @param strList str
     * @return 逆波兰表达式
     */
    public static List<String> getPolandExpressList(List<String> strList) {
        Stack<String> numStack = new Stack<>();
        Stack<String> operStack = new Stack<>();
        for (String s : strList) {
            boolean matches = s.matches(CommonConstants.NUMBER_REGIX);
            if (matches) {
                //是数值，直接压入数值栈
                numStack.push(s);
            } else {
                //如果是符号需要做校验
                if (operStack.isEmpty() || "(".equals(s) || "{".equals(s)) {
                    operStack.push(s);
                } else if (")".equals(s)) {
                    while (!operStack.isEmpty()) {
                        String pop = operStack.pop();
                        if (!"(".equals(pop)) {
                            numStack.push(pop);
                        } else {
                            break;
                        }
                    }
                } else if ("}".equals(s)) {
                    while (!operStack.isEmpty()) {
                        String pop = operStack.pop();
                        if (!"{".equals(pop)) {
                            numStack.push(pop);
                        } else {
                            break;
                        }
                    }
                } else {
                    //普通运算符与栈顶元素比较优先级
                    String peek = operStack.peek();
                    int operLevel = CalculatorUtils.operLevel(peek.charAt(0));
                    int currentLevel = CalculatorUtils.operLevel(s.charAt(0));
                    if (currentLevel > operLevel || CalculatorUtils.TOP_OPER.contains(peek.charAt(0))) {
                        //如果当前运算符优先级高于栈顶或是括号的，则直接压入栈
                        operStack.push(s);
                    } else {
                        while (true) {
                            //运算符优先级低于栈顶的，则将栈中pop出来放到数据栈，直到大于为止
                            if (operStack.isEmpty()) {
                                operStack.push(s);
                                break;
                            }
                            String pop = operStack.pop();
                            int popLevel = CalculatorUtils.operLevel(pop.charAt(0));
                            if (currentLevel > popLevel || CalculatorUtils.TOP_OPER.contains(pop.charAt(0))) {
                                operStack.push(s);
                                break;
                            } else {
                                numStack.push(pop);
                            }
                        }
                    }
                }
            }
        }
        while (!operStack.isEmpty()) {
            String pop = operStack.pop();
            if(CalculatorUtils.TOP_OPER.contains(pop.charAt(0))) {
                continue;
            }
            numStack.push(pop);
        }
        List<String> expressList = new ArrayList<>();
        while (!numStack.isEmpty()) {
            String pop = numStack.pop();
            expressList.add(pop);
        }
        List<String> reverse = CollectionUtil.reverse(expressList);
        return reverse;
    }
}
