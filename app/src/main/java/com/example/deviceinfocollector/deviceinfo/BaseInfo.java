package com.example.deviceinfocollector.deviceinfo;

import android.support.v7.app.AppCompatActivity;

/**
 * @author wh1t3P1g
 * @since 2019-04-09
 */
public class BaseInfo {
    String info = "";
    AppCompatActivity activity;

    BaseInfo(AppCompatActivity activity){
        this.activity = activity;
        init();
    }

    public void init(){

    }

    public String getInfo(){
        return info;
    }
}
