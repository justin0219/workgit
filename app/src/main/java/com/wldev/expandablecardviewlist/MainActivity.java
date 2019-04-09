package com.wldev.expandablecardviewlist;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.wldev.expandablecardviewlist.data.Item;
import com.wldev.expandablecardviewlist.databinding.ActivityMainBinding;
import com.wldev.expandablecardviewlist.recyclerview.ExpandableRecyclerViewAdapter;
import com.example.deviceinfocollector.deviceinfo.CPUInfo;
import com.example.deviceinfocollector.systeminfo.SystemInfo;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final ArrayList<Item> arrayList = new ArrayList<>();
        CPUInfo cpuInfo = new CPUInfo();
        SystemInfo systemInfo = new SystemInfo(MainActivity.this);
        arrayList.add(new Item("系统信息", getString(R.string.first_plan)));
        arrayList.add(new Item("用户信息", getString(R.string.second_plan)));
        arrayList.add(new Item("App信息", getString(R.string.third_plan)));
        arrayList.add(new Item("位置信息", getString(R.string.full_plan)));
        arrayList.add(new Item("测试", cpuInfo.getCpuInfo()));
        arrayList.add(new Item("系统测试", systemInfo.getAllInfo()));
        binding.recyclerView.setAdapter(new ExpandableRecyclerViewAdapter(arrayList));
    }
}