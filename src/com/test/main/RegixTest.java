package com.test.main;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.aliyun.openservices.shade.org.apache.commons.lang3.StringEscapeUtils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Copyright: Copyright (c) 2021  ALL RIGHTS RESERVED.
 * @Company: 宝能汽车销售有限公司
 * @Author: gjf
 * @CreateDate: 2021/5/8 17:48
 * @UpdateDate: 2021/5/8 17:48
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
public class RegixTest {

    public static void main(String[] args) {

        String re = "(.+[+\\-*/]).+|.+(\\d+).+";
        String express = "1+2+45*32+9";
        System.out.println(express.matches(re));
        Pattern compile = Pattern.compile(re);
        Matcher m = compile.matcher(express);
        System.out.println(m.matches());
        String group = m.group();
        System.out.println(group);
    }

    public static void test2() {
        String re = "[^1-9]{3}.+";
        String str = "aaa123aa";
        System.out.println(str.matches(re));
    }

    public static void test1() {

        //请编写一个正则表达式匹配国内的电话号码规则：3~4位区号加7~8位电话，中间用-连接，例如：010-12345678
//        String r1 = "\\d{3,4}-\\d{7,8}";


        String hello = JSON.toJSONString("哈喽啊", SerializerFeature.BrowserCompatible);
        System.out.println(hello);

        hello = StringEscapeUtils.escapeJava("哈喽啊");
        System.out.println(hello);
        String re = "0\\d{2,3}-"+hello+"-[1-9]\\d{6,7}";
        String re1 = "0\\d{2,3}-[1-9]\\d{6,7}";

        System.out.println(re);
        System.out.println(re1);
        String num = "231-3123112";
        boolean matches = num.matches(re);
        System.out.println(matches);

        for (String s : Arrays.asList("010-12345678", "0220-哈喽啊-9999999", "07551-7654321")) {
            if (!s.matches(re)) {
                System.out.println("测试失败: " + s);
            } else {
                System.out.println("测试成功: " + s);
            }
        }
        for (String s : Arrays.asList("010 12345678", "A20-9999999", "0755-7654.321")) {
            if (!s.matches(re)) {
                System.out.println("测试失败: " + s);
            } else {
                System.out.println("测试成功: " + s);
            }
        }
    }
}
