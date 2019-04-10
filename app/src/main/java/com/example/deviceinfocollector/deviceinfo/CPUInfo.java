package com.example.deviceinfocollector.deviceinfo;

import android.support.v7.app.AppCompatActivity;
import github.nisrulz.easydeviceinfo.base.EasyCpuMod;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author wh1t3P1g
 * @since 2019-04-09
 */
public class CPUInfo extends BaseInfo{

    private String abis;

    CPUInfo(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    public void init(){
        EasyCpuMod easyCpuMod = new EasyCpuMod();
        // 从 Build.SUPPORTED_ABIS 取
        setAbis(easyCpuMod.getStringSupportedABIS());
    }

    @Override
    public String getInfo(){
        StringBuilder info = new StringBuilder();
        info.append("CPU: ").append(getAbis()).append("<br/>");
        return info.toString();
    }

    public String getAbis() {
        return abis;
    }

    public void setAbis(String abis) {
        this.abis = abis;
    }
}
