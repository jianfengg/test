package com.test.main;

/**
 * @Description:
 * @Copyright: Copyright (c) 2021  ALL RIGHTS RESERVED.
 * @Company:
 * @Author: gjf
 * @CreateDate: 2021/5/25 9:15
 * @UpdateDate: 2021/5/25 9:15
 * @UpdateRemark: init
 * @Version: 1.0
 * @menu
 */
public class Heart {

    public static void main(String[] args) {

        //12 29 17 8 9 8 + 12 + 9
        int n = 4;

        String loveStr = " I Love You ";

        int i, j, m;

        for (i = 1; i <= n; i++) {
            int index = 0;
            for (j = 1; j <= 2 * (n - i) - 1; j++) {
                System.out.print(" ");
                index ++;

            }

            for (j = 1; j <= 6 + (10 - i) * (i - 1) / 2; j++) {
//                System.out.println("index:" + index);
                if( index > 8 && index < 21 && i == 4) {
                    System.out.print(" ");
                } else {
                    System.out.print("*");
                }
                index ++;
            }

            for (j = 1; j <= 2 * n - 1 + (i - 6) * (i - 1); j++) {
                if (i == n) {
                    break;
                }


                System.out.print(" ");
                index ++;

            }
            for (j = 1; j <= 6 + (10 - i) * (i - 1) / 2; j++) {
                if (i == n) {
                    break;

                }
                System.out.print("*");
                index ++;

            }

            if (i == n) {
                for (j = 1; j <= 6 + (10 - i) * (i - 1) / 2 ; j++) {
                    if( index > 8 && index < 21) {
                        System.out.print(" ");
                    } else {
                        System.out.print("*");
                    }
                    index ++;
                }

            }

            System.out.println("");

        } // 上面部分
        // 6 + (10-4) * (4-1) / 2 - 1 + 6 + (10-4) * (4-1) / 2
        //29 - 12 = 17
        // 12
        //int length = 6 + (10 - n) * (n - 1) / 2  + 6 + (10 - n) * (n - 1) / 2;
        int length = 6 + (10 - n) * (n - 1) / 2  + 6 + (10 - n) * (n - 1) / 2;
        boolean console = true;
        for (i = 1; i <= n - 2; i++) {
            int index = 0;
            for (j = 1; j <= length; j++) {
                if( index > 8 && index < 21) {
                    if(i == 1 && console) {
                        System.out.print(loveStr);
                        console = false;
                    } else if(i != 1){
                        System.out.print(" ");
                    }
                } else {
                    System.out.print("*");
                }
                index ++;
            }

            System.out.println("");

        } // 中间部分

        m = length - 1;




        for (i = 1; i <= (m - 2 - 3) / 4 + 1; i++) {
            for (j = 1; j <= 2 * i - 1; j++) {
                System.out.print(" ");

            }

            for (j = 1; j <= m + 2 - 4 * i; j++) {
                System.out.print("*");

            }

            System.out.println("");

        }

        for (j = 1; j <= 2 * ((m - 2 - 3) / 4 + 1); j++) {
            System.out.print(" ");

        }

        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
