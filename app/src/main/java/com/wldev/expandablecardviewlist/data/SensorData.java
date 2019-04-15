package com.wldev.expandablecardviewlist.data;

public class SensorData {


    public String getSensorName() {
        return sensorName;
    }

    public String getSensorFactory() {
        return sensorFactory;
    }

    public String getSensorDetail() {
        return sensorDetail;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public void setSensorFactory(String sensorFactory) {
        this.sensorFactory = sensorFactory;
    }

    public void setSensorDetail(String sensorDetail) {
        this.sensorDetail = sensorDetail;
    }



    public SensorData(String sensorName, String sensorFactory, String sensorDetail) {
        this.sensorName = sensorName;
        this.sensorFactory = sensorFactory;
        this.sensorDetail = sensorDetail;
    }

    private String sensorName;
    private String sensorFactory;
    private String sensorDetail;
}
