package com.example.deviceinfocollector.deviceinfo;

import android.support.v7.app.AppCompatActivity;
import github.nisrulz.easydeviceinfo.base.EasyDeviceMod;

/**
 * @author wh1t3P1g
 * @since 2019-04-09
 */
public class DeviceInfo {

    public String getAllInfo(AppCompatActivity activity){
        EasyDeviceMod easyDeviceMod = new EasyDeviceMod(activity);


        return easyDeviceMod.getBoard();
    }
}
