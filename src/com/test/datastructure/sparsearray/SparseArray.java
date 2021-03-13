package com.test.datastructure.sparsearray;

/**
 * @Description: 稀疏数组测试
 * @Copyright: Copyright (c) 2020  ALL RIGHTS RESERVED.
 * @Company: 宝能汽车销售有限公司
 * @Author: gjf
 * @CreateDate: 2021/2/2 11:45
 * @UpdateDate: 2021/2/2 11:45
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
public class SparseArray {

    public static void main(String[] args) {
        int[][] initArray = new int[11][11];
        initArray[1][1] = 1;
        initArray[2][2] = 2;
        initArray[3][3] = 1;
        initArray[4][4] = 2;
        System.out.println("原始数组:");
        int index = 1;
        for (int[] row : initArray) {
            for (int value : row) {
                System.out.printf("%d\t",value);
                if(value != 0) {
                    index++;
                }
            }
            System.out.println();
        }
        int row = initArray.length;
        int cell = initArray[0].length;

        //稀疏数组n行3列，第一行代表汇总数据，表示原数组有多少行列，有几个有效数据
        int[][] sparseArray = new int[index][3];
        sparseArray[0][0] = row;
        sparseArray[0][1] = cell;
        sparseArray[0][2] = index-1;
        int num = 1;
        for (int i = 0; i < initArray.length; i++) {
            for (int j = 0; j < initArray[i].length; j++) {
                if(initArray[i][j] != 0) {
                    sparseArray[num][0] = i;
                    sparseArray[num][1] = j;
                    sparseArray[num][2] = initArray[i][j];
                    num++;
                }
            }
        }
        System.out.println("稀疏数组：");
        for (int[] srow : sparseArray) {
            for (int value : srow) {
                System.out.printf("%d\t",value);
                if(value != 0) {
                    index++;
                }
            }
            System.out.println();
        }

    }
}
