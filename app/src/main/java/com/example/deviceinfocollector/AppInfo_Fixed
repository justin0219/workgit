package com.example.liuyue7.appinfo_sensor2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView show;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //show=(TextView) findViewById(R.id.textview02);
        TextView tx2 =(TextView)findViewById(R.id.textview02);
        tx2.setMovementMethod(ScrollingMovementMethod.getInstance());
        //给ViewText添加滚动条
        PackageManager pm=getPackageManager();
        List<PackageInfo> list2=pm.getInstalledPackages(PackageManager.GET_UNINSTALLED_PACKAGES);

        for (PackageInfo packageInfo:list2) {
            String appName = packageInfo.applicationInfo.loadLabel(getPackageManager()).toString();
            String packageName = packageInfo.packageName;


            /*if (appName.contains("信息")||appName.contains("短信")) {
                show.setText(show.getText() + "\n" + appName + "\n" + packageName);
            }*/
            tx2.setText(tx2.getText() + "\n" + appName + "\n" + packageName);
        }
    }
}










