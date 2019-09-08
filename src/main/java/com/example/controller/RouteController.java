package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouteController {

//    @Autowired
//    private CarInfoServiceImpl carInfoServiceImpl;

    @GetMapping("/HomePage")
    public String toMain(){
        return "HomePage";
    }

    //去可以展示地图，以及有很多定位的地图的首页
    @GetMapping("/Map")
    public String toMap(){
        return "BaiDuDiTu";
    }

    //去可以绘制多边形，并判断某点是否在多边形区域内的页面
    @GetMapping("/Draw")
    public String toDraw(){
        return "DuoBianXing";
    }

    //去可以定位的页面
    @GetMapping("/Locate")
    public String toLocate(){
        return "Location";
    }

    //去可以定位和绘图的页面
    @GetMapping("/LocateAndDraw")
    public String toLocateAndDraw(){
        return "Locate";
    }

//    @CrossOrigin
//    @ResponseBody
//    @GetMapping("/LocateAndDraw")
////  //  @RequestMapping(value = "/showOwnerList",method = RequestMethod.GET)
////    public String showOwnerList(Model model){
////
////        List<CarInfo> carInfos = carInfoServiceImpl.getOwnerInfo();
////        JSONArray jsonArray = JSONArray.fromObject(carInfos);
////        System.out.println(jsonArray);
////        model.addAttribute("carInfos",carInfos);
////        return "tryXunhuan";
////
////    }

}
