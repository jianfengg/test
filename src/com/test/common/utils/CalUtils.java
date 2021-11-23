package com.test.common.utils;

/**
 * @author gjf
 * @description 计算公式
 * @date 2021/8/25  09:17
 */
public class CalUtils {

    /**
     * 地球半径（单位：千米）
     */
    private static double EARTH_RADIUS = 6378.137;

    public static double getDistance(double lat1, double lng1, double lat2, double lng2) {
        double radLat1 = deg2rad(lat1);
        double radLat2 = deg2rad(lat2);
        double a = radLat1 - radLat2;
        double b = deg2rad(lng1) - deg2rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a / 2), 2) +
                Math.cos(radLat1) * Math.cos(radLat2) * Math.pow(Math.sin(b / 2), 2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000000) / 10000; // 将千米转成米

        return s;
    }

    /**
     * 将角度转成弧度
     *
     * @param degree 角度数
     * @return 弧度数
     */
    public static double deg2rad(double degree) {//  radian  degree
        //角度转弧度： B = A /180 * pi;
        return (degree * Math.PI / 180.0f);

    }

    public static void main(String[] args) {
//lng=114.03211212158203&lat=22.534719467163086
        // 当前位置
        double dtlat =  29.315324  ;
        double dtlng =  120.109716  ;

        //位置1
        double lat1 = 22.534042;
        double lng1 = 114.028539;

        //位置2 天安数码城
        double lat2 = 22.533225757;
        double lng2 = 114.029459329;

        Double distance = getDistance(dtlat, dtlng, lat1, lng1);
        Double distance1 = getDistance(dtlat, dtlng, lat2, lng2);
        Double distance2 = getDistance(lat2, lng2, dtlat, dtlng);
        System.out.println(distance.longValue());
        System.out.println(distance1.longValue());
        System.out.println(distance2.longValue());
    }

}
