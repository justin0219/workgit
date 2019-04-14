package com.wldev.expandablecardviewlist;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.deviceinfocollector.applicationinfo.ApplicationInfo;
import com.example.deviceinfocollector.deviceinfo.CollectAllInfo;
import com.example.deviceinfocollector.deviceinfo.DeviceInfo;
import com.example.deviceinfocollector.sensorinfo.SensorInfo;
import com.example.deviceinfocollector.systeminfo.SystemInfo;
import com.wldev.expandablecardviewlist.data.AppsInfo;
import com.wldev.expandablecardviewlist.data.Item;
import com.wldev.expandablecardviewlist.fragments.AppInfoFragment;
import com.wldev.expandablecardviewlist.fragments.DeviceInfoFragment;
import com.wldev.expandablecardviewlist.fragments.SensorInfoFragment;
import com.wldev.expandablecardviewlist.fragments.SystemInfoFragment;
import com.yydcdut.markdown.MarkdownProcessor;

import java.util.ArrayList;
import java.util.List;

public class NaviActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String ARG_PARAM_DEVICE = "param_device";
    private static final String ARG_PARAM_SYSINFO = "param_sysinfo";
    private static final String ARG_PARAM_SENSORINFO = "param_sensorinfo";
    private static final String ARG_PARAM_APPSINFO = "param_appsinfo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navi);

        DeviceInfoFragment fragment = new DeviceInfoFragment();

        CollectAllInfo collectAllInfo = new CollectAllInfo();
        Bundle data = new Bundle();
        data.putString(ARG_PARAM_DEVICE, collectAllInfo.getAllInfo(NaviActivity.this));
        fragment = new DeviceInfoFragment();

        if(fragment != null) {
            fragment.setArguments(data);
            displaySelectedFragment(fragment);
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Noting", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navi, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;
        if (id == R.id.nav_device) {
            CollectAllInfo collectAllInfo = new CollectAllInfo();
            Bundle data = new Bundle();
            data.putString(ARG_PARAM_DEVICE, collectAllInfo.getAllInfo(NaviActivity.this));
            fragment = new DeviceInfoFragment();
            fragment.setArguments(data);
            Log.w("navigate", "start fragment device");
        } else if (id == R.id.nav_system) {
            SystemInfo systemInfo = new SystemInfo(NaviActivity.this);
            Bundle data = new Bundle();
            data.putString(ARG_PARAM_SYSINFO, systemInfo.getSystemInfo());
            fragment = new SystemInfoFragment();
            fragment.setArguments(data);
        } else if (id == R.id.nav_sensor) {
            SensorInfo sensorInfo = new SensorInfo(NaviActivity.this);
            Bundle data = new Bundle();
            data.putString(ARG_PARAM_SENSORINFO, sensorInfo.getInfo());
            fragment = new SensorInfoFragment();
            fragment.setArguments(data);
        } else if (id == R.id.nav_app) {
            ApplicationInfo applicationInfo = new ApplicationInfo(this);
            ArrayList<AppsInfo> appinfos = applicationInfo.getListAppInfo();
            Bundle data = new Bundle();
            data.putSerializable(ARG_PARAM_APPSINFO, appinfos);
            fragment = new AppInfoFragment();
           fragment.setArguments(data);
        } else if (id == R.id.nav_share) {
        } else if (id == R.id.nav_send) {
        }
        if(fragment!=null)
        {
            displaySelectedFragment(fragment);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
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
