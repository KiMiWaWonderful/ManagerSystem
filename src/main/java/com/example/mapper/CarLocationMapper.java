package com.example.mapper;

import com.example.pojo.Point;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CarLocationMapper {

    @Select("select lng,lat from t_carlocation")
     List<Point> getAllLocation();
}
