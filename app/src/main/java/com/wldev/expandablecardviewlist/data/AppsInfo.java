package com.wldev.expandablecardviewlist.data;

public class AppsInfo {
    public AppsInfo(String packageName, String appName) {
        this.packageName = packageName;
        this.appName = appName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getAppName() {
        return appName;
    }

    private String appName;
    private String packageName;
}