package com.test.datastructure.sort;

/**
 * @author gjf
 * @description 快排
 * @date 2022/2/23  10:48
 */
public class QuickSort {

    public static void main(String[] args) {

    }


    public static void quickSort(int[] arr, int left, int right) {
        int l = left; //左下标
        int r = right; //右下标
        int pivot = arr[(left + right) / 2];
        int temp;
        while (l < r) {

            while (arr[l] < pivot) {
                l ++;
            }

            while (arr[r] > pivot) {
                r --;
            }

            //如果l >= r说明pivot 的左右两的值，已经按照左边全部是
            //小于等于pivot值，右边全部是大于等于pivot值
            if (l >= r) {
                //循环到临界点，不再继续了
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现这个arr[l] == pivot值 相等 r--， 前移
            if(arr[l] == pivot) {
                r -= 1;
            }
            //如果交换完后，发现这个arr[r] == pivot值 相等 l++， 后移
            if(arr[r] == pivot) {
                l += 1;
            }



        }


    }
}
