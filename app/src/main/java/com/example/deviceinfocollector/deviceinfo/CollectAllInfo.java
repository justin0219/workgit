package com.example.deviceinfocollector.deviceinfo;

import android.support.v7.app.AppCompatActivity;

/**
 * @author wh1t3P1g
 * @since 2019-04-09
 */
public class CollectAllInfo {

    public String getAllInfo(AppCompatActivity activity){
        StringBuilder info = new StringBuilder();
        CPUInfo cpuInfo = new CPUInfo(activity);
        info.append(cpuInfo.getInfo()).append("<br/>");

        NFCInfo nfcInfo = new NFCInfo(activity);
        info.append(nfcInfo.getInfo()).append("<br/>");

        SDCardInfo sdCardInfo = new SDCardInfo(activity);
        info.append(sdCardInfo.getInfo()).append("<br/>");

        DeviceInfo deviceInfo = new DeviceInfo(activity);
        info.append(deviceInfo.getInfo()).append("<br/>");

        MemoryInfo memoryInfo = new MemoryInfo(activity);
        info.append(memoryInfo.getInfo()).append("<br/>");

        BatteryInfo batteryInfo = new BatteryInfo(activity);
        info.append(batteryInfo.getInfo()).append("<br/>");

        DisplayInfo displayInfo = new DisplayInfo(activity);
        info.append(displayInfo.getInfo()).append("<br/>");

        return info.toString();
    }
}
