package com.test.collecttest;

import cn.hutool.core.collection.CollectionUtil;
import com.test.constants.CollectConstants;
import com.test.dto.collect.Person;

import java.util.*;
import java.util.stream.Collectors;

public class ListTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7,8,7,7);

        int s = list.size()/3;
        System.out.println(s);

        List<List<Integer>> test = averageAssign(list, s);
        for (List<Integer> integers : test) {
            System.out.println(integers.toString());
        }

        /*List<Person> personList = testStream();
        System.err.println(personList);

        List<Person> collect = personList.stream().sorted(Comparator.comparing(Person::getUserCode).reversed().thenComparing(Person::getId)).collect(Collectors.toList());

        System.out.println(collect);

        List<Person> people = personList.subList(0, 2);


        System.err.println(people.size());
        System.err.println(people);

        List<Person> people1 = personList.subList(2, 4);
        System.err.println(people1);*/


        /*Map<String, Set<String>> listMap = personList.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.mapping(Person :: getUserCode, Collectors.toSet())));
        System.err.println(collect);

        System.err.println(listMap);

        Map<String, Set<String>> collect1 = personList.stream().filter(person -> !"p4".equals(person.getUserCode())).collect(Collectors.groupingBy(Person::getSex, Collectors.mapping(Person::getUserCode, Collectors.toSet())));
        System.err.println(collect1);

        Map<String, List<Person>> collect2 = personList.stream().collect(Collectors.groupingBy(Person::getSex));
        System.err.println(collect2);

        Set<String> collect3 = personList.stream().map(Person::getUserCode).collect(Collectors.toSet());
        System.err.println(collect3);

        Map<Integer, Person> personMap = personList.stream().collect(Collectors.toMap(Person::getId, person -> person));
        System.err.println(personMap);*/
    }

    public static void testCollectJoin() {
        List<String> s = new ArrayList<>();
        s.add("a");
        s.add("b");

        String join = CollectionUtil.join(s, ",");
        System.out.println(join);
        System.out.println(String.join(",",s));
    }

    public static List<Person> testStream() {
        List<Person> personList = new ArrayList<>();
        Person person1 = new Person(1,"p10","name1", CollectConstants.PersonConstants.SEX_MAN);
        Person person2 = new Person(2,"p8","name2", CollectConstants.PersonConstants.SEX_WOMAN);
        Person person3 = new Person(3,"p4","name3", CollectConstants.PersonConstants.SEX_MAN);
        Person person4 = new Person(4,"p2","name4", CollectConstants.PersonConstants.SEX_WOMAN);
        Person person5 = new Person(5,"p9","name5", CollectConstants.PersonConstants.SEX_MAN);
        Person person6 = new Person(6,"p5","name6", CollectConstants.PersonConstants.SEX_WOMAN);
        Person person7 = new Person(8,"p4","name7", CollectConstants.PersonConstants.SEX_MAN);
        Person person8 = new Person(7,"p4","name8", CollectConstants.PersonConstants.SEX_WOMAN);

        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        personList.add(person5);
        personList.add(person6);
        personList.add(person7);
        personList.add(person8);

        System.out.println(personList.toString());

        return personList;
    }

    public static <T> List<List<T>> averageAssign(List<T> source, int n) {
        List<List<T>> result = new ArrayList<>();
        //(先计算出余数)
        int remainder = source.size() % n;
        //然后是商
        int number = source.size() / n;
        //偏移量
        int offset = 0;
        for (int i = 0; i < n; i++) {
            List<T> value;
            if (remainder > 0) {
                value = source.subList(i * number + offset, (i + 1) * number + offset + 1);
                remainder--;
                offset++;
            } else {
                value = source.subList(i * number + offset, (i + 1) * number + offset);
            }
            result.add(value);
        }
        return result;
    }
}
