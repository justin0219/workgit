package com.example.deviceinfocollector.deviceinfo;

import android.support.v7.app.AppCompatActivity;

/**
 * @author wh1t3P1g
 * @since 2019-04-09
 */
public class BaseInfo {

    private String info;
    private AppCompatActivity activity;

    BaseInfo(AppCompatActivity activity) {
        this.activity = activity;
        init();
    }

    public void init() {

    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public AppCompatActivity getActivity() {
        return activity;
    }

    public void setActivity(AppCompatActivity activity) {
        this.activity = activity;
    }
}
