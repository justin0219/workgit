package com.example.deviceinfocollector.deviceinfo;

import android.support.v7.app.AppCompatActivity;
import github.nisrulz.easydeviceinfo.base.EasyCpuMod;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author wh1t3P1g
 * @since 2019-04-09
 */
public class CPUInfo extends BaseInfo{

    public CPUInfo(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    public void init(){
        EasyCpuMod easyCpuMod = new EasyCpuMod();
        // 从 Build.SUPPORTED_ABIS 取
        this.info = easyCpuMod.getStringSupportedABIS();
    }

    public String getCpuInfo(){
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
