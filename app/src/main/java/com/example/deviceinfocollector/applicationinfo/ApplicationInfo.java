package com.example.deviceinfocollector.applicationinfo;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import java.util.List;

public class ApplicationInfo {

    private Context context;
    private final String ENTER = "<br>";

    public ApplicationInfo(Context context) {
        this.context = context;
    }

    public String getInfo() {
        StringBuilder result = new StringBuilder();
        PackageManager pm = context.getPackageManager();
        List<PackageInfo> installedPackages = pm.getInstalledPackages(PackageManager.GET_UNINSTALLED_PACKAGES);

        for (PackageInfo packageInfo : installedPackages) {
            String appName = packageInfo.applicationInfo.loadLabel(context.getPackageManager()).toString();
            String packageName = packageInfo.packageName;
            result.append(appName).append(" ").append(packageName).append(ENTER);
        }
        return result.toString();
    }
}
