package com.wldev.expandablecardviewlist;

import android.app.Application;

public class MyApplication extends Application {
    private static MyApplication applicationInstance;

    public static MyApplication get() {
        return applicationInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationInstance = this;
    }
}
