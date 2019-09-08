package com.example.controller;

import com.example.serviceImpl.GPSInformationServiceImpl;
import com.example.utils.BaiDuMapLoacationUtils;
import com.example.utils.SerialPortManagerUtils;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/serialPort")
@CrossOrigin
public class SerialPortController {

    @Autowired
    private GPSInformationServiceImpl gpsInformationServiceImpl;


    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/sendToPort",method = RequestMethod.POST)
    public void sendToPort(@RequestParam(value = "string") String string){
        ArrayList<String> portList = SerialPortManagerUtils.findPorts();
        try {
            SerialPort serialPort = SerialPortManagerUtils.openPort(portList.get(0),115200);
            SerialPortManagerUtils.sendToPort(serialPort,string);
            //其实添加一个检测串口是否正在开启的函数可能会更好
            serialPort.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/sendLocation",method = RequestMethod.GET)
    public JSONArray sendLocation(){
        ArrayList<String> portList = SerialPortManagerUtils.findPorts();
        try {
            //目前只有一个串口
            SerialPort serialPort = SerialPortManagerUtils.openPort(portList.get(0),115200);
            JSONArray jsonArray = SerialPortManagerUtils.readFromPort(serialPort);
            System.out.println(jsonArray);
            serialPort.close();
            if(jsonArray != null){
                gpsInformationServiceImpl.addGPSInformation(jsonArray.toString());
                //serialPort.close();
                return jsonArray;
            }
        } catch (PortInUseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/testSendLocation",method = RequestMethod.GET)
    public JSONArray testSendLocation(){

        double[] doubles = new double[]{21.155879,110.30582 };
        Map<String,Double> map = new HashMap<>();
        map.put("longitude",doubles[1]);//经度
        map.put("latitude",doubles[0]);//纬度
        JSONArray jsonArray = JSONArray.fromObject(map);
        return jsonArray;
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public void test(){
        //double[] doubles = new double[]{21.1544,110.298};
        double[] doubles = BaiDuMapLoacationUtils.get_location(21.1544,110.298);
        for (int i = 0; i <doubles.length ; i++) {
            System.out.println(doubles[i]);
        }
    }




}
