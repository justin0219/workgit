package com.example.deviceinfocollector.deviceinfo;

import android.support.v7.app.AppCompatActivity;

import github.nisrulz.easydeviceinfo.base.BatteryHealth;
import github.nisrulz.easydeviceinfo.base.ChargingVia;
import github.nisrulz.easydeviceinfo.base.EasyBatteryMod;

/**
 * @author wh1t3P1g
 * @since 2019-04-09
 */
public class BatteryInfo extends BaseInfo {

    private String isDeviceCharging;
    private String BatteryPercentage;
    private String batteryTechnology;
    private String batteryTemperature;
    private String batteryVoltage;
    private String batteryHealth;
    private String isChargingVia;


    BatteryInfo(AppCompatActivity activity) {
        super(activity);
    }


    @Override
    public void init() {
        EasyBatteryMod easyBatteryMod = new EasyBatteryMod(getActivity());

        setBatteryPercentage(easyBatteryMod.getBatteryPercentage());
        setBatteryTechnology(easyBatteryMod.getBatteryTechnology());
        setBatteryTemperature(easyBatteryMod.getBatteryTemperature());
        setBatteryVoltage(easyBatteryMod.getBatteryVoltage());
        setIsDeviceCharging(easyBatteryMod.isDeviceCharging());
        setIsChargingVia(easyBatteryMod.getChargingSource());
        setBatteryHealth(easyBatteryMod.getBatteryHealth());

    }

    @Override
    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("BatteryPercentage: ").append(getBatteryPercentage()).append("<br/>");
        info.append("BatteryTechnology: ").append(getBatteryTechnology()).append("<br/>");
        info.append("BatteryVoltage: ").append(getBatteryVoltage()).append("<br/>");
        info.append("IsDeviceCharging: ").append(getIsDeviceCharging()).append("<br/>");
        info.append("BatteryTemperature: ").append(getBatteryTemperature()).append("<br/>");
        info.append("IsChargingVia: ").append(getIsChargingVia()).append("<br/>");
        info.append("BatteryHealth: ").append(getBatteryHealth()).append("<br/>");
        return info.toString();
    }

    private String getIsDeviceCharging() {
        return isDeviceCharging;
    }

    private void setIsDeviceCharging(Boolean isDeviceCharging) {
        this.isDeviceCharging = isDeviceCharging ? "YES" : "NO";
    }

    private String getBatteryPercentage() {
        return BatteryPercentage;
    }

    private void setBatteryPercentage(int batteryPercentage) {
        BatteryPercentage = batteryPercentage + "%";
    }

    private String getBatteryTechnology() {
        return batteryTechnology;
    }

    private void setBatteryTechnology(String batteryTechnology) {
        this.batteryTechnology = batteryTechnology;
    }

    private String getBatteryTemperature() {
        return batteryTemperature;
    }

    private void setBatteryTemperature(float batteryTemperature) {
        this.batteryTemperature = batteryTemperature + "度";
    }

    private String getBatteryVoltage() {
        return batteryVoltage;
    }

    private void setBatteryVoltage(int batteryVoltage) {
        this.batteryVoltage = batteryVoltage / 1000 + "V";
    }

    private String getBatteryHealth() {
        return batteryHealth;
    }

    private void setBatteryHealth(int batteryHealth) {
        switch (batteryHealth) {
            case BatteryHealth.GOOD:
                this.batteryHealth = "Battery health : Good";
                break;
            case BatteryHealth.HAVING_ISSUES:
                this.batteryHealth = "Battery health : Having issues";
                break;
            default:
                this.batteryHealth = "Battery health : Having issues";
                break;
        }
    }

    private String getIsChargingVia() {
        return isChargingVia;
    }

    private void setIsChargingVia(int isChargingVia) {
        switch (isChargingVia) {
            case ChargingVia.AC:
                this.isChargingVia = "Device charging via AC";
                break;
            case ChargingVia.USB:
                this.isChargingVia = "Device charging via USB";
                break;
            case ChargingVia.WIRELESS:
                this.isChargingVia = "Device charging via Wireless";
                break;
            case ChargingVia.UNKNOWN_SOURCE:
                this.isChargingVia = "Device charging via Unknown Source";
                break;
            default:
                this.isChargingVia = "Device charging via Unknown Source";
                break;
        }
    }
}
