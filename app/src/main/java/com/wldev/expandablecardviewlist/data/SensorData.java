package com.wldev.expandablecardviewlist.data;

public class SensorData {


    private String sensorName;
    private String sensorFactory;
    private String sensorDetail;

    public SensorData(String sensorName, String sensorFactory, String sensorDetail) {
        this.sensorName = sensorName;
        this.sensorFactory = sensorFactory;
        this.sensorDetail = sensorDetail;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public String getSensorFactory() {
        return sensorFactory;
    }

    public void setSensorFactory(String sensorFactory) {
        this.sensorFactory = sensorFactory;
    }

    public String getSensorDetail() {
        return sensorDetail;
    }

    public void setSensorDetail(String sensorDetail) {
        this.sensorDetail = sensorDetail;
    }
}
