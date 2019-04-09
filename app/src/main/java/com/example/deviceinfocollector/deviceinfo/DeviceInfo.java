package com.example.deviceinfocollector.deviceinfo;

import android.support.v7.app.AppCompatActivity;
import github.nisrulz.easydeviceinfo.base.EasyDeviceMod;

/**
 * @author wh1t3P1g
 * @since 2019-04-09
 */
public class DeviceInfo extends BaseInfo{

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
    public void init(){
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
    public String getInfo(){
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

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public String getScreenDisplayID() {
        return screenDisplayID;
    }

    public void setScreenDisplayID(String screenDisplayID) {
        this.screenDisplayID = screenDisplayID;
    }

    public String getRadioVer() {
        return radioVer;
    }

    public void setRadioVer(String radioVer) {
        this.radioVer = radioVer;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getHardware() {
        return hardware;
    }

    public void setHardware(String hardware) {
        this.hardware = hardware;
    }

    public String getBootloader() {
        return bootloader;
    }

    public void setBootloader(String bootloader) {
        this.bootloader = bootloader;
    }

    public String getFingerprint() {
        return fingerprint;
    }

    public void setFingerprint(String fingerprint) {
        this.fingerprint = fingerprint;
    }
}
