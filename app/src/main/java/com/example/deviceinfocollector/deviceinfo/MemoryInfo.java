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

    MemoryInfo(AppCompatActivity activity) {
        super(activity);
    }


    @Override
    public void init() {
        EasyMemoryMod easyMemoryMod = new EasyMemoryMod(getActivity());
        String memory = new DecimalFormat(".00").format(easyMemoryMod.convertToGb(easyMemoryMod.getTotalRAM()));
        setTotalMemory(memory+"Gb");
    }

    @Override
    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("TotalMemory: ").append(getTotalMemory()).append("<br/>");
        return info.toString();
    }

    public String getTotalMemory() {
        return totalMemory;
    }

    public void setTotalMemory(String totalMemory) {
        this.totalMemory = totalMemory;
    }
}
