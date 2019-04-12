package com.example.deviceinfocollector.deviceinfo;

import android.support.v7.app.AppCompatActivity;

import github.nisrulz.easydeviceinfo.base.EasyNfcMod;

/**
 * @author wh1t3P1g
 * @since 2019-04-09
 */
public class NFCInfo extends BaseInfo {

    private String nfcStatus;

    NFCInfo(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    public void init() {
        EasyNfcMod easyNfcMod = new EasyNfcMod(getActivity());
        setNfcStatus(easyNfcMod.isNfcPresent() ? "On" : "Off");
    }

    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("NFC Status: ").append(getNfcStatus()).append("<br/>");
        return info.toString();
    }

    private String getNfcStatus() {
        return nfcStatus;
    }

    private void setNfcStatus(String nfcStatus) {
        this.nfcStatus = nfcStatus;
    }
}
