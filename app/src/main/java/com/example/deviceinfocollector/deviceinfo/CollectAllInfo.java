package com.example.deviceinfocollector.deviceinfo;

import android.support.v7.app.AppCompatActivity;

import com.wldev.expandablecardviewlist.data.DeviceData;

import java.util.ArrayList;

/**
 * @author wh1t3P1g
 * @since 2019-04-09
 */
public class CollectAllInfo {

    public CollectAllInfo(AppCompatActivity activity) {
        this.cpuInfo = new CPUInfo(activity);
        this.nfcInfo = new NFCInfo(activity);
        this.sdCardInfo = new SDCardInfo(activity);
        this.deviceInfo = new DeviceInfo(activity);
        this.memoryInfo = new MemoryInfo(activity);
        this.batteryInfo = new BatteryInfo(activity);
        this.displayInfo = new DisplayInfo(activity);
    }

    public CPUInfo getCpuInfo() {
        return cpuInfo;
    }

    public NFCInfo getNfcInfo() {
        return nfcInfo;
    }

    public SDCardInfo getSdCardInfo() {
        return sdCardInfo;
    }

    public DeviceInfo getDeviceInfo() {
        return deviceInfo;
    }

    public MemoryInfo getMemoryInfo() {
        return memoryInfo;
    }

    public BatteryInfo getBatteryInfo() {
        return batteryInfo;
    }

    public DisplayInfo getDisplayInfo() {
        return displayInfo;
    }

    CPUInfo cpuInfo;
    NFCInfo nfcInfo;
    SDCardInfo sdCardInfo;
    DeviceInfo deviceInfo;
    MemoryInfo memoryInfo;
    BatteryInfo batteryInfo;
    DisplayInfo displayInfo;

    public void updateAllInfo(AppCompatActivity activity) {
        this.cpuInfo = new CPUInfo(activity);
        this.nfcInfo = new NFCInfo(activity);
        this.sdCardInfo = new SDCardInfo(activity);
        this.deviceInfo = new DeviceInfo(activity);
        this.memoryInfo = new MemoryInfo(activity);
        this.batteryInfo = new BatteryInfo(activity);
        this.displayInfo = new DisplayInfo(activity);
    }

    public String getAllInfo(AppCompatActivity activity) {
        StringBuilder info = new StringBuilder();
        info.append("## Device information\n");
        CPUInfo cpuInfo = new CPUInfo(activity);
        //info.append(cpuInfo.getInfo()).append("<br/>");
        info.append("\n").append(cpuInfo.getInfo());

        NFCInfo nfcInfo = new NFCInfo(activity);
        //info.append(nfcInfo.getInfo()).append("<br/>");
        info.append("\n").append(nfcInfo.getInfo());

        SDCardInfo sdCardInfo = new SDCardInfo(activity);
        //info.append(sdCardInfo.getInfo()).append("<br/>");
        info.append("\n").append(sdCardInfo.getInfo());

        DeviceInfo deviceInfo = new DeviceInfo(activity);
        //info.append(deviceInfo.getInfo()).append("<br/>");
        info.append("\n").append(deviceInfo.getInfo());

        MemoryInfo memoryInfo = new MemoryInfo(activity);
        //info.append(memoryInfo.getInfo()).append("<br/>");
        info.append("\n").append(memoryInfo.getInfo());

        BatteryInfo batteryInfo = new BatteryInfo(activity);
        //info.append(batteryInfo.getInfo()).append("<br/>");
        info.append("\n").append(batteryInfo.getInfo());

        DisplayInfo displayInfo = new DisplayInfo(activity);
        //info.append(displayInfo.getInfo()).append("<br/>");
        info.append("\n").append(displayInfo.getInfo());

        return info.toString();
    }

    public ArrayList<DeviceData> getDeviceDatas() {
        ArrayList<DeviceData> deviceDatas = new ArrayList<>();
        deviceDatas.add(new DeviceData("Device", this.getDeviceInfo().getInfo()));
        deviceDatas.add(new DeviceData("Battery", this.getBatteryInfo().getInfo()));
        deviceDatas.add(new DeviceData("Cpu", this.getCpuInfo().getInfo()));
        deviceDatas.add(new DeviceData("Display", this.getDisplayInfo().getInfo()));
        deviceDatas.add(new DeviceData("Memory", this.getMemoryInfo().getInfo()));
        deviceDatas.add(new DeviceData("NFC", this.getNfcInfo().getInfo()));
        deviceDatas.add(new DeviceData("SD ", this.getSdCardInfo().getInfo()));
        return deviceDatas;
    }
}
