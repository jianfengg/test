package com.test.main;

import com.test.dto.collect.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Copyright: Copyright (c) 2021  ALL RIGHTS RESERVED.
 * @Company: 宝能汽车销售有限公司
 * @Author: gjf
 * @CreateDate: 2021/4/29 11:28
 * @UpdateDate: 2021/4/29 11:28
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
public class TesetPerson {

    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setId(123);

        List<Person> list1  = new ArrayList<>();
        list1.add(p1);
        Data data = new Data();
        data.setData(list1);

//        Data toBean = BeanUtil.toBean(data, Data.class);

//        List<com.test.dto.object.Person> p2 = (List<com.test.dto.object.Person>)toBean.getData();
        List<com.test.dto.object.Person> p2 = (List<com.test.dto.object.Person>)data.getData();

        System.out.println(p2.toString());
    }

    static class Data{
        public Data() {
            super();
        }

        private Object data;

        private String key;

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }

}
