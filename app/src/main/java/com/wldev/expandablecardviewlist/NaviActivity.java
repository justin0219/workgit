package com.wldev.expandablecardviewlist;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.deviceinfocollector.applicationinfo.ApplicationInfo;
import com.example.deviceinfocollector.deviceinfo.CollectAllInfo;
import com.example.deviceinfocollector.sensorinfo.SensorInfo;
import com.example.deviceinfocollector.systeminfo.SystemInfo;
import com.wldev.expandablecardviewlist.data.AppData;
import com.wldev.expandablecardviewlist.data.DeviceData;
import com.wldev.expandablecardviewlist.data.SensorData;
import com.wldev.expandablecardviewlist.fragments.AppCardFragment;
import com.wldev.expandablecardviewlist.fragments.DeviceCardFragment;
import com.wldev.expandablecardviewlist.fragments.SensorCardFragment;
import com.wldev.expandablecardviewlist.fragments.SystemCardFragment;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class NaviActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = "NaviActivity";

    private static final String ARG_PARAM_DEVICE = "param_device";
    private static final String ARG_PARAM_SYSINFO = "param_sysinfo";
    private static final String ARG_PARAM_SENSORINFO = "param_sensorinfo";
    private static final String ARG_PARAM_APPSINFO = "param_appsinfo";

    private ArrayList<DeviceData> deviceDatas;

    DeviceCardFragment deviceCardFragment = null;
    SystemCardFragment systemCardFragment = null;
    SensorCardFragment sensorCardFragment = null;
    AppCardFragment appCardFragment = null;
    ListFragment currentFragment = null;

    boolean isDeviceFragment;
    private Handler mHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navi);

        // set device fragment
        this.deviceCardFragment = new DeviceCardFragment();
        CollectAllInfo collectAllInfo = new CollectAllInfo(NaviActivity.this);
        this.deviceDatas = collectAllInfo.getDeviceDatas();
        this.currentFragment = this.deviceCardFragment;
        Bundle data = new Bundle();
        data.putSerializable(ARG_PARAM_DEVICE, this.deviceDatas);
        this.deviceCardFragment = new DeviceCardFragment();
        if (this.deviceCardFragment != null) {
            this.deviceCardFragment.setArguments(data);
            displaySelectedFragment(this.deviceCardFragment);
            isDeviceFragment = true;
        }


        mHandler = new Handler() {

            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                ArrayList<DeviceData> mdeviceDatas = (ArrayList<DeviceData>) msg.obj;
                deviceCardFragment.getAdapter().refresh(mdeviceDatas);
            }
        };

        // timer update
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if (isDeviceFragment) {
                    DeviceCardFragment mdevFragment = deviceCardFragment;
                    if (mdevFragment != null) {
                        CollectAllInfo collectAllInfo = new CollectAllInfo(NaviActivity.this);
                        ArrayList<DeviceData> mdeviceDatas = collectAllInfo.getDeviceDatas();
                        Message message = new Message();
                        message.obj = mdeviceDatas;
                        mHandler.sendMessage(message);
                    }
                    Log.w(TAG, "update view");
                }
            }
        }, 0, 1000);

        // set toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        ListFragment fragment = null;
        this.isDeviceFragment = false;
        if (id == R.id.nav_device) {
            // get data
            CollectAllInfo collectAllInfo = new CollectAllInfo(NaviActivity.this);
            this.deviceDatas = collectAllInfo.getDeviceDatas();
            // put arguments
            Bundle data = new Bundle();
            data.putSerializable(ARG_PARAM_DEVICE, this.deviceDatas);
            if (this.deviceCardFragment == null) {
                Log.d("Navigation", "create DeviceCardFragment");
                this.deviceCardFragment = new DeviceCardFragment();
            }
            fragment = this.deviceCardFragment;
            fragment.setArguments(data);
            Log.w("navigate", "start fragment device");
            this.isDeviceFragment = true;
        } else if (id == R.id.nav_system) {
            SystemInfo systemInfo = new SystemInfo(NaviActivity.this);
            Bundle data = new Bundle();
            data.putSerializable(ARG_PARAM_SYSINFO, systemInfo.getSystemDatas());
            if (this.systemCardFragment == null)
                this.systemCardFragment = new SystemCardFragment();
            //fragment = new SystemCardFragment();
            fragment = this.systemCardFragment;
            fragment.setArguments(data);
        } else if (id == R.id.nav_sensor) {
            SensorInfo sensorInfo = new SensorInfo(NaviActivity.this);
            Bundle data = new Bundle();
            //data.putString(ARG_PARAM_SENSORINFO, sensorInfo.getInfo());
            ArrayList<SensorData> sensorData = sensorInfo.getSensorsInfo();
            data.putSerializable(ARG_PARAM_SENSORINFO, sensorData);
            if (this.sensorCardFragment == null)
                this.sensorCardFragment = new SensorCardFragment();
            fragment = this.sensorCardFragment;
            fragment.setArguments(data);
        } else if (id == R.id.nav_app) {
            ApplicationInfo applicationInfo = new ApplicationInfo(this);
            ArrayList<AppData> appData = applicationInfo.getListAppInfo();
            Bundle data = new Bundle();
            data.putSerializable(ARG_PARAM_APPSINFO, appData);
            if (this.appCardFragment == null)
                this.appCardFragment = new AppCardFragment();
            fragment = this.appCardFragment;
            fragment.setArguments(data);
        } else {
            Log.w("navigation selected", "other navigation");
            Toast.makeText(NaviActivity.this, "别点啦 不会有效果滴~", Toast.LENGTH_SHORT).show();
        }
        if (fragment != null) {
            this.currentFragment = fragment;
            displaySelectedFragment(fragment);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * Loads the specified fragment to the frame
     *
     * @param fragment
     */
    private void displaySelectedFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame, fragment);
        fragmentTransaction.commit();
    }
}
