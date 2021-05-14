package com.test.datastructure.stack;

import cn.hutool.core.collection.CollectionUtil;
import com.test.common.utils.CalculatorUtils;
import com.test.constants.CommonConstants;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @Description: 中缀表达式与波兰表达式相关练习
 * @Copyright: Copyright (c) 2021  ALL RIGHTS RESERVED.
 * @Company:
 * @Author: gjf
 * @CreateDate: 2021/5/13 15:47
 * @UpdateDate: 2021/5/13 15:47
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
public class PolandExpress {

    public static void main(String[] args) {


        String express = "{ 66 + ( 3 + 42 ) * 15 - 8 } * ( 2 * 4 )";
        System.out.println(express);
        //根据空格进行分隔
//        List<String> strList = Arrays.asList(express.split("\\s"));
        List<String> strList = CalculatorUtils.getExpressList(express);
        System.out.println(strList.size());

        System.out.println(strList);
        List<String> polandExpressList = CalculatorUtils.getPolandExpressList(strList);

        System.out.println(CalculatorUtils.calculationPoland(polandExpressList));
    }


}
