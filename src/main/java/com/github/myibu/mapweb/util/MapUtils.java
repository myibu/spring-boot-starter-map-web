package com.github.myibu.mapweb.util;

import com.github.myibu.mapweb.common.entity.GpsLocation;

/**
 * 地图工具
 * @author hdh
 * Created on 2022/9/15
 */
public class MapUtils {
    private MapUtils() {}

    /**
     * 计算2个gps间距离，单位为KM
     * @param gps1 gps1
     * @param gps2 gps2
     * @return KM距离
     */
    public static double calculateKMDistanceBetweenTwoGps(GpsLocation gps1, GpsLocation gps2) {
        double lat1 = gps1.getLat(), lng1 = gps1.getLng(), lat2 = gps2.getLat(), lng2 = gps2.getLng();
        double EARTH_RADIUS = 6378.137;
        double radLat1 = rad(lat1);
        double radLat2 = rad(lat2);
        double a = radLat1 - radLat2;
        double b = rad(lng1) - rad(lng2);
        double s = 2 * Math.asin(Math.sqrt(Math.pow(Math.sin(a/2),2) +
                Math.cos(radLat1)*Math.cos(radLat2)*Math.pow(Math.sin(b/2),2)));
        s = s * EARTH_RADIUS;
        s = Math.round(s * 10000) / 10000.0;
        return s;
    }

    private static double rad(double d) {
        return d * Math.PI / 180.0;
    }
}
