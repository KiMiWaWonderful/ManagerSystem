package com.example.serviceImpl;

import com.example.mapper.CarLocationMapper;
import com.example.pojo.Point;
import com.example.service.CarLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarLocationServiceImpl implements CarLocationService {

    @Autowired
    private CarLocationMapper carLocationMapper;


    @Override
    public List<Point> getAllLocation() {
        return carLocationMapper.getAllLocation();
    }
}
