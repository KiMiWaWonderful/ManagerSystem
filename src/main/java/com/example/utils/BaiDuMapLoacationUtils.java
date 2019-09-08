package com.example.utils;

public class BaiDuMapLoacationUtils {

    //double pi = 3.14159265358979324;
    static double pi = 3.14159265358979324;
    static double x_pi = 3.14159265358979324 * 3000.0 / 180.0;

    static double a = 6378245.0;
    static double ee = 0.00669342162296594323;

    public static boolean outOfChina(double lat, double lon){

        if (lon < 72.004 || lon > 137.8347)
            return true;
        if (lat < 0.8293 || lat > 55.8271)
            return true;
        return false;
    }

    public static double transformLat(double x, double y) {
        double ret = -100.0 + 2.0 * x + 3.0 * y + 0.2 * y * y + 0.1 * x * y + 0.2 * Math.sqrt(Math.abs(x));
        ret += (20.0 * Math.sin(6.0 * x * pi) + 20.0 * Math.sin(2.0 * x * pi)) * 2.0 / 3.0;
        ret += (20.0 * Math.sin(y * pi) + 40.0 * Math.sin(y / 3.0 * pi)) * 2.0 / 3.0;
        ret += (160.0 * Math.sin(y / 12.0 * pi) + 320 * Math.sin(y * pi / 30.0)) * 2.0 / 3.0;
        return ret;
    }

    public static double transformLon(double x, double y) {
        double ret = 300.0 + x + 2.0 * y + 0.1 * x * x + 0.1 * x * y + 0.1 * Math.sqrt(Math.abs(x));
        ret += (20.0 * Math.sin(6.0 * x * pi) + 20.0 * Math.sin(2.0 * x * pi)) * 2.0 / 3.0;
        ret += (20.0 * Math.sin(x * pi) + 40.0 * Math.sin(x / 3.0 * pi)) * 2.0 / 3.0;
        ret += (150.0 * Math.sin(x / 12.0 * pi) + 300.0 * Math.sin(x / 30.0 * pi)) * 2.0 / 3.0;
        return ret;
    }

    /*
参数
wgLat:WGS-84纬度 wgLon:WGS-84经度
返回值：
mgLat：GCJ-02纬度 mgLon：GCJ-02经度
*/
    //返回double数组
    public static double[] gps_transform( double wgLat, double wgLon) {
        double mgLat;
        double mgLon;

        if (outOfChina(wgLat, wgLon)) {
            mgLat = wgLat;
            mgLon = wgLon;
            //  catchException();
            return null;
        }
        double dLat = transformLat(wgLon - 105.0, wgLat - 35.0);
        double dLon = transformLon(wgLon - 105.0, wgLat - 35.0);
        double radLat = wgLat / 180.0 * pi;
        double magic = Math.sin(radLat);
        magic = 1 - ee * magic * magic;
        double sqrtMagic = Math.sqrt(magic);
        dLat = (dLat * 180.0) / ((a * (1 - ee)) / (magic * sqrtMagic) * pi);
        dLon = (dLon * 180.0) / (a / sqrtMagic * Math.cos(radLat) * pi);
        mgLat = wgLat + dLat;
        mgLon = wgLon + dLon;
        double[] doubles = new double[]{mgLat,mgLon};
        return doubles;
    }

    //将 GCJ-02 坐标转换成 BD-09 坐标
    //返回转换后的坐标，装进数组
    public static double[] bd_encrypt(double gg_lat, double gg_lon)
    {
        double bd_lat;
        double bd_lon;
        double x = gg_lon, y = gg_lat;
        double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * x_pi);
        double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * x_pi);
        bd_lon = z * Math.cos(theta) + 0.0065;
        bd_lat = z * Math.sin(theta) + 0.006;
        double[] doubles = new double[]{bd_lat,bd_lon};
        return doubles;
    }

    //返回转换后的坐标，装进数组
    public static double[] bd_decrypt(double bd_lat, double bd_lon)
    {
        double gg_lat;
        double gg_lon;
        double x = bd_lon - 0.0065, y = bd_lat - 0.006;
        double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * x_pi);
        double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * x_pi);
        gg_lon = z * Math.cos(theta);
        gg_lat = z * Math.sin(theta);
        double[] doubles = new double[]{gg_lat,gg_lon};
        return doubles;
    }

    //返回百度地图的坐标，装进数组
    //纬度：0，经度：1
    public static double[] get_location(double GPS_lat,double GPS_lon)
    {
        double mgLat,mgLon;
        double[] doubleMg = gps_transform(GPS_lat,GPS_lon);
        if(doubleMg == null){
            // catchException();
            return null;
        }

        double[] baiDuZuoBiao = bd_encrypt(doubleMg[0],doubleMg[1]);
        return baiDuZuoBiao;
        // gps_transform(GPS_lat,GPS_lon,mgLat,mgLon);

        // bd_encrypt(mgLat,mgLon,BaiDu_lat,BaiDu_lon);
    }

    //处理异常函数
//    public static String catchException(){
//        return "发生错误！";
//    }
}
