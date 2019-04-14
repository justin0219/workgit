package com.example.deviceinfocollector.systeminfo;


import android.os.Environment;
import android.os.StatFs;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Formatter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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

    public String getSystemInfo() {

        return "## " + "System information" + MTAB + MTAB +
                getHeight() +
                MTAB + getWidth() +
                MTAB + getAvailMemory() +
                MTAB + getInfo() +
                MTAB + getDriveInfo() +
                MTAB+ getSInfo() +
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
        return "Product 名称: " + OSCodeName;
    }

    private String getBoardInfo() {
        EasyDeviceMod easyDeviceMod = new EasyDeviceMod(this.mainActivity);
        String SBoard = easyDeviceMod.getBoard();
        return "Board 信息: " + SBoard;
    }

    private String getFingerprintInfo() {
        EasyDeviceMod easyDeviceMod = new EasyDeviceMod(this.mainActivity);
        String Finger = easyDeviceMod.getFingerprint();
        return "指纹信息: " + Finger;
    }

    /**
     * 获取系统 Brand 信息、Host 信息、Tag 信息
     */
    private String getBrandInfo() {
        EasyDeviceMod easyDeviceMod = new EasyDeviceMod(this.mainActivity);
        String Brand = easyDeviceMod.getBuildBrand();
        return "Brand 信息: " + Brand;
    }

    private String getHostInfo() {
        EasyDeviceMod easyDeviceMod = new EasyDeviceMod(this.mainActivity);
        String Host = easyDeviceMod.getBuildHost();
        return "Host 信息: " + Host;
    }

    private String getTagInfo() {
        EasyDeviceMod easyDeviceMod = new EasyDeviceMod(this.mainActivity);
        String Tag = easyDeviceMod.getBuildTags();
        return "Tag 信息: " + Tag;
    }


    /**
     * 获取手机是否root信息
     */
    private String isRoot() {

        String bool = "Root: 未 Root";
        try {
            if ((!new File("/system/bin/su").exists()) && (!new File("/system/xbin/su").exists())) {
                bool = "Root: 未 Root";
            } else {
                bool = "Root: 已 Root";
            }
        } catch (Exception ignored) {
        }
        return bool;
    }


    /**
     * 获取android当前可用内存大小
     */
    private String getAvailMemory() {// 获取android当前可用内存大小
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long availableBlocks = stat.getAvailableBlocks();
        return "当前可用内存: " + Formatter.formatFileSize(this.mainActivity, blockSize * availableBlocks);
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
        return "总内存大小: " + Formatter.formatFileSize(this.mainActivity.getBaseContext(), initial_memory);// Byte转换为KB或者MB，内存大小规格化
    }

    /**
     * 获得手机屏幕宽高
     */
    public String getHeight() {
        int heigth = this.mainActivity.getWindowManager().getDefaultDisplay().getHeight();
        return "屏幕高度: " + heigth + "";
    }

    public String getWidth() {
        int width = this.mainActivity.getWindowManager().getDefaultDisplay().getWidth();
        return "屏幕宽度: " + width + "";
    }


    /**
     * 获取手机型号
     */
    private String getInfo() {
        String mtyb = android.os.Build.BRAND;//手机品牌
        return "手机品牌: " + mtyb;
    }

    private String getDriveInfo() {
        String mdrive = android.os.Build.DEVICE;//设备驱动
        return "设备驱动: " + mdrive;
    }


    /**
     * 获取系统用户名
     */
    private String getUInfo() {
        String muser = android.os.Build.USER; //设备用户名
        return "系统用户名: " + muser;
    }

    /**
     * 获取系统版本
     */
    private String getSInfo() {
        String mtype = android.os.Build.MODEL; // 系统型号
        return "系统型号: " + mtype;
    }

    private String getVersionStringInfo() {
        String msvs = android.os.Build.VERSION.RELEASE; //系统版本字符串
        return "系统版本: 安卓 " + msvs;
    }

    private String getSystemAPInfo() {
        String msapi = android.os.Build.VERSION.SDK; //系统API
        return "系统API版本: " + msapi;
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
        return "CPU频率: " + cpuInfo[1];
    }
}
