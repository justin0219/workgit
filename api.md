# API文档

## 硬件信息获取

### 通用调用方法

1. 引入库文件`import com.example.deviceinfocollector.deviceinfo.***Info`星号用具体类名代替

2. 调用具体get函数

   ```java
   ***Info dInfo = new ***Info(activity);
   dInfo.get****();
   ```

   这里的activity指代`AppCompatActivity`类实例

   每个库文件有个统一打印所有信息的函数`getInfo`，格式为`info: value<br/>`

   

### 电池信息 

库文件: `import com.example.deviceinfocollector.deviceinfo.BatteryInfo`

可获取信息

| 信息                     | 函数                    |
| ------------------------ | ----------------------- |
| 是否正在充电             | getIsDeviceCharging()   |
| 电量百分比               | getBatteryPercentage()  |
| 电池技术                 | getBatteryTechnology()  |
| 电池温度                 | getBatteryTemperature() |
| 电池伏特量               | getBatteryVoltage()     |
| 电池健康信息             | getBatteryHealth()      |
| 电池正在通过什么设备充电 | getIsChargingVia()      |

### CPU信息

库文件：`import com.example.deviceinfocollector.deviceinfo.CPUInfo`

可获取信息

| 信息    | 函数      |
| ------- | --------- |
| CPU类型 | getAbis() |

### 通用设备信息

库文件：`import com.example.deviceinfocollector.deviceinfo.DeviceInfo`

可获取信息

| 信息           | 函数                 |
| -------------- | -------------------- |
| 主板信息       | getBoard()           |
| 显示屏ID       | getScreenDisplayID() |
| 无线电硬件版本 | getRadioVer()        |
| 产品信息       | getProduct()         |
| 设备信息       | getDevice()          |
| 硬件信息       | getHardware()        |
| 引导器信息     | getBootloader()      |
| 指纹           | getFingerprint()     |

### 显示屏信息

库文件: `import com.example.deviceinfocollector.deviceinfo.DisplayInfo`

可获取信息

| 信息         | 函数            |
| ------------ | --------------- |
| 显示器大小   | getResolution   |
| 像素点密度   | getDensity      |
| 刷新频率     | getRefreshRate  |
| 物理设备大小 | getPhysicalSize |

### 内存信息

库文件：`import com.example.deviceinfocollector.deviceinfo.MemoryInfo`

可获取信息

| 信息         | 函数                       |
| ------------ | -------------------------- |
| 总内存大小   | getTotalMemory             |
| 内联内存大小 | getTotalInternalMemorySize |
| 外部内存大小 | getTotalExternalMemorySize |

### NFC信息

库文件：`import com.example.deviceinfocollector.deviceinfo.NFCInfo`

可获取信息

| 信息        | 函数         |
| ----------- | ------------ |
| NFC是否开启 | getNfcStatus |

### sd卡信息

库文件：`import com.example.deviceinfocollector.deviceinfo.SDCardInfo`

可获取信息

| 信息         | 函数     |
| ------------ | -------- |
| 是否存在SD卡 | getHasSD |

