package com.example.deviceinfocollector.deviceinfo;

import android.support.v7.app.AppCompatActivity;
import com.example.deviceinfocollector.deviceinfo.CPUInfo;
import com.example.deviceinfocollector.deviceinfo.DeviceInfo;
/**
 * @author wh1t3P1g
 * @since 2019-04-09
 */
public class CollectAllInfo {

    public String getAllInfo(AppCompatActivity activity){
        StringBuilder info = new StringBuilder();
        CPUInfo cpuInfo = new CPUInfo(activity);
        DeviceInfo deviceInfo = new DeviceInfo(activity);
        info.append(cpuInfo.getInfo()).append("\n");
        info.append(deviceInfo.getInfo()).append("\n");

        return info.toString();
    }
}
