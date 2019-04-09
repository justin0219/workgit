package com.example.deviceinfocollector.systeminfo;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Environment;
import android.os.StatFs;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.text.format.Formatter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static android.content.Context.TELEPHONY_SERVICE;

/**
 * @author wh1t3P1g
 * @since 2019-04-09
 */
public class SystemInfo {

    private AppCompatActivity mainActivity;

    public SystemInfo(AppCompatActivity mainActivity){
        this.mainActivity = mainActivity;
    }

    public String getAllInfo() {
        // TODO Auto-generated method stub
//        getAvailMemory();// 获取手机可用内存大小
//        getTotalMemory();//获取总内存大小
//        getHeightAndWidth();//获取屏幕宽高
//        getInfo();//获取IMEI号，IESI号，手机型号
//        getMacAddress();//获取手机型号
//        getCpuInfo();//手机CPU信息
//        getPackage();//获取软件包名,版本名，版本号
//        isRoot();//手机是否root
        String text = getHeightAndWidth() +
                "\n" + getTotalMemory() +
                "\n" + getAvailMemory() +
                "\n" + getInfo() +
                "\n" + getCpuInfo() +
                "\n" + getPackage() +
                "\n" + isRoot();

        return text;

    }
    /**
     * 获取软件包名,版本名，版本号
     */
    private String getPackage() {

        try {
            String pkName = this.mainActivity.getPackageName();
            String versionName = this.mainActivity.getPackageManager().getPackageInfo(
                    pkName, 0).versionName;
            int versionCode = this.mainActivity.getPackageManager()
                    .getPackageInfo(pkName, 0).versionCode;
            return "Package:" + pkName + "\nversionName:" + versionName + "\nversionCode:" + versionCode;
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * 获取手机是否root信息
     *
     * @return
     */
    private String isRoot() {

        String bool = "Root:false";
        try {
            if ((!new File("/system/bin/su").exists()) && (!new File("/system/xbin/su").exists())) {
                bool = "Root:false";
            } else {
                bool = "Root:true";
            }
        } catch (Exception e) {
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
        return "当前可用内存：" + Formatter.formatFileSize(this.mainActivity, blockSize * availableBlocks);
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
            initial_memory = Integer.valueOf(arrayOfString[1]).intValue() * 1024;// 获得系统总内存，单位是KB，乘以1024转换为Byte
            localBufferedReader.close();
        } catch (IOException e) {
        }
        return "总内存大小：" + Formatter.formatFileSize(this.mainActivity.getBaseContext(), initial_memory);// Byte转换为KB或者MB，内存大小规格化
    }

    /**
     * 获得手机屏幕宽高
     *
     * @return
     */
    public String getHeightAndWidth() {
        int width = this.mainActivity.getWindowManager().getDefaultDisplay().getWidth();
        int heigth = this.mainActivity.getWindowManager().getDefaultDisplay().getHeight();
        String str = "Width:" + width + "\nHeight:" + heigth + "";
        return str;
    }

    /**
     * 获取IMEI号，IESI号，手机型号
     */
    private String getInfo() {
        TelephonyManager mTm = (TelephonyManager) this.mainActivity.getSystemService(TELEPHONY_SERVICE);
        String mtype = android.os.Build.MODEL; // 手机型号
        String mtyb = android.os.Build.BRAND;//手机品牌
        return "手机型号：" + mtype + "\n手机品牌：" + mtyb;
    }

    /**
     * 获取手机MAC地址
     * 只有手机开启wifi才能获取到mac地址
     */
    private String getMacAddress() {
        String result = "";
        WifiManager wifiManager = (WifiManager) this.mainActivity.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        ;
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        result = wifiInfo.getMacAddress();
        return "手机macAdd:" + result;
    }

    private String getCpuInfo() {
        String str1 = "/proc/cpuinfo";
        String str2 = "";
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
        } catch (IOException e) {
        }
        return "CPU频率：" + cpuInfo[1];
    }
}