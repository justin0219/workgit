package com.example.deviceinfocollector.deviceinfo;

import android.support.v7.app.AppCompatActivity;

import github.nisrulz.easydeviceinfo.base.EasyDeviceMod;

/**
 * @author wh1t3P1g
 * @since 2019-04-09
 */
public class DeviceInfo extends BaseInfo {

    private String board;
    private String screenDisplayID;
    private String radioVer;
    private String product;
    private String device;
    private String hardware;
    private String bootloader;
    private String fingerprint;

    DeviceInfo(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    public void init() {
        EasyDeviceMod easyDeviceMod = new EasyDeviceMod(getActivity());
        setBoard(easyDeviceMod.getBoard());
        setScreenDisplayID(easyDeviceMod.getScreenDisplayID());
        setRadioVer(easyDeviceMod.getRadioVer());
        setProduct(easyDeviceMod.getProduct());
        setDevice(easyDeviceMod.getDevice());
        setHardware(easyDeviceMod.getHardware());
        setBootloader(easyDeviceMod.getBootloader());
        setFingerprint(easyDeviceMod.getFingerprint());
    }

    @Override
    public String getInfo() {
        StringBuilder info = new StringBuilder();

        info.append("Board: ").append(getBoard()).append("<br/>");
        info.append("ScreenDisplayID: ").append(getScreenDisplayID()).append("<br/>");
        info.append("Bootloader: ").append(getBootloader()).append("<br/>");
        info.append("Device: ").append(getDevice()).append("<br/>");
        info.append("Fingerprint: ").append(getFingerprint()).append("<br/>");
        info.append("Hardware: ").append(getHardware()).append("<br/>");
        info.append("Product: ").append(getProduct()).append("<br/>");
        info.append("RadioVer: ").append(getRadioVer()).append("<br/>");
        return info.toString();
    }
    // getter and setter

    private String getBoard() {
        return board;
    }

    private void setBoard(String board) {
        this.board = board;
    }

    private String getScreenDisplayID() {
        return screenDisplayID;
    }

    private void setScreenDisplayID(String screenDisplayID) {
        this.screenDisplayID = screenDisplayID;
    }

    private String getRadioVer() {
        return radioVer;
    }

    private void setRadioVer(String radioVer) {
        this.radioVer = radioVer;
    }

    private String getProduct() {
        return product;
    }

    private void setProduct(String product) {
        this.product = product;
    }

    private String getDevice() {
        return device;
    }

    private void setDevice(String device) {
        this.device = device;
    }

    private String getHardware() {
        return hardware;
    }

    private void setHardware(String hardware) {
        this.hardware = hardware;
    }

    private String getBootloader() {
        return bootloader;
    }

    private void setBootloader(String bootloader) {
        this.bootloader = bootloader;
    }

    private String getFingerprint() {
        return fingerprint;
    }

    private void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }
}
