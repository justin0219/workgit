package com.example.deviceinfocollector.deviceinfo;

import android.support.v7.app.AppCompatActivity;

import github.nisrulz.easydeviceinfo.base.EasyConfigMod;

/**
 * @author wh1t3P1g
 * @since 2019-04-09
 */
public class SDCardInfo extends BaseInfo {

    private String hasSD;
    private static String MTAB = "\n";

    SDCardInfo(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    public void init() {
        EasyConfigMod easyConfigMod = new EasyConfigMod(getActivity());
        setHasSD(easyConfigMod.hasSdCard() ? "YES" : "NO");
    }

    @Override
    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Has SD Card: ").append(getHasSD()).append(MTAB);
        return info.toString();
    }

    private String getHasSD() {
        return hasSD;
    }

    private void setHasSD(String hasSD) {
        this.hasSD = hasSD;
    }
}
