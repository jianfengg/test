package com.test.common.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 王奕
 */
public class GaodeMapUtil {

	static double pi = 3.14159265358979324;
	static double a = 6378245.0;
	static double ee = 0.00669342162296594323;
	static double earthRadius=6371;
	
	public static String leftTopPoint="leftTopPoint";
	public static String rightTopPoint="rightTopPoint";
	public static String leftBottomPoint="leftBottomPoint";
	public static String rightBottomPoint="rightBottomPoint";

	public final static double x_pi = 3.14159265358979324 * 3000.0 / 180.0;

	public static double[] wgs2bd(double lat, double lon) {
		double[] wgs2gcj = wgs2gcj(lat, lon);
		double[] gcj2bd = gcj2bd(wgs2gcj[0], wgs2gcj[1]);
		return gcj2bd;
	}

	public static double[] gcj2bd(double lat, double lon) {
		double x = lon, y = lat;
		double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * x_pi);
		double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * x_pi);
		double bd_lon = z * Math.cos(theta) + 0.0065;
		double bd_lat = z * Math.sin(theta) + 0.006;
		return new double[] { bd_lat, bd_lon };
	}

	public static double[] bd2gcj(double lat, double lon) {
		double x = lon - 0.0065, y = lat - 0.006;
		double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * x_pi);
		double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * x_pi);
		double gg_lon = z * Math.cos(theta);
		double gg_lat = z * Math.sin(theta);
		return new double[] { gg_lat, gg_lon };
	}

	public static double[] wgs2gcj(double lat, double lon) {
		double dLat = transformLat(lon - 105.0, lat - 35.0);
		double dLon = transformLon(lon - 105.0, lat - 35.0);
		double radLat = lat / 180.0 * pi;
		double magic = Math.sin(radLat);
		magic = 1 - ee * magic * magic;
		double sqrtMagic = Math.sqrt(magic);
		dLat = (dLat * 180.0) / ((a * (1 - ee)) / (magic * sqrtMagic) * pi);
		dLon = (dLon * 180.0) / (a / sqrtMagic * Math.cos(radLat) * pi);
		double mgLat = lat + dLat;
		double mgLon = lon + dLon;
		double[] loc = { mgLat, mgLon };
		return loc;
	}

	private static double transformLat(double lat, double lon) {
		double ret = -100.0 + 2.0 * lat + 3.0 * lon + 0.2 * lon * lon + 0.1
				* lat * lon + 0.2 * Math.sqrt(Math.abs(lat));
		ret += (20.0 * Math.sin(6.0 * lat * pi) + 20.0 * Math.sin(2.0 * lat * pi)) * 2.0 / 3.0;
		ret += (20.0 * Math.sin(lon * pi) + 40.0 * Math.sin(lon / 3.0 * pi)) * 2.0 / 3.0;
		ret += (160.0 * Math.sin(lon / 12.0 * pi) + 320 * Math.sin(lon * pi
				/ 30.0)) * 2.0 / 3.0;
		return ret;
	}

	private static double transformLon(double lat, double lon) {
		double ret = 300.0 + lat + 2.0 * lon + 0.1 * lat * lat + 0.1 * lat
				* lon + 0.1 * Math.sqrt(Math.abs(lat));
		ret += (20.0 * Math.sin(6.0 * lat * pi) + 20.0 * Math.sin(2.0 * lat
				* pi)) * 2.0 / 3.0;
		ret += (20.0 * Math.sin(lat * pi) + 40.0 * Math.sin(lat / 3.0 * pi)) * 2.0 / 3.0;
		ret += (150.0 * Math.sin(lat / 12.0 * pi) + 300.0 * Math.sin(lat / 30.0
				* pi)) * 2.0 / 3.0;
		return ret;
	}
	
	/**
	 * 计算经纬度点对应正方形4个点的坐标 
	 * @param longitude 经度
	 * @param latitude 纬度
	 * @param distance 千米
	 * @return
	 */
	public static Map<String, double[]> returnLLSquarePoint(double longitude,
			double latitude, double distance) {
		Map<String, double[]> squareMap = new HashMap<String, double[]>();
		// 计算经度弧度,从弧度转换为角度
		double dLongitude = 2 * (Math.asin(Math.sin(distance
				/ (2 * earthRadius))
				/ Math.cos(Math.toRadians(latitude))));
		dLongitude = Math.toDegrees(dLongitude);
		// 计算纬度角度
		double dLatitude = distance / earthRadius;
		dLatitude = Math.toDegrees(dLatitude);
		// 正方形
		double[] leftTopPoint = { latitude + dLatitude, longitude - dLongitude };
		double[] rightTopPoint = { latitude + dLatitude, longitude + dLongitude };
		double[] leftBottomPoint = { latitude - dLatitude,
				longitude - dLongitude };
		double[] rightBottomPoint = { latitude - dLatitude,
				longitude + dLongitude };
		squareMap.put(GaodeMapUtil.leftTopPoint, leftTopPoint);
		squareMap.put(GaodeMapUtil.rightTopPoint, rightTopPoint);
		squareMap.put(GaodeMapUtil.leftBottomPoint, leftBottomPoint);
		squareMap.put(GaodeMapUtil.rightBottomPoint, rightBottomPoint);
		return squareMap;
	}
	
}
