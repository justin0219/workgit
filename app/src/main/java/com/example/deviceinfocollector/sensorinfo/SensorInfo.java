package com.example.deviceinfocollector.sensorinfo;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;

import java.util.List;

public class SensorInfo {

    private Context context;
    private final String ENTER = "<br>";

    public SensorInfo(Context context) {
        this.context = context;
    }

    public String getInfo() {
        SensorManager sm = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        StringBuilder result = new StringBuilder();
        //从传感器管理器中获得全部的传感器列表
        List<Sensor> allSensors;
        if (sm != null) {
            allSensors = sm.getSensorList(Sensor.TYPE_ALL);
        } else {
            return "error occurs!";
        }

        //显示每个传感器的具体信息
        for (int i = 0; i < allSensors.size(); i++) {
            Sensor s = allSensors.get(i);
            String str = "设备名称：" + s.getName() + "\n" + "设备版本：" + s.getVersion() + "\n" + "制造厂商：" + s.getVendor() + "\n";
            switch (s.getType()) {
                //加速传感器     Sensor.TYPE_ACCELEROMETER
                case Sensor.TYPE_ACCELEROMETER:
                    result.append(ENTER).append(i).append("加速度计传感器accelerometer:\n").append(str);
                    break;
                case Sensor.TYPE_LINEAR_ACCELERATION:
                    result.append(ENTER).append(i).append("加速度计传感器accelerometer:\n").append(str);
                    break;
                //陀螺仪传感器    Sensor.TYPE_GYROSCOPE
                case Sensor.TYPE_GYROSCOPE:
                    result.append(ENTER).append(i).append("陀螺仪传感器gyroscope:\n").append(str);
                    break;
                case Sensor.TYPE_GYROSCOPE_UNCALIBRATED:
                    result.append(ENTER).append(i).append("陀螺仪传感器gyroscope:\n").append(str);
                    break;
                //环境光仪传感器   Sensor.TYPE_LIGHT
                case Sensor.TYPE_LIGHT:
                    result.append(ENTER).append(i).append("环境光仪传感器light:\n").append(str);
                    break;
                //电磁场传感器    Sensor.TYPE_MAGNETIC_FIELD
                case Sensor.TYPE_MAGNETIC_FIELD:
                    result.append(ENTER).append(i).append("磁场传感器magnetic:\n").append(str);
                    break;
                case Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED:
                    result.append(ENTER).append(i).append("磁场传感器magnetic:\n").append(str);
                    break;
                //方向传感器    Sensor.TYPE_ORIENTATION:
                case Sensor.TYPE_GAME_ROTATION_VECTOR:
                    result.append(ENTER).append(i).append("方向传感器orientation:\n").append(str);
                    break;
                case Sensor.TYPE_ROTATION_VECTOR:
                    result.append(ENTER).append(i).append("方向传感器orientation:\n").append(str);
                    break;
                //压力传感器     Sensor.TYPE_PRESSURE:
                case Sensor.TYPE_PRESSURE:
                    result.append(ENTER).append(i).append("压力传感器pressure:\n").append(str);
                    break;
                //距离传感器     Sensor.TYPE_PROXIMITY:
                case Sensor.TYPE_PROXIMITY:
                    result.append(ENTER).append(i).append("距离传感器proximity:\n").append(str);
                    break;
                //温度传感器     Sensor.TYPE_TEMPERATURE:
                case Sensor.TYPE_AMBIENT_TEMPERATURE:
                    result.append(ENTER).append(i).append("温度传感器temperature:\n").append(str);
                    break;
                case Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR:
                    result.append(ENTER).append(i).append("磁强计传感器geomagnetic:\n").append(str);
                    break;
                case Sensor.TYPE_RELATIVE_HUMIDITY:
                    result.append(ENTER).append(i).append("湿度传感器humidity:\n").append(str);
                    break;
                case Sensor.TYPE_GRAVITY:
                    result.append(ENTER).append(i).append("重力传感器gravity:\n").append(str);
                    break;
                case Sensor.TYPE_STEP_DETECTOR:
                    result.append(ENTER).append(i).append("计步传感器step:\n").append(str);
                    break;
                case Sensor.TYPE_STEP_COUNTER:
                    result.append(ENTER).append(i).append("计步传感器step:\n").append(str);
                    break;
                case Sensor.TYPE_HEART_RATE:
                    result.append(ENTER).append(i).append("心率传感器heartrate:\n").append(str);
                    break;
                case Sensor.TYPE_SIGNIFICANT_MOTION:
                    result.append(ENTER).append(i).append("大幅动作传感器motion:\n").append(str);
                    break;
                default:
                    result.append(ENTER).append(i).append("未知传感器unknown:\n").append(str);
                    break;
            }
        }
        return result.toString();
    }
}
