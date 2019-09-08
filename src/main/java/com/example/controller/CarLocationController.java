package com.example.controller;

import com.example.pojo.Point;
import com.example.service.CarLocationService;
import com.example.serviceImpl.CarLocationServiceImpl;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/carLocation")
@CrossOrigin
public class CarLocationController {

    @Autowired
    private CarLocationService carLocationService;
    @Autowired
    private CarLocationServiceImpl carLocationServiceImpl;

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/sendCarLocation",method = RequestMethod.GET)
    public JSONArray getAllLocation(){
        List<Point> doubles = carLocationServiceImpl.getAllLocation();

        for (int i = 0; i <doubles.size() ; i++) {
            System.out.println(doubles.get(i).toString() );
        }

        System.out.println(doubles.size());

        JSONArray jsonArray = JSONArray.fromObject(doubles);
        System.out.println(jsonArray);
        return jsonArray;
    }


}
