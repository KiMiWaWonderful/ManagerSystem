package com.example.service;

//@Mapper
public interface PointService {

//    //增加
//    @Insert("insert into t_point(longitude,latitude)values (#{longitude},#{latitude})")
//    void addPoint(double longitude,double latitude);

    //增加
    void addPoint(double lng,double lat);




}
