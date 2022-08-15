package com.test.main;

/**
 * @author gjf
 * @description 测试
 * @date 2022/8/15  15:51
 */
public class TestGP {

    public static void main(String[] args) {
        int[] arr = new int[]{7, 1, 5, 3, 6, 4,5};
        System.out.println(maxProfit(arr));
        System.out.println(maxProfit1(arr));
        System.out.println(maxProfit2(arr));
        System.out.println(getMax(arr));
    }

    public static int maxProfit(int[] prices) {
        // write code here
        if (prices.length == 0) {
            return 0;
        }
        /*
        5个状态：1）不操作2）第一次购买3）第一次卖出4）第二次购买5）第二次卖出
        dp[i][j]代表第i天状态为j时产生的最大收益
        */
        int[][] dp = new int[prices.length][5];
        //初始化
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = dp[i - 1][0];
            //其中dp[i][1]有两个操作1）第i天没有操作2）第i天买入股票，所以此时最大收益，应该为这两个操作比大小
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            //其中dp[i][2]有两个操作1）第i天没有操作2）第i天卖出股票，所以此时最大收益，应该为这两个操作比大小
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            //其中dp[i][3]有两个操作1）第i天没有操作2）第i天买入股票，所以此时最大收益，应该为这两个操作比大小
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            //其中dp[i][4]有两个操作1）第i天没有操作2）第i天卖出股票，所以此时最大收益，应该为这两个操作比大小
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return dp[prices.length - 1][4];

    }


    public static int maxProfit1(int[] prices) {

        /*
        五种状态
        1. 不做任何操作
        2. 第一次买入股票
        3，第一次售出股票
        4. 第二次买入
        5. 第二次售出
         */

        //第i天各状态最大利益
        int[][] gp = new int[prices.length][5];

        //初始化购买数据（买入为负数）
        gp[0][1] = -prices[0];
        gp[0][3] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            //第一天已经做初始化，要不购买，要不不购买，利益最大化

            //不做任何操作
            gp[i][0] = gp[i - 1][0];

            //其中dp[i][1]有两个操作 1）第i天没有操作 2）第i天买入股票，所以此时最大收益，应该为这两个操作比大小
            gp[i][1] = Math.max(gp[i - 1][1], gp[i - 1][0] - prices[i]);

            //其中dp[i][2]有两个操作 1）第i天没有操作 2）第i天买出股票，所以此时最大收益，应该为这两个操作比大小
            gp[i][2] = Math.max(gp[i - 1][2], gp[i - 1][1] + prices[i]);

            //其中dp[i][1]有两个操作 1）第i天没有操作 2）第i天买入股票，所以此时最大收益，应该为这两个操作比大小
            gp[i][3] = Math.max(gp[i - 1][3], gp[i - 1][2] - prices[i]);

            //其中dp[i][2]有两个操作 1）第i天没有操作 2）第i天买出股票，所以此时最大收益，应该为这两个操作比大小
            gp[i][4] = Math.max(gp[i - 1][4], gp[i - 1][3] + prices[i]);
        }


        return gp[prices.length - 1][4];
    }


    public static int maxProfit2(int[] prices) {

        /*
        3种状态
        1. 不做任何操作
        2. 第一次买入股票
        3，第一次售出股票
        */

        //第i天各状态最大利益
        int[][] gp = new int[prices.length][3];

        //初始化购买数据（买入为负数）
        gp[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            //第一天已经做初始化，要不购买，要不不购买，利益最大化

            //不做任何操作
            gp[i][0] = gp[i - 1][0];

            //其中dp[i][1]有两个操作 1）第i天没有操作 2）第i天买入股票，所以此时最大收益，应该为这两个操作比大小
            gp[i][1] = Math.max(gp[i - 1][1], gp[i - 1][0] - prices[i]);

            //其中dp[i][2]有两个操作 1）第i天没有操作 2）第i天买出股票，所以此时最大收益，应该为这两个操作比大小
            gp[i][2] = Math.max(gp[i - 1][2], gp[i - 1][1] + prices[i]);
        }


        return gp[prices.length - 1][2];
    }


    public static int getMax(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                max += prices[i] - prices[i-1];
            }
        }
        return max;
    }

}
