package com.example.deviceinfocollector.deviceinfo;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import github.nisrulz.easydeviceinfo.base.EasyCpuMod;

/**
 * @author wh1t3P1g
 * @author chenlangping
 * @since 2019-04-09
 */
public class CPUInfo extends BaseInfo {

    private static final String TAG = "CPUInfo";

    private String abis;
    private int cpuCores = 0;
    private static String MTAB = "\n";

    CPUInfo(AppCompatActivity activity) {
        super(activity);
        setCPUAvailableProcessors();
    }

    @Override
    public void init() {
        EasyCpuMod easyCpuMod = new EasyCpuMod();
        // 从 Build.SUPPORTED_ABIS 取
        setAbis(easyCpuMod.getStringSupportedABIS());
    }

    @Override
    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("CPU: ").append(getAbis()).append(MTAB);
        info.append(getCPUCurFreq());

        Log.d(TAG, "getInfo: 进入cpu获取信息");
        return info.toString();
    }

    private String getAbis() {
        return abis;
    }

    private void setAbis(String abis) {
        this.abis = abis;
    }

    private void setCPUAvailableProcessors() {
        cpuCores = Runtime.getRuntime().availableProcessors();
    }

    private String getCPUCurFreq() {
        String cpuCurFreq;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < cpuCores; i++) {
            try {
                FileReader fr = new FileReader(
                        "/sys/devices/system/cpu/cpu" + i + "/cpufreq/scaling_cur_freq");
                BufferedReader br = new BufferedReader(fr);
                String text = br.readLine();
                cpuCurFreq = text.trim();
            } catch (IOException e) {
                e.printStackTrace();
                cpuCurFreq = "unknown";
            }
            int x = Integer.parseInt(cpuCurFreq);
            x /= 1000;
            cpuCurFreq = String.valueOf(x);
            result.append("cpu").append(i).append("   CurFreq").append("=").append(cpuCurFreq).append("MHz").append(MTAB);
        }
        return result.toString();
    }
}
