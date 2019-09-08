package com.example.controller;

import com.example.service.PolygonService;
import com.example.serviceImpl.PolygonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/polygon")
@CrossOrigin
public class PolygonController {

    @Autowired
    private PolygonService polygonService;
    @Autowired
    private PolygonServiceImpl polygonServiceImpl;

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/addPolygon",method = RequestMethod.POST)
    public void addPolygon(@RequestParam(value = "polygonJson") String polygonJson){

        polygonServiceImpl.addPolygon(polygonJson);
        //  pointService.addPoint(longitude,latitude);
//        System.out.println(polygon);
//
//        List<Point> points = JsonUtils.jsonToList(polygon,Point.class);
//
//        for (int i = 0; i<points.size();i++){
//            System.out.print(points.get(i) +" ");
//        }
//
//        System.out.println();
//
//        for (int i = 0; i<points.size();i++){
//            System.out.print(points.get(i).getLng() +" ");
//            System.out.println();
//            System.out.print(points.get(i).getLat() +" ");
//        }
//
//        Polygon polygon1 = new Polygon(points);
//        System.out.println(polygon1.toString());


    }


}
