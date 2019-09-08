package com.example.serviceImpl;

import com.example.mapper.PointMapper;
import com.example.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PointServiceImpl implements PointService{

    @Autowired
    private PointMapper pointMapper;

    @Override
    public void addPoint(double lng, double lat) {

        pointMapper.addPoint(lng,lat);
    }
}
