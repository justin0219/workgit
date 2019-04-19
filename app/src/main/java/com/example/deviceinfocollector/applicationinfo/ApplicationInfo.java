package com.example.deviceinfocollector.applicationinfo;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

import com.wldev.expandablecardviewlist.data.AppData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ApplicationInfo {

    private final String ENTER = "\n";
    private Context context;

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

    public Map<String, String> getMapInfo() {
        StringBuilder result = new StringBuilder();
        PackageManager pm = context.getPackageManager();
        List<PackageInfo> installedPackages = pm.getInstalledPackages(PackageManager.GET_UNINSTALLED_PACKAGES);
        Map<String, String> map_info = new HashMap<String, String>();

        for (PackageInfo packageInfo : installedPackages) {
            String appName = packageInfo.applicationInfo.loadLabel(context.getPackageManager()).toString();
            String packageName = packageInfo.packageName;
            map_info.put(packageName, appName);
        }
        Iterator<Map.Entry<String, String>> entries = map_info.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, String> entry = entries.next();
            Log.w("Key = " + entry.getKey(), "Value = " + entry.getValue());
        }
        return map_info;
    }

    public ArrayList<AppData> getListAppInfo() {
        StringBuilder result = new StringBuilder();
        PackageManager pm = context.getPackageManager();
        List<PackageInfo> installedPackages = pm.getInstalledPackages(PackageManager.GET_UNINSTALLED_PACKAGES);
        ArrayList<AppData> appData = new ArrayList<AppData>();
        for (PackageInfo packageInfo : installedPackages) {
            String appName = packageInfo.applicationInfo.loadLabel(context.getPackageManager()).toString();
            String packageName = packageInfo.packageName;
            appData.add(new AppData(packageName, appName));
        }
        return appData;
    }
}
