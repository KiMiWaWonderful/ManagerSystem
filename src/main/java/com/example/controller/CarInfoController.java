package com.example.controller;

import com.example.pojo.CarInfo;
import com.example.service.CarInfoService;
import com.example.serviceImpl.CarInfoServiceImpl;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/carInfo")
@CrossOrigin
public class CarInfoController {

    @Autowired
    private CarInfoService carInfoService;
    @Autowired
    private CarInfoServiceImpl carInfoServiceImpl;

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/getCarInfo",method = RequestMethod.GET)
    public JSONArray getCarInfo(){
        List<CarInfo> carInfos = carInfoServiceImpl.getCarInfo();

//        for (int i = 0; i <carInfos.size() ; i++) {
//            System.out.println(carInfos.get(i).toString());
//        }
//
//        System.out.println(carInfos.size());

        JSONArray jsonArray = JSONArray.fromObject(carInfos);
       // System.out.println(jsonArray);
        return jsonArray;
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/getFromFront",method = RequestMethod.POST)
    public JSONArray getFromFront(@RequestParam(value = "string") String string){

        int id = Integer.parseInt(string);
        CarInfo carInfo = carInfoServiceImpl.getById(id);
        //System.out.println(carInfo.toString());

        JSONArray jsonArray = JSONArray.fromObject(carInfo);
       // System.out.println(jsonArray);
        return jsonArray;
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/showOwnerList",method = RequestMethod.GET)
    public String showOwnerList(Model model){

        List<CarInfo> carInfos = carInfoServiceImpl.getOwnerInfo();
        JSONArray jsonArray = JSONArray.fromObject(carInfos);
        System.out.println(jsonArray);
        model.addAttribute("carInfos",carInfos);
        return "forward:tryXunhuan.html";

    }


}
