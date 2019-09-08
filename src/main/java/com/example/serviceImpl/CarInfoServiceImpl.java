package com.example.serviceImpl;

import com.example.mapper.CarInfoMapper;
import com.example.pojo.CarInfo;
import com.example.service.CarInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarInfoServiceImpl implements CarInfoService {

    @Autowired
    CarInfoMapper carInfoMapper;

    //2张表联合查询
    @Override
    public List<CarInfo> getInfo() {
        return carInfoMapper.getInfo();
    }

    //查询所有信息,为了把所有点标到地图上并显示各点信息
    @Override
    public List<CarInfo> getCarInfo() {
        return carInfoMapper.getCarInfo();
    }

    //由一个ID查到一个CarInfo
    @Override
    public CarInfo getById(Integer id) {
        return carInfoMapper.getById(id);
    }

    //查询车主的ID，姓名和车牌号，以列表展示
    @Override
    public List<CarInfo> getOwnerInfo() {
        return carInfoMapper.getOwnerInfo();
    }
}
