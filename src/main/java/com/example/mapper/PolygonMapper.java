package com.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PolygonMapper {

    //增加json字符串
    @Insert("insert into t_polygon(polygonJson)values (#{polygonJson})")
    void addPolygon(@Param("polygonJson") String polygonJson);
}
