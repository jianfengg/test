package com.test.datastructure.sort;

import java.util.Arrays;

/**
 * @author gjf
 * @description 测试
 * @date 2022/1/27  16:04
 */
public class Common {


    /**
     * 初始化数组
     * @param size
     * @return
     */
    public static int[] initArr(int size) {
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            //生成一个[0, 1000000) 数
            arr[i] = (int) (Math.random() * 1000000);
        }
        return arr;
    }


    /**
     * 运行哪种排序
     * @param m 测试第一种排序
     * @param arr 初始数组
     */
    public static void testMethod(int m, int[] arr, boolean print) {
        long start = System.currentTimeMillis();
        if (print) {
            System.out.printf("原始数组: %s \n", Arrays.toString(arr));
        }

        if (m == 1) {
            System.out.printf("method：%s \n", "bubbleSort");
            BubbleSort.bubbleSort(arr);
        } else if (m == 2){
            System.out.printf("method：%s \n", "selectSort");
            SelectSort.selectSort(arr);
        } else if (m ==3) {
            System.out.printf("method：%s \n", "insetSort");
            InsertSort.insetSort(arr);
        } else if (m ==4) {
            System.out.printf("method：%s \n", "insetSort");
            ShellSort.shellSort(arr);
        } else {
            System.out.println("输入正确的排序方法! \n");
        }

        long end = System.currentTimeMillis();


        System.out.printf("耗时：%d \n", end - start);

        if (print) {
            System.out.printf("排序后数组: %s \n\n\n", Arrays.toString(arr));
        }
    }

}
