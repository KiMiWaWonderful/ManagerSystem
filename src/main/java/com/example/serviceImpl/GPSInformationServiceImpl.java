package com.example.serviceImpl;

import com.example.mapper.GPSInformationMapper;
import com.example.service.GPSInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GPSInformationServiceImpl implements GPSInformationService {

    @Autowired
    private GPSInformationMapper gpsInformationMapper;
    @Override
    public void addGPSInformation(String gpsInformationJson) {
        gpsInformationMapper.addGPSInformation(gpsInformationJson);


    }
}
