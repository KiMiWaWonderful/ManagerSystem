package com.example.pojo;

public class GPSInformation {

    private char location_status;  //(2) 定位状态，A=有效定位，V=无效定位

    private double latitude; //(3) 纬度 ddmm.mmmmm（度分）
    private int latitudeDegree; //纬度的度
    private int latitudeCent; //纬度的分
    private int latitudeSecond; //纬度的秒
    private double lat; //精确的纬度

    private  char NS; //(4) 纬度半球 N（北半球）或 S（南半球）

    private double longitude;   //(5) 经度 dddmm.mmmmm（度分）
    private int longitudeDegree; //经度的度
    private  int longitudeCent; //经度的分
    private int longitudeSecond; //经度的秒
    private double lng; //精确的经度


    private char EW;  //(6) 经度半球 E（东经）或 W（西经）
    private double speed;    //(7) 地面速率（000.0~999.9 节）
    private  double direction;    //(8) 地面航向（000.0~359.9 度，以真北方为参考基准）

    private double baiduLat;
    private double baiduLng;

    private DateTime dateTime;

    public GPSInformation(char location_status, double latitude, int latitudeDegree, int latitudeCent, int latitudeSecond, double lat, char NS, double longitude, int longitudeDegree, int longitudeCent, int longitudeSecond, double lng, char EW, double speed, double direction, double baiduLat, double baiduLng, DateTime dateTime) {
        this.location_status = location_status;
        this.latitude = latitude;
        this.latitudeDegree = latitudeDegree;
        this.latitudeCent = latitudeCent;
        this.latitudeSecond = latitudeSecond;
        this.lat = lat;
        this.NS = NS;
        this.longitude = longitude;
        this.longitudeDegree = longitudeDegree;
        this.longitudeCent = longitudeCent;
        this.longitudeSecond = longitudeSecond;
        this.lng = lng;
        this.EW = EW;
        this.speed = speed;
        this.direction = direction;
        this.baiduLat = baiduLat;
        this.baiduLng = baiduLng;
        this.dateTime = dateTime;
    }

    public GPSInformation() {
    }

    @Override
    public String toString() {
        return "GPSInformation{" +
                "location_status=" + location_status +
                ", latitude=" + latitude +
                ", latitudeDegree=" + latitudeDegree +
                ", latitudeCent=" + latitudeCent +
                ", latitudeSecond=" + latitudeSecond +
                ", lat=" + lat +
                ", NS=" + NS +
                ", longitude=" + longitude +
                ", longitudeDegree=" + longitudeDegree +
                ", longitudeCent=" + longitudeCent +
                ", longitudeSecond=" + longitudeSecond +
                ", lng=" + lng +
                ", EW=" + EW +
                ", speed=" + speed +
                ", direction=" + direction +
                ", baiduLat=" + baiduLat +
                ", baiduLng=" + baiduLng +
                ", dateTime=" + dateTime +
                '}';
    }

    public char getLocation_status() {
        return location_status;
    }

    public void setLocation_status(char location_status) {
        this.location_status = location_status;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public int getLatitudeDegree() {
        return latitudeDegree;
    }

    public void setLatitudeDegree(int latitudeDegree) {
        this.latitudeDegree = latitudeDegree;
    }

    public int getLatitudeCent() {
        return latitudeCent;
    }

    public void setLatitudeCent(int latitudeCent) {
        this.latitudeCent = latitudeCent;
    }

    public int getLatitudeSecond() {
        return latitudeSecond;
    }

    public void setLatitudeSecond(int latitudeSecond) {
        this.latitudeSecond = latitudeSecond;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public char getNS() {
        return NS;
    }

    public void setNS(char NS) {
        this.NS = NS;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getLongitudeDegree() {
        return longitudeDegree;
    }

    public void setLongitudeDegree(int longitudeDegree) {
        this.longitudeDegree = longitudeDegree;
    }

    public int getLongitudeCent() {
        return longitudeCent;
    }

    public void setLongitudeCent(int longitudeCent) {
        this.longitudeCent = longitudeCent;
    }

    public int getLongitudeSecond() {
        return longitudeSecond;
    }

    public void setLongitudeSecond(int longitudeSecond) {
        this.longitudeSecond = longitudeSecond;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public char getEW() {
        return EW;
    }

    public void setEW(char EW) {
        this.EW = EW;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }

    public double getBaiduLat() {
        return baiduLat;
    }

    public void setBaiduLat(double baiduLat) {
        this.baiduLat = baiduLat;
    }

    public double getBaiduLng() {
        return baiduLng;
    }

    public void setBaiduLng(double baiduLng) {
        this.baiduLng = baiduLng;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }
}
