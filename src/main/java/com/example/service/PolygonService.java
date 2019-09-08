package com.example.service;

import com.example.pojo.Point;
import com.example.pojo.Polygon;

import java.util.List;

public interface PolygonService {

    //增加
    void addPolygon(String polygonJson);

    //取出字符串

    //将取出的字符串进行解析，转换成list
    List<Point> convertJsonToList(String polygonJson);


    //将得到的list构造成Polygon
    public Polygon converListToPolygon(List<Point> points);

}
