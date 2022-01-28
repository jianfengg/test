package com.test.datastructure.sort;

import cn.hutool.core.util.ArrayUtil;

import java.util.Arrays;

/**
 * @author gjf
 * @description 选择排序
 * @date 2022/1/27  16:02
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = Common.initArr(80000);
        long start = System.currentTimeMillis();
        System.out.printf("原始数组: %s \n", Arrays.toString(arr));
        selectSort(arr);

        long end = System.currentTimeMillis();


        System.out.printf("耗时：%d \n", end - start);

        System.out.printf("排序后数组: %s \n\n\n", Arrays.toString(arr));
    }


    /**
     * 选择排序
     *
     * @param arr 数组
     */
    public static void selectSort(int[] arr) {
        System.out.printf("method：%s \n", "bubbleSort");
        if (ArrayUtil.isEmpty(arr)) {
            System.err.println("arr is empty");
            return;
        }
        boolean hasChange = false;
        int minIndex;
        int min;
        long loopNum = 0L;
        for (int i = 0; i < arr.length; i++) {
            //当前的值
            minIndex = i;
            min = arr[i];
            //和当前序号之后的值进行比较
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    hasChange = true;
                    minIndex = j;
                    min = arr[j];
                }
                loopNum++;
            }
            //获取到最小值，判断是否进行了交换
            if (hasChange) {
                arr[minIndex] = arr[i];
                arr[i] = min;
                hasChange = false;
            }
        }

        System.out.printf("循环次数：%d \n", loopNum);
    }


}
