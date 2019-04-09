package com.example.deviceinfocollector.deviceinfo;

import android.support.v7.app.AppCompatActivity;
import github.nisrulz.easydeviceinfo.base.EasyDeviceMod;

/**
 * @author wh1t3P1g
 * @since 2019-04-09
 */
public class DeviceInfo extends BaseInfo{

    DeviceInfo(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    public void init(){
        EasyDeviceMod easyDeviceMod = new EasyDeviceMod(this.activity);
        this.info = easyDeviceMod.getBoard();
    }
}
