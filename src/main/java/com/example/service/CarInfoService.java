package com.example.service;

import com.example.pojo.CarInfo;

import java.util.List;

public interface CarInfoService {

    //2张表联合查询
    List<CarInfo> getInfo();

    //查询所有信息,为了把所有点标到地图上并显示各点信息
    List<CarInfo> getCarInfo();

    //由一个ID查到一个CarInfo
    CarInfo getById(Integer id);

    //查询车主的ID，姓名和车牌号，以列表展示
    List<CarInfo> getOwnerInfo();
}
