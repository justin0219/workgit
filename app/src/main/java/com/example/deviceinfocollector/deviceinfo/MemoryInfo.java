package com.example.deviceinfocollector.deviceinfo;

import android.support.v7.app.AppCompatActivity;
import github.nisrulz.easydeviceinfo.base.EasyMemoryMod;

import java.text.DecimalFormat;

/**
 * @author wh1t3P1g
 * @since 2019-04-09
 */
public class MemoryInfo extends BaseInfo{

    private String totalMemory;
    private String totalInternalMemorySize;
    private String totalExternalMemorySize;

    MemoryInfo(AppCompatActivity activity) {
        super(activity);
    }


    @Override
    public void init() {
        EasyMemoryMod easyMemoryMod = new EasyMemoryMod(getActivity());

        setTotalMemory(easyMemoryMod.convertToGb(easyMemoryMod.getTotalRAM()));
        setTotalInternalMemorySize(easyMemoryMod.convertToGb(easyMemoryMod.getTotalInternalMemorySize()));
        setTotalExternalMemorySize(easyMemoryMod.convertToGb(easyMemoryMod.getTotalExternalMemorySize()));
    }

    @Override
    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("TotalMemory: ").append(getTotalMemory()).append("<br/>");
        info.append("TotalExternalMemorySize: ").append(getTotalExternalMemorySize()).append("<br/>");
        info.append("TotalInternalMemorySize: ").append(getTotalInternalMemorySize()).append("<br/>");
        return info.toString();
    }

    private String getTotalMemory() {
        return totalMemory;
    }

    private void setTotalMemory(float totalMemory) {
        String memory = new DecimalFormat(".00").format(totalMemory);
        this.totalMemory = memory+"Gb";
    }

    private String getTotalInternalMemorySize() {
        return totalInternalMemorySize;
    }

    private void setTotalInternalMemorySize(float totalInternalMemorySize) {
        String memory = new DecimalFormat(".00").format(totalInternalMemorySize);
        this.totalInternalMemorySize = memory+"Gb";
    }

    private String getTotalExternalMemorySize() {
        return totalExternalMemorySize;
    }

    private void setTotalExternalMemorySize(float totalExternalMemorySize) {
        String memory = new DecimalFormat(".00").format(totalExternalMemorySize);
        this.totalExternalMemorySize = memory+"Gb";
    }
}
