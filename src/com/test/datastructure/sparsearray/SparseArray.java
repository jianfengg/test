package com.test.datastructure.sparsearray;

import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

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

    public static void main(String[] args) throws IOException {
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

        //将稀疏数组持久化到磁盘中
        // 保存稀疏数组
        File file = new File("D:\\Project\\Projects\\test\\src\\com\\test\\resource\\file\\map.data");
        try {
            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter write = new OutputStreamWriter(fos, StandardCharsets.UTF_8);

            System.out.println("得到的稀疏数组为~~~");
            for (int i = 0; i < sparseArray.length; i++) {
                System.out.printf("%d\t%d\t%d\t\n", sparseArray[i][0], sparseArray[i][1], sparseArray[i][2]);

                if (i == sparseArray.length - 1) {
                    write.append(String.valueOf(sparseArray[i][0])).append(",").append(String.valueOf(sparseArray[i][1])).append(",").append(String.valueOf(sparseArray[i][2]));
                } else {
                    write.append(String.valueOf(sparseArray[i][0])).append(",").append(String.valueOf(sparseArray[i][1])).append(",").append(String.valueOf(sparseArray[i][2])).append(",");
                }
            }

            System.out.println("写入文件中...");
            write.close();
            fos.close();

            System.out.println("打开文件中...");
            Desktop.getDesktop().open(file);

            System.out.println("------------------------------先读取_map.data");
            // 创建 FileReader 对象
            FileInputStream fis = new FileInputStream(file);

            InputStreamReader reader = new InputStreamReader(fis, StandardCharsets.UTF_8);
            StringBuilder sb = new StringBuilder();
            while (reader.ready()) {
                // 转成char加到StringBuffer对象中
                sb.append((char) reader.read());
            }

            System.out.println(sb.toString());
            reader.close();// 关闭读取流
            fis.close();// 关闭输入流,释放系统资源

            System.out.println("------------------------------恢复成稀疏数组_sparseArrHf");
            // 2.创建对应的稀疏数组
            String[] str = sb.toString().split(",");
            int[][] sparseArrHf = new int[str.length / 3][3];
            // 给稀疏数组赋值
            int serial = 0;
            for (String s : str) {
                sparseArrHf[(serial - (serial % 3)) / 3][serial % 3] = Integer.parseInt(s);
                serial++;
            }

            //将稀疏数组还原成普通数组
            //获取二维数据的大小
            int[][] oldArray = new int[sparseArrHf[0][0]][sparseArrHf[0][1]];
            for (int i = 1; i < sparseArrHf.length; i++) {
                oldArray[sparseArrHf[i][0]][sparseArrHf[i][1]] = sparseArrHf[i][2];
            }

            //恢复后的二维数组
            System.out.println("恢复后的二维数组：");
            for (int[] srow : oldArray) {
                for (int value : srow) {
                    System.out.printf("%d\t",value);
                    if(value != 0) {
                        index++;
                    }
                }
                System.out.println();
            }
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }
}
