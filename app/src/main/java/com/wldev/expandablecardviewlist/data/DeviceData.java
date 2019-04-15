package com.wldev.expandablecardviewlist.data;

public class DeviceData {
    private String labelName;
    private String labelValue;

    public DeviceData(String labelName, String labelValue) {
        this.labelName = labelName;
        this.labelValue = labelValue;
    }

    public String getLabelName() {
        return labelName;
    }

    public String getLabelValue() {
        return labelValue;
    }

    public void setLabelName(String labelName) {
        this.labelName = labelName;
    }

    public void setLabelValue(String labelValue) {
        this.labelValue = labelValue;
    }
}
