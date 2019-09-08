package com.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PointMapper {

    //增加
    @Insert("insert into t_point(lng,lat)values (#{lng},#{lat})")
    void addPoint(@Param("lng") double lng, @Param("lat") double lat);

}
