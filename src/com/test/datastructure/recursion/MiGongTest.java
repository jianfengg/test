package com.test.datastructure.recursion;

/**
 * @Description: 迷宫回溯
 * @Copyright: Copyright (c) 2021  ALL RIGHTS RESERVED.
 * @Company:
 * @Author: gjf
 * @CreateDate: 2021/5/14 16:58
 * @UpdateDate: 2021/5/14 16:58
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
public class MiGongTest {

    public static void main(String[] args) {
        int[][] map = getMap();
        System.out.println("设置后初始地图：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        setWay(map,1,1);
        System.out.println("结果地图：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }


    /**
     * 获取初始地图
     * 0：未走过的格子
     * 1：墙
     * 2：允许通行
     * 3：不允许通行
     * @return 初始地图
     */
    public static int[][] getMap() {
        int[][] map = new int[8][7];
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int j = 0; j < 8; j++) {
            map[j][0] = 1;
            map[j][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;
        return map;
    }

    /**
     * @param map 二维数组的地图
     * @param x   横向起始坐标
     * @param y   纵向起始坐标
     * @return 找到走的路
     */
    public static boolean setWay(int[][] map, int x, int y) {
        if(map[6][5] == 2) {
            return true;
        }
        if (map[x][y] == 0) {
            map[x][y] = 2;
            if (setWay(map, x + 1, y)) {
                return true;
            } else if (setWay(map, x, y + 1)) {
                return true;
            } else if (setWay(map, x - 1, y)) {
                return true;
            } else if (setWay(map, x, y - 1)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
