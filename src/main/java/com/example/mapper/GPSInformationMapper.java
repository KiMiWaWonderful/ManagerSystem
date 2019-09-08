package com.example.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GPSInformationMapper {

    //增加json字符串
    @Insert("insert into t_gpsInformation(gpsInformationJson)values (#{gpsInformationJson})")
    void addGPSInformation(@Param("gpsInformationJson") String gpsInformationJson);
}
