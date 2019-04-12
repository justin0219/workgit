package com.example.liuyue7.appinfo_sensor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;


import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //准备显示信息的UI组件
        TextView tx1 =(TextView)findViewById(R.id.TextView01);
        tx1.setMovementMethod(ScrollingMovementMethod.getInstance());

        //从系统服务获得传感器管理器
        SensorManager sm = (SensorManager)getSystemService(Context.SENSOR_SERVICE);

        //从传感器管理器中获得全部的传感器列表
        List<Sensor> allSsensors=sm.getSensorList(Sensor.TYPE_ALL);

        //显示有多少个传感器
        tx1.setText("检查到该设备拥有"+allSsensors.size()+"种传感器，相关传感器信息为：\n");

        String str;
        //从传感器管理器中获得全部的传感器列表
        List<Sensor> allSensors = sm.getSensorList(Sensor.TYPE_ALL);
        int i;
        //给ViewText添加滚动条
        tx1.setMovementMethod(ScrollingMovementMethod.getInstance());
        //显示有多少个传感器
        tx1.setText("经检测该手机有"+allSensors.size()+"个传感器，它们分别是:");
        Sensor s;
        //显示每个传感器的具体信息
        for(i=0;i<allSensors.size();i++)
        {
            s=allSensors.get(i);
            str="设备名称："+s.getName()+"\n"+"设备版本："+s.getVersion()+"\n"+"制造厂商："+s.getVendor()+"\n";
            switch(s.getType())
            {
                //加速传感器     Sensor.TYPE_ACCELEROMETER
                case Sensor.TYPE_ACCELEROMETER:
                    tx1.setText(tx1.getText()+"\n"+i+"加速度计传感器accelerometer:\n"+str);
                    break;
                case Sensor.TYPE_LINEAR_ACCELERATION:
                    tx1.setText(tx1.getText()+"\n"+i+"加速度计传感器accelerometer:\n"+str);
                    break;
                //陀螺仪传感器    Sensor.TYPE_GYROSCOPE
                case Sensor.TYPE_GYROSCOPE:
                    tx1.setText(tx1.getText()+"\n"+i+"陀螺仪传感器gyroscope:\n"+str);
                    break;
                case Sensor.TYPE_GYROSCOPE_UNCALIBRATED:
                    tx1.setText(tx1.getText()+"\n"+i+"陀螺仪传感器gyroscope:\n"+str);
                    break;
                //环境光仪传感器   Sensor.TYPE_LIGHT
                case Sensor.TYPE_LIGHT:
                    tx1.setText(tx1.getText()+"\n"+i+"环境光仪传感器light:\n"+str);
                    break;
                //电磁场传感器    Sensor.TYPE_MAGNETIC_FIELD
                case Sensor.TYPE_MAGNETIC_FIELD:
                    tx1.setText(tx1.getText()+"\n"+i+"磁场传感器magnetic:\n"+str);
                    break;
                case Sensor.TYPE_MAGNETIC_FIELD_UNCALIBRATED:
                    tx1.setText(tx1.getText()+"\n"+i+"磁场传感器magnetic:\n"+str);
                    break;
                //方向传感器    Sensor.TYPE_ORIENTATION:
                case Sensor.TYPE_GAME_ROTATION_VECTOR:
                    tx1.setText(tx1.getText()+"\n"+i+"方向传感器orientation:\n"+str);
                    break;
                case Sensor.TYPE_ROTATION_VECTOR:
                    tx1.setText(tx1.getText()+"\n"+i+"方向传感器orientation:\n"+str);
                    break;
                /*case Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR:
                    tx1.setText(tx1.getText()+"\n"+i+"方向传感器orientation:\n"+str);
                    break;*/
                //压力传感器     Sensor.TYPE_PRESSURE:
                case Sensor.TYPE_PRESSURE:
                    tx1.setText(tx1.getText()+"\n"+i+"压力传感器pressure:\n"+str);
                    break;
                /*//互动复合传感器
                case Sensor.TYPE_WAKE_GESTURE:
                    tx1.setText(tx1.getText()+"\n"+i+"互动复合传感器pressure:\n"+str);
                    break;*/
                //距离传感器     Sensor.TYPE_PROXIMITY:
                case Sensor.TYPE_PROXIMITY:
                    tx1.setText(tx1.getText()+"\n"+i+"距离传感器proximity:\n"+str);
                    break;
                //温度传感器     Sensor.TYPE_TEMPERATURE:
                case Sensor.TYPE_AMBIENT_TEMPERATURE:
                    tx1.setText(tx1.getText()+"\n"+i+"温度传感器temperature:\n"+str);
                    break;
                case Sensor.TYPE_GEOMAGNETIC_ROTATION_VECTOR:
                    tx1.setText(tx1.getText()+"\n"+i+"磁强计传感器geomagnetic:\n"+str);
                    break;
                case Sensor.TYPE_RELATIVE_HUMIDITY:
                    tx1.setText(tx1.getText()+"\n"+i+"湿度传感器humidity:\n"+str);
                    break;
                case Sensor.TYPE_GRAVITY:
                    tx1.setText(tx1.getText()+"\n"+i+"重力传感器gravity:\n"+str);
                    break;
                case Sensor.TYPE_STEP_DETECTOR:
                    tx1.setText(tx1.getText()+"\n"+i+"计步传感器step:\n"+str);
                    break;
                case Sensor.TYPE_STEP_COUNTER:
                    tx1.setText(tx1.getText()+"\n"+i+"计步传感器step:\n"+str);
                    break;
                case Sensor.TYPE_HEART_RATE:
                    tx1.setText(tx1.getText()+"\n"+i+"心率传感器heartrate:\n"+str);
                    break;
                case Sensor.TYPE_SIGNIFICANT_MOTION:
                    tx1.setText(tx1.getText()+"\n"+i+"大幅动作传感器motion:\n"+str);
                    break;
                /*case Sensor.TYPE_TILT_DETECTOR:
                    tx1.setText(tx1.getText()+"\n"+i+"步数传感器step:\n"+str);
                    break;*/

                default:
                    tx1.setText(tx1.getText()+"\n"+i+"未知传感器unknown:\n"+str);
                    break;
            }
        }
    }


}
