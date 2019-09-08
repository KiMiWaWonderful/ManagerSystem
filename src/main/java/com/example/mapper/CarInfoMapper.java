package com.example.mapper;

import com.example.pojo.CarInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CarInfoMapper {

    //2张表联合查询
    @Select("select t_carinfo.num,t_carinfo.name,t_carinfo.number from t_carinfo inner join t_carlocation on t_carinfo.num = t_carlocation.num")
    List<CarInfo> getInfo();

    //查询所有信息,为了把所有点标到地图上并显示各点信息
    @Select("select lng,lat,id,name,number from t_carlocation")
    List<CarInfo> getCarInfo();

    //由一个ID查到一个CarInfo
    @Select("select lng,lat,id,name,number from t_carlocation where id = #{id}")
    CarInfo getById(@Param("id")Integer id);

    //查询车主的ID，姓名和车牌号，以列表展示
    @Select("select id,name,number from t_carlocation")
    List<CarInfo> getOwnerInfo();



}
