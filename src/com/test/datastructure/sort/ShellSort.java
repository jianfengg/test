package com.test.datastructure.sort;

import com.aliyun.openservices.shade.org.apache.commons.lang3.ArrayUtils;

/**
 * @author gjf
 * @description
 * @date 2022/1/29  14:34
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = Common.initArr(8);
        Common.testMethod(4, arr, true);
    }


    public static void shellSort(int[] arr) {
        if (ArrayUtils.isEmpty(arr)) {
            return;
        }
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        int temp = arr[j + gap];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
    }


}
