package com.test.base.stream;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.openservices.shade.org.apache.commons.lang3.StringUtils;
import com.test.common.utils.GaodeMapUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author gjf
 * @description 线路轨迹调整
 * @date 2021/9/7  10:22
 */
public class LineAdjustFileRead {

    private static final String PATH_20210907 = "F:\\work\\日常数据处理解决方案\\观光巴士\\黄线轨迹调整\\黄线路径";
    private static final String PATH_20210913 = "F:\\work\\日常数据处理解决方案\\观光巴士\\黄线轨迹调整\\2021-09-13\\最新轨迹.txt";
    private static final String RED_PATH_20210913 = "F:\\work\\日常数据处理解决方案\\观光巴士\\红线轨迹调整\\2021-09-13\\修改后-b端.txt";
    private static final String YELLOW_PATH_20210915 = "F:\\work\\日常数据处理解决方案\\观光巴士\\黄线轨迹调整\\2020-09-15\\最新B端轨迹.txt";
    private static final String YELLOW_PATH_20210917 = "F:\\work\\日常数据处理解决方案\\观光巴士\\黄线轨迹调整\\2020-09-17\\最新B端轨迹.txt";
    private static final String RED_PATH_20210915 = "F:\\work\\日常数据处理解决方案\\观光巴士\\红线轨迹调整\\2020-09-15\\最新B端轨迹.txt";
    private static final String RED_PATH_20210916 = "F:\\work\\日常数据处理解决方案\\观光巴士\\红线轨迹调整\\2020-09-16\\最新B端轨迹.txt";
    private static final String BLUE_PATH_20210916 = "F:\\work\\日常数据处理解决方案\\观光巴士\\蓝线轨迹调整\\2020-09-16\\最新B端轨迹.txt";
    private static final String CX_PATH_20210917 = "F:\\work\\日常数据处理解决方案\\观光巴士\\橙线轨迹调整\\2020-09-17\\橙线初始化B端轨迹.txt";
    private static final String TEST = "F:\\work\\日常数据处理解决方案\\测试坐标.txt";
    private static final String TEST_1 = "F:\\work\\日常数据处理解决方案\\1.txt";

    public static void main(String[] args) throws IOException {
//        File file = new File(PATH);
//        File file = new File(PATH_20210913);
//        convertC(TEST_1);
       /* double[] doubles = GaodeMapUtil.wgs2gcj(22.5405257, 113.9666019);
        System.out.println(doubles[0]);
        System.out.println(doubles[1]);*/
//        convertB(CX_PATH_20210917);
        convertBd(22.533622,114.012808,"珠子");
      /*  convert(22.5361441,113.9833306,"锦绣中华（锦绣中华①）");
        convert(22.5244106,113.987293,"欢乐海岸（深圳湾公园地铁站E出口）");
        convert(22.5305265,113.9496405,"大沙河生态长廊");
        convert(22.543369,113.9469315,"万象天地（大冲①）");
        convert(22.5436233,113.9154558,"南头古城（新安古城）");
        convert(22.5570628,113.8815705,"壹方城（宝安中心站②）");
        convert(22.5527518,113.8775531,"宝安图书馆（宝安图书馆①）");
        convert(22.5466723,113.881722,"欢乐港湾");
        convert(22.5423994,113.9356636,"深圳大学（深大北门①）");*/
    }

    public static void convertB(String path) throws IOException{
        File file = new File(path);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder sb = new StringBuilder();
        String str = "";
        boolean loop = true;
        while(loop) {
            String line = reader.readLine();
            if (line == null) {
                reader.close();
                str = sb.toString();
                loop = false;
            }
            sb.append(line).append("\r\n");
        }
        System.out.println(str);
        JSONArray array = JSONObject.parseArray(str);
        StringBuilder wgsBuilder = new StringBuilder();
        StringBuilder gdBuilder = new StringBuilder();
        for (Object o : array) {
            JSONObject jsonObject = JSONObject.parseObject(o.toString());
            double lat = jsonObject.getDouble("lat");
            double lng = jsonObject.getDouble("lng");
            wgsBuilder.append(lng).append(",").append(lat).append(";");
            double[] doubles = GaodeMapUtil.wgs2gcj(lat, lng);
            lat = doubles[0];
            lng = doubles[1];
            gdBuilder.append(lng).append(",").append(lat).append(";");
        }
        System.out.print("转前：");
        System.out.println(wgsBuilder.toString());
        System.out.print("转后：");
        System.out.println(gdBuilder.toString());
    }


    public static void convertC(String path) throws IOException{
        File file = new File(path);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder sb = new StringBuilder();
        String str = "";
        boolean loop = true;
        while(loop) {
            String line = reader.readLine();
            if (line == null) {
                reader.close();
                str = sb.toString();
                loop = false;
            }
            sb.append(line).append("\r\n");
        }
        System.out.println(str);
        String[] split = str.split(";");
        StringBuilder wgsBuilder = new StringBuilder();
        StringBuilder gdBuilder = new StringBuilder();
        for (String o : split) {
            if(StringUtils.isBlank(o)) {
                break;
            }
            String[] strings = o.split(",");
            double lat = Double.parseDouble(strings[0]);
            double lng = Double.parseDouble(strings[1]);
            wgsBuilder.append(lng).append(",").append(lat).append(";");
            double[] doubles = GaodeMapUtil.wgs2gcj(lat, lng);
            lng = doubles[1];
            lat = doubles[0];
            gdBuilder.append(lng).append(",").append(lat).append(";");
        }
        System.out.print("转前：");
        System.out.println(wgsBuilder.toString());
        System.out.print("转后：");
        System.out.println(gdBuilder.toString());
    }

    public static void convertGd(double lat, double lng, String stopName) {
        StringBuilder gdBuilder = new StringBuilder();
        double[] doubles = GaodeMapUtil.wgs2gcj(lat, lng);
        lat = doubles[0];
        lng = doubles[1];
        gdBuilder.append("stopName: ").append(stopName).append("    ").
                append(lng).append(" ,  ").append(lat);
        System.out.println(gdBuilder.toString());
    }

    public static void convertBd(double lat, double lng, String stopName) {
        StringBuilder gdBuilder = new StringBuilder();
        double[] doubles = GaodeMapUtil.wgs2bd(lat, lng);
        lat = doubles[0];
        lng = doubles[1];
        gdBuilder.append("stopName: ").append(stopName).append("    ").
                append(lng).append(" ,  ").append(lat);
        System.out.println(gdBuilder.toString());

    }


}
