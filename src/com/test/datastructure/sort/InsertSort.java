package com.test.datastructure.sort;

/**
 * @author gjf
 * @description 插入排序
 * @date 2022/1/27  16:12
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = Common.initArr(80);
        Common.testMethod(3, arr, true);

    }


    public static void insetSort1(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            //比较当前和前面的数据
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }


    public static void insetSort(int[] arr) {
        int insertVal;
        int insertIndex;
        for (int i = 1; i < arr.length; i++) {
            /*int insertIndex = i - 1;
            int iValue = arr[i];
            *//*for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    insertIndex--;
                }
            }*//*
            while (insertIndex >= 0 && arr[insertIndex] > arr[i]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = iValue;
            }*/
            //定义待插入的数
            insertVal = arr[i];
            insertIndex = i - 1; // 即arr[1]的前面这个数的下标

            // 给insertVal 找到插入的位置
            // 说明
            // 1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
            // 2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
            // 3. 就需要将 arr[insertIndex] 后移
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
                insertIndex--;
            }
            // 当退出while循环时，说明插入的位置找到, insertIndex + 1
            // 举例：理解不了，我们一会 debug
            //这里我们判断是否需要赋值
            if(insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertVal;
            }
        }
    }


}
