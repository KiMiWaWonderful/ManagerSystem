package com.example.serviceImpl;

import com.example.mapper.PolygonMapper;
import com.example.pojo.Point;
import com.example.pojo.Polygon;
import com.example.service.PolygonService;
import com.example.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolygonServiceImpl implements PolygonService{

    @Autowired
    private PolygonMapper polygonMapper;

    //增加
    @Override
    public void addPolygon(String polygonJson) {

        polygonMapper.addPolygon(polygonJson);
    }

    //将取出的字符串进行解析，转换成list
    @Override
    public List<Point> convertJsonToList(String polygonJson) {

        List<Point> points = JsonUtils.jsonToList(polygonJson,Point.class);
        return points;
    }

    //将得到的list构造成Polygon
    @Override
    public Polygon converListToPolygon(List<Point> points) {
        Polygon polygon = new Polygon(points);
        return polygon;
    }
}
