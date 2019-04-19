package com.wldev.expandablecardviewlist;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.wldev.expandablecardviewlist.data.Item;
import com.wldev.expandablecardviewlist.databinding.ActivityMainBinding;
import com.wldev.expandablecardviewlist.recyclerview.ExpandableRecyclerViewAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final ArrayList<Item> arrayList = new ArrayList<>();

        //arrayList.add(new Item("系统信息", systemInfo.getSystemInfo()));
        //arrayList.add(new Item("用户信息", getString(R.string.second_plan)));
        //arrayList.add(new Item("App信息", getString(R.string.third_plan)));
        //arrayList.add(new Item("位置信息", getString(R.string.full_plan)));

        // 系统硬件获取测试
        //CollectAllInfo collectAllInfo = new CollectAllInfo(this);
        //arrayList.add(new Item("硬件信息", collectAllInfo.getAllInfo(MainActivity.this)));

        // 获取系统信息测试
        /**
         SystemInfo systemInfo = new SystemInfo(MainActivity.this);
         arrayList.add(new Item("系统信息", systemInfo.getSystemInfo()));


         // 获取传感器信息测试
         SensorInfo sensorInfo = new SensorInfo(this);
         arrayList.add(new Item("传感器信息", sensorInfo.getInfo()));

         // 获取系统安装APP测试
         ApplicationInfo applicationInfo = new ApplicationInfo(this);
         arrayList.add(new Item("安装APP信息", applicationInfo.getInfo()));
         **/


        binding.recyclerView.setAdapter(new ExpandableRecyclerViewAdapter(arrayList));
    }
}
