package com.example.utils;

import com.example.pojo.GPSInformation;
import gnu.io.*;
import net.sf.json.JSONArray;

import java.io.*;
import java.util.*;

/**
 * 串口管理
 *
 * @author yangle
 */
@SuppressWarnings("all")
public class SerialPortManagerUtils {

    /**
     * 查找所有可用端口
     *
     * @return 可用端口名称列表
     */
    public static final ArrayList<String> findPorts() {
        // 获得当前所有可用串口
        Enumeration<CommPortIdentifier> portList = CommPortIdentifier.getPortIdentifiers();
        ArrayList<String> portNameList = new ArrayList<String>();
        // 将可用串口名添加到List并返回该List
        while (portList.hasMoreElements()) {
            String portName = portList.nextElement().getName();
            portNameList.add(portName);
        }
        return portNameList;
    }

    /**
     * 打开串口
     *
     * @param portName
     *            端口名称
     * @param baudrate
     *            波特率
     * @return 串口对象
     * @throws PortInUseException
     *             串口已被占用
     */
    public static final SerialPort openPort(String portName, int baudrate) throws PortInUseException {
        try {
            // 通过端口名识别端口
            CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
            // 打开端口，并给端口名字和一个timeout（打开操作的超时时间）
            CommPort commPort = portIdentifier.open(portName, 2000);
            // 判断是不是串口
            if (commPort instanceof SerialPort) {
                SerialPort serialPort = (SerialPort) commPort;
                try {
                    // 设置一下串口的波特率等参数
                    // 数据位：8
                    // 停止位：1
                    // 校验位：None
                    serialPort.setSerialPortParams(baudrate, SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
                            SerialPort.PARITY_NONE);
                    System.out.println("打开串口");
                } catch (UnsupportedCommOperationException e) {
                    e.printStackTrace();
                }
                return serialPort;
            }
        } catch (NoSuchPortException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    /**
     * 关闭串口
     *
     * @param serialport
     *            待关闭的串口对象
     */
    public static void closePort(SerialPort serialPort) {
        if (serialPort != null) {
            serialPort.close();
        }
    }

    /**
     * 往串口发送数据
     *
     * @param serialPort
     *            串口对象
     * @param order
     *            待发送数据
     */
    public static void sendToPort(SerialPort serialPort, String string) {
        OutputStream outputStream = null;
        try {
            outputStream = serialPort.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            PrintWriter printWriter = new PrintWriter(outputStreamWriter);
            printWriter.println(string);
            printWriter.flush();
            System.out.println("已发送:"+string);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                    outputStream = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 从串口读取数据
     *
     * @param serialPort
     *            当前已建立连接的SerialPort对象
     * @return 读取到的数据
     */
    public static JSONArray readFromPort(SerialPort serialPort) {
        InputStream inputStream = null;
        byte[] bytes = {};
        double[] doubless ={};
        try {
            inputStream = serialPort.getInputStream();
            StringBuffer stringBuffer = new StringBuffer();
            int i = 1;
            String temp = "";

            while (true){
                System.out.println("i:"+i);

                if(temp.length() >= 70){
                    System.out.println("temp最终的形态："+temp);

                    if(checkMsg(temp)){
                        //通过string1构造GPS数据信息
                        GPSInformation gpsInformation = new GPSInformation();
                        gpsInformation = GPSInformationUtils.formInfo(gpsInformation,temp);
                        System.out.println(gpsInformation.toString());

                        //转换成百度地图的坐标
                        double GPS_lat = gpsInformation.getLat();
                        double GPS_lon = gpsInformation.getLng();
                        double[] doubles = BaiDuMapLoacationUtils.get_location(GPS_lat,GPS_lon);

//                        System.out.println("doubles..");
//                        for (int j = 0; j <doubles.length ; j++) {
//                            System.out.println(doubles[i]);
//                        }
                        if(doubles != null){
                            for (int j = 0; i < doubles.length; j++) {
                                System.out.print(doubles[j] +" ");
                            }

                            Map<String,Double> map = new HashMap<>();
                            map.put("longitude",doubles[1]);//经度
                            map.put("latitude",doubles[0]);//纬度
                            System.out.println("map...");
                            //for (int j = 0; j <map.size() ; j++) {
                                System.out.println(map.get("longitude"));
                            System.out.println(map.get("latitude"));
                           // }
                            JSONArray jsonArray = JSONArray.fromObject(map);
                            return jsonArray;
                           // return doubles;
                            //发送到前端
                        }else {
                            System.out.println("为空");
                        }
                    }

                    temp = "";
                    i = 1;
                    continue;
                }
                int count = 0;
                while (count == 0) {
                    count = inputStream.available();
                }
                byte[] b = new byte[count];
                inputStream.read(b);
                String strRead = new String(b);
                strRead = String.copyValueOf(strRead.toCharArray(),0,b.length);
                System.out.println("每次的strRead:"+strRead);
                //拼凑字符串
                temp = temp + strRead;
                System.out.println("每次的temp:"+temp);
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                    inputStream = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    //检验字符串是否符合规格
    public  static boolean checkMsg(String string){
        String string2 = string.substring(1,string.length());
        String[] strings = string.split(",");
        String  head = strings[0];

        if(head.equals("$GNRMC") )
        {
            //String s = "$GNRMC,125557.800,V,0000.0000,N,00000.0000,E,000.0,000.0,280606";
//            if(!(string.charAt(6) == ',') || !(string.charAt(17) == ',') || !(string.charAt(19) == ',')
//                    || !(string.charAt(29) == ',') || !(string.charAt(31) == ',') || !(string.charAt(42) == ',')
//                    || !(string.charAt(44) == ',') || !(string.charAt(50) == ',') || !(string.charAt(56) == ','
//                    || !(string.charAt(63) == ',') || !(string.charAt(64) == ',') || !(string.charAt(65) == ','))
//                    )
//                return false;

            if(!(string2.charAt(6) == ',') || !(string2.charAt(17) == ',') || !(string2.charAt(19) == ',')
                    || !(string2.charAt(29) == ',') || !(string2.charAt(31) == ',') || !(string2.charAt(42) == ',')
                    || !(string2.charAt(44) == ',') || !(string2.charAt(50) == ',') || !(string2.charAt(56) == ','
                    || !(string2.charAt(63) == ',') || !(string2.charAt(64) == ',') || !(string2.charAt(65) == ','))
                    )
                return false;
        }else {
            return false;
        }
        return true;
    }

    /**
     * 添加监听器
     *
     * @param port
     *            串口对象
     * @param listener
     *            串口存在有效数据监听
     */
    public static void addListener(SerialPort serialPort, DataAvailableListener listener) {
        try {
            // 给串口添加监听器
            serialPort.addEventListener(new SerialPortListener(listener));
            // 设置当有数据到达时唤醒监听接收线程
            serialPort.notifyOnDataAvailable(true);
            // 设置当通信中断时唤醒中断线程
            serialPort.notifyOnBreakInterrupt(true);
        } catch (TooManyListenersException e) {
            e.printStackTrace();
        }
    }

    /**
     * 串口监听
     */
    public static class SerialPortListener implements SerialPortEventListener {

        private DataAvailableListener mDataAvailableListener;

        public SerialPortListener(DataAvailableListener mDataAvailableListener) {
            this.mDataAvailableListener = mDataAvailableListener;
        }

        public void serialEvent(SerialPortEvent serialPortEvent) {
            switch (serialPortEvent.getEventType()) {
                case SerialPortEvent.DATA_AVAILABLE: // 1.串口存在有效数据
                    if (mDataAvailableListener != null) {
                        mDataAvailableListener.dataAvailable();
                    }
                    break;

                case SerialPortEvent.OUTPUT_BUFFER_EMPTY: // 2.输出缓冲区已清空
                    break;

                case SerialPortEvent.CTS: // 3.清除待发送数据
                    break;

                case SerialPortEvent.DSR: // 4.待发送数据准备好了
                    break;

                case SerialPortEvent.RI: // 5.振铃指示
                    break;

                case SerialPortEvent.CD: // 6.载波检测
                    break;

                case SerialPortEvent.OE: // 7.溢位（溢出）错误
                    break;

                case SerialPortEvent.PE: // 8.奇偶校验错误
                    break;

                case SerialPortEvent.FE: // 9.帧错误
                    break;

                case SerialPortEvent.BI: // 10.通讯中断
                    //ShowUtils.errorMessage("与串口设备通讯中断");
                    System.out.println("与串口设备通讯中断");
                    break;

                default:
                    break;
            }
        }
    }

    /**
     * 串口存在有效数据监听
     */
    public interface DataAvailableListener {
        /**
         * 串口存在有效数据
         */
        void dataAvailable();
    }




}
