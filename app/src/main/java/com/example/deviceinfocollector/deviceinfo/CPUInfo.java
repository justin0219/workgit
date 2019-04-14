package com.example.deviceinfocollector.deviceinfo;

import android.support.v7.app.AppCompatActivity;

import github.nisrulz.easydeviceinfo.base.EasyCpuMod;

/**
 * @author wh1t3P1g
 * @since 2019-04-09
 */
public class CPUInfo extends BaseInfo {

    private String abis;
    private static String MTAB = "\n";

    CPUInfo(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    public void init() {
        EasyCpuMod easyCpuMod = new EasyCpuMod();
        // 从 Build.SUPPORTED_ABIS 取
        setAbis(easyCpuMod.getStringSupportedABIS());
    }

    @Override
    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("CPU: ").append(getAbis()).append(MTAB);
        return info.toString();
    }

    private String getAbis() {
        return abis;
    }

    private void setAbis(String abis) {
        this.abis = abis;
    }
}
