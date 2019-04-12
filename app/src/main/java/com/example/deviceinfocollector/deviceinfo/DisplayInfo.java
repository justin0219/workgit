package com.example.deviceinfocollector.deviceinfo;

import android.support.v7.app.AppCompatActivity;

import github.nisrulz.easydeviceinfo.base.EasyDisplayMod;

/**
 * @author wh1t3P1g
 * @since 2019-04-10
 */
public class DisplayInfo extends BaseInfo {

    private String resolution;
    private String density;
    private String refreshRate;
    private String physicalSize;

    DisplayInfo(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    public void init() {
        EasyDisplayMod easyDisplayMod = new EasyDisplayMod(getActivity());
        setDensity(easyDisplayMod.getDensity());
        setPhysicalSize(easyDisplayMod.getPhysicalSize());
        setRefreshRate(easyDisplayMod.getRefreshRate());
        setResolution(easyDisplayMod.getResolution());

    }

    @Override
    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Density: ").append(getDensity()).append("<br/>");
        info.append("PhysicalSize: ").append(getPhysicalSize()).append("<br/>");
        info.append("RefreshRate: ").append(getRefreshRate()).append("<br/>");
        info.append("Resolution: ").append(getResolution()).append("<br/>");
        return info.toString();
    }

    private String getResolution() {
        return resolution;
    }

    private void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getDensity() {
        return density;
    }

    public void setDensity(String density) {
        this.density = density;
    }

    private String getRefreshRate() {
        return refreshRate;
    }

    private void setRefreshRate(float refreshRate) {
        this.refreshRate = Float.toString(refreshRate);
    }

    private String getPhysicalSize() {
        return physicalSize;
    }

    private void setPhysicalSize(float physicalSize) {
        this.physicalSize = Float.toString(physicalSize);
    }
}
