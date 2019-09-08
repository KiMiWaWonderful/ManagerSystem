package com.example.pojo;

import java.util.List;

public class CarLocation {

    //电动车编号
   // private Integer num;
    //经度
//    private double lng;
//    //纬度
//    private double lat;

   // List<CarLocation> carLocations;

    List<Point> carLocations;
    List<CarInfo> carInfos;

//    public CarLocation(Integer num, double lng, double lat) {
//        this.num = num;
//        this.lng = lng;
//        this.lat = lat;
//    }

    public CarLocation() {
    }

    public CarLocation(List<Point> carLocations, List<CarInfo> carInfos) {
        this.carLocations = carLocations;
        this.carInfos = carInfos;
    }

    public List<CarInfo> getCarInfos() {
        return carInfos;
    }

    public void setCarInfos(List<CarInfo> carInfos) {
        this.carInfos = carInfos;
    }

//    public CarLocation(Integer num, double lng, double lat, List<Point> carLocations) {
//        this.num = num;
//        this.lng = lng;
//        this.lat = lat;
//        this.carLocations = carLocations;
//    }

    //    public CarLocation(Integer num, double lng, double lat, List<CarLocation> carLocations) {
//        this.num = num;
//        this.lng = lng;
//        this.lat = lat;
//        this.carLocations = carLocations;
//    }
//
//    public List<CarLocation> getCarLocations() {
//        return carLocations;
//    }
//
//    public void setCarLocations(List<CarLocation> carLocations) {
//        this.carLocations = carLocations;
//    }


    public List<Point> getCarLocations() {
        return carLocations;
    }

    public void setCarLocations(List<Point> carLocations) {
        this.carLocations = carLocations;
    }

    @Override
    public String toString() {
        return "CarLocation{" +
                "carLocations=" + carLocations +
                ", carInfos=" + carInfos +
                '}';
    }


//    public Integer getNum() {
//        return num;
//    }
//
//    public void setNum(Integer num) {
//        this.num = num;
//    }

//    public double getLng() {
//        return lng;
//    }
//
//    public void setLng(double lng) {
//        this.lng = lng;
//    }
//
//    public double getLat() {
//        return lat;
//    }
//
//    public void setLat(double lat) {
//        this.lat = lat;
//    }
//
//    @Override
//    public String toString() {
//        return "CarLocation{" +
//                "lng=" + lng +
//                ", lat=" + lat +
//                '}';
//    }
}
