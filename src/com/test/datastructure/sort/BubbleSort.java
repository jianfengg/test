package com.test.datastructure.sort;

import cn.hutool.core.util.ArrayUtil;

import java.util.Arrays;

/**
 * @author gjf
 * @description 冒泡排序
 * @date 2022/1/27  14:22
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr1 = Common.initArr(80000);
        testMethod(true, arr1, false);

        int[] arr2 = Common.initArr(80000);
        testMethod(false, arr2, false);
    }


    /**
     * 运行哪种排序
     * @param first 测试第一种
     * @param arr 初始数组
     */
    public static void testMethod(boolean first, int[] arr, boolean print) {
        long start = System.currentTimeMillis();
        if (print) {
        System.out.printf("原始数组: %s \n", Arrays.toString(arr));
        }

        if (first) {
            SelectSort.selectSort(arr);
        } else {
            bubbleSort(arr);
        }

        long end = System.currentTimeMillis();


        System.out.printf("耗时：%d \n", end - start);

        if (print) {
            System.out.printf("排序后数组: %s \n\n\n", Arrays.toString(arr));
        }
    }



    /**
     * 交换
     * @param arr 数据
     */
    public static void bubbleSort(int[] arr) {
        System.out.printf("method：%s \n", "bubbleSort2");
        if (ArrayUtil.isEmpty(arr)) {
            System.err.println("arr is empty");
            return;
        }
        boolean hasChange = false;
        long loopNum = 0L;
        for (int i = 0; i < arr.length - 1; i++) {
            //当前的值
            //和当前序号之后的值进行比较
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    hasChange = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                loopNum++;
            }
            //获取到最小值，判断是否进行了交换
            if (hasChange) {
                hasChange = false;
            } else {
                //一次都没有进行交换，不必进行循环交换了，已经有序了
                break;
            }
        }

        System.out.printf("循环次数：%d \n", loopNum);
    }

}
