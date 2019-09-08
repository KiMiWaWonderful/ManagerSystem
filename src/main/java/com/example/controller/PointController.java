package com.example.controller;

import com.example.service.PointService;
import com.example.serviceImpl.PointServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/point")
@CrossOrigin
public class PointController {

    @Autowired
    private PointService pointService;
    @Autowired
    private PointServiceImpl pointServiceImpl;

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/addPoint",method = RequestMethod.POST)
    public void addPoint(@RequestParam(value = "lng") double lng, @RequestParam(value = "lat") double lat){
      //  pointService.addPoint(longitude,latitude);
        pointServiceImpl.addPoint(lng,lat);
    }


}
