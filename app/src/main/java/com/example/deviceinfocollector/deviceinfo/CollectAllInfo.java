package com.example.deviceinfocollector.deviceinfo;

import android.support.v7.app.AppCompatActivity;

/**
 * @author wh1t3P1g
 * @since 2019-04-09
 */
public class CollectAllInfo {

    public String getAllInfo(AppCompatActivity activity) {
        StringBuilder info = new StringBuilder();
        info.append("## Device information\n");
        CPUInfo cpuInfo = new CPUInfo(activity);
        //info.append(cpuInfo.getInfo()).append("<br/>");
        info.append("\n\t").append(cpuInfo.getInfo());

        NFCInfo nfcInfo = new NFCInfo(activity);
        //info.append(nfcInfo.getInfo()).append("<br/>");
        info.append("\n\t").append(nfcInfo.getInfo());

        SDCardInfo sdCardInfo = new SDCardInfo(activity);
        //info.append(sdCardInfo.getInfo()).append("<br/>");
        info.append("\n\t").append(sdCardInfo.getInfo());

        DeviceInfo deviceInfo = new DeviceInfo(activity);
        //info.append(deviceInfo.getInfo()).append("<br/>");
        info.append("\n\t").append(deviceInfo.getInfo());

        MemoryInfo memoryInfo = new MemoryInfo(activity);
        //info.append(memoryInfo.getInfo()).append("<br/>");
        info.append("\n\t").append(memoryInfo.getInfo());

        BatteryInfo batteryInfo = new BatteryInfo(activity);
        //info.append(batteryInfo.getInfo()).append("<br/>");
        info.append("\n\t").append(batteryInfo.getInfo());

        DisplayInfo displayInfo = new DisplayInfo(activity);
        //info.append(displayInfo.getInfo()).append("<br/>");
        info.append("\n\t").append(displayInfo.getInfo());

        return info.toString();
    }
}
