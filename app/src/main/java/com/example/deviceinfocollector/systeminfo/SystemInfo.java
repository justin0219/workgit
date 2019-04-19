package com.example.deviceinfocollector.systeminfo;


import android.os.Environment;
import android.os.StatFs;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Formatter;

import com.wldev.expandablecardviewlist.data.SystemData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import github.nisrulz.easydeviceinfo.base.EasyDeviceMod;

/**
 * @author Frank
 * @author wh1t3P1g
 * * @since 2019-04-09
 * * description: 1. 填充UI； 2. 硬件信息获取； 3. 硬件信息填充；
 * <p>
 * * @author Frank
 * * @since 2019-04-09
 * * description: 1. 系统信息获取；
 * @since 2019-04-09
 * description: 1. 修复换行；2. System infor信息填充；
 */
public class SystemInfo {

    private AppCompatActivity mainActivity;
    private static String MTAB = "\n";

    public SystemInfo(AppCompatActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    private String getSystemInfo() {
        return "## " + "System information" + MTAB + MTAB +
                getHeight() +
                MTAB + getWidth() +
                MTAB + getAvailMemory() +
                MTAB + getPhoneInfo() +
                MTAB + getDriveInfo() +
                MTAB+ getModelInfo() +
                MTAB + getSystemAPInfo() +
                MTAB + getVersionStringInfo() +
                MTAB + getProductInfo() +
                MTAB + getBoardInfo() +
                MTAB + getUInfo() +
                MTAB + getCpuInfo() +
                MTAB + getSoftPackage() +
                MTAB + getVersionNumber() +
                MTAB + isRoot() +
                MTAB + getBrandInfo() +
                MTAB + getHostInfo() +
                MTAB + getTagInfo() +
                MTAB + getFingerprintInfo();

    }

    /**
     * 获取软件包名,版本名，版本号
     */
    private String getSoftPackage() {

        try {
            String pkName = this.mainActivity.getPackageName();
            return "软件包: " + pkName;
        } catch (Exception ignored) {
        }
        return null;
    }


    private String getVersionNumber() {

        EasyDeviceMod easyDeviceMod = new EasyDeviceMod(this.mainActivity);
        String versionCode = easyDeviceMod.getOSVersion();
        return "版本号: " + versionCode;
    }


    /**
     * 获取系统 Product、Board 信息、指纹信息
     */
    private String getProductInfo() {
        EasyDeviceMod easyDeviceMod = new EasyDeviceMod(this.mainActivity);
        String OSCodeName = easyDeviceMod.getProduct();
        //return "Product 名称: " + OSCodeName;
        return OSCodeName;
    }

    private String getBoardInfo() {
        EasyDeviceMod easyDeviceMod = new EasyDeviceMod(this.mainActivity);
        String SBoard = easyDeviceMod.getBoard();
        // "Board 信息: " +
        return SBoard;
    }

    private String getFingerprintInfo() {
        EasyDeviceMod easyDeviceMod = new EasyDeviceMod(this.mainActivity);
        String Finger = easyDeviceMod.getFingerprint();
        // "指纹信息: " +
        return Finger;
    }

    /**
     * 获取系统 Brand 信息、Host 信息、Tag 信息
     */
    private String getBrandInfo() {
        EasyDeviceMod easyDeviceMod = new EasyDeviceMod(this.mainActivity);
        String Brand = easyDeviceMod.getBuildBrand();
        // "Brand 信息: " +
        return Brand;
    }

    private String getHostInfo() {
        EasyDeviceMod easyDeviceMod = new EasyDeviceMod(this.mainActivity);
        String Host = easyDeviceMod.getBuildHost();
        // "Host 信息: " +
        return Host;
    }

    private String getTagInfo() {
        EasyDeviceMod easyDeviceMod = new EasyDeviceMod(this.mainActivity);
        String Tag = easyDeviceMod.getBuildTags();
        // "Tag 信息: " +
        return Tag;
    }


    /**
     * 获取手机是否root信息
     */
    private boolean isRoot() {

        // String bool = "Root: 未 Root";
        boolean disRooted = false;
        try {
            disRooted = (new File("/system/bin/su").exists()) || (new File("/system/xbin/su").exists());
        } catch (Exception ignored) {
        }
        return disRooted;
    }


    /**
     * 获取android当前可用内存大小
     */
    private String getAvailMemory() {// 获取android当前可用内存大小
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long availableBlocks = stat.getAvailableBlocks();
        // "当前可用内存: " +
        return Formatter.formatFileSize(this.mainActivity, blockSize * availableBlocks);
    }


    /**
     * 获得系统总内存
     */
    private String getTotalMemory() {
        String str1 = "/proc/meminfo";// 系统内存信息文件
        String str2;
        String[] arrayOfString;
        long initial_memory = 0;
        try {
            FileReader localFileReader = new FileReader(str1);
            BufferedReader localBufferedReader = new BufferedReader(
                    localFileReader, 8192);
            str2 = localBufferedReader.readLine();// 读取meminfo第一行，系统总内存大小

            arrayOfString = str2.split("\\s+");
            initial_memory = Integer.valueOf(arrayOfString[1]) * 1024;// 获得系统总内存，单位是KB，乘以1024转换为Byte
            localBufferedReader.close();
        } catch (IOException ignored) {
        }
        // "总内存大小: " +
        return Formatter.formatFileSize(this.mainActivity.getBaseContext(), initial_memory);// Byte转换为KB或者MB，内存大小规格化
    }

    /**
     * 获得手机屏幕宽高
     */
    private String getHeight() {
        int heigth = this.mainActivity.getWindowManager().getDefaultDisplay().getHeight();
        // "屏幕高度: " +
        return heigth + "";
    }

    private String getWidth() {
        int width = this.mainActivity.getWindowManager().getDefaultDisplay().getWidth();
        // "屏幕宽度: "
        return + width + "";
    }


    /**
     * 获取手机型号
     */
    private String getPhoneInfo() {
        String mtyb = android.os.Build.BRAND;//手机品牌
        // "手机品牌: " +
        return mtyb;
    }

    private String getDriveInfo() {
        String mdrive = android.os.Build.DEVICE;//设备驱动
        // "设备驱动: " +
        return mdrive;
    }


    /**
     * 获取系统用户名
     */
    private String getUInfo() {
        String muser = android.os.Build.USER; //设备用户名
        // "系统用户名: " +
        return muser;
    }

    /**
     * 获取系统版本
     */
    private String getModelInfo() {
        String mtype = android.os.Build.MODEL; // 系统型号
        // "系统型号: " +
        return mtype;
    }

    private String getVersionStringInfo() {
        String msvs = android.os.Build.VERSION.RELEASE; //系统版本字符串
        // "系统版本: 安卓 " +
        return msvs;
    }

    private String getSystemAPInfo() {
        String msapi = android.os.Build.VERSION.SDK; //系统API
        // "系统API版本: " +
        return msapi;
    }

    private String getCpuInfo() {
        String str1 = "/proc/cpuinfo";
        String str2;
        String[] cpuInfo = {"", ""};  //1-cpu型号  //2-cpu频率
        String[] arrayOfString;
        try {
            FileReader fr = new FileReader(str1);
            BufferedReader localBufferedReader = new BufferedReader(fr, 8192);
            str2 = localBufferedReader.readLine();
            arrayOfString = str2.split("\\s+");
            for (int i = 2; i < arrayOfString.length; i++) {
                cpuInfo[0] = cpuInfo[0] + arrayOfString[i] + " ";
            }
            str2 = localBufferedReader.readLine();
            arrayOfString = str2.split("\\s+");
            cpuInfo[1] += arrayOfString[2];
            localBufferedReader.close();
        } catch (IOException ignored) {
        }
        // "CPU频率: " +
        return cpuInfo[1];
    }

    public ArrayList<SystemData> getSystemDatas()
    {
        ArrayList<SystemData> systemDatas = new ArrayList<>();
        systemDatas.add(new SystemData("size(hight X width)", getHeight() + " X " + getWidth()));
        systemDatas.add(new SystemData("avail memory", getAvailMemory()));
        systemDatas.add(new SystemData("phone info", getPhoneInfo()));
        systemDatas.add(new SystemData("driver", getDriveInfo()));
        systemDatas.add(new SystemData("model", getModelInfo()));
        systemDatas.add(new SystemData("api version", getSystemAPInfo()));
        systemDatas.add(new SystemData("release number", getVersionStringInfo()));
        systemDatas.add(new SystemData("product", getProductInfo()));
        systemDatas.add(new SystemData("board", getBoardInfo()));
        systemDatas.add(new SystemData("ui", getUInfo()));
        systemDatas.add(new SystemData("cpu", getCpuInfo()));
        systemDatas.add(new SystemData("package", getSoftPackage()));
        systemDatas.add(new SystemData("version number", getVersionNumber()));
        systemDatas.add(new SystemData("is rooted", Boolean.toString(isRoot())));
        systemDatas.add(new SystemData("brand info", getBrandInfo()));
        systemDatas.add(new SystemData("host", getHostInfo()));
        systemDatas.add(new SystemData("tag", getTagInfo()));
        systemDatas.add(new SystemData("fingerprint", getFingerprintInfo()));
        return systemDatas;
    }
}
