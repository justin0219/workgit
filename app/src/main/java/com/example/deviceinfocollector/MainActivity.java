package com.example.deviceinfocollector;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.deviceinfocollector.GetSystemInfo;

public class MainActivity extends AppCompatActivity {

    Button myButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myButton = (Button)findViewById(R.id.myButton);
        myButton.setOnClickListener(new MyButtonListener());
    }


    class MyButtonListener implements View.OnClickListener {
        //生成该类的对象，并将其注册到控件上。如果该控件被用户按下，就会执行onClick方法
        @Override
        public void onClick(View v) {
            //生成一个Intent对象
            Intent intent = new Intent();
            //在Intent对象当中添加一个键值对
            //intent.putExtra("testIntent", "123");
            //设置Intent对象要启动的Activity
            intent.setClass(MainActivity.this, GetSystemInfo.class);
            //通过Intent对象启动另外一个Activity
            MainActivity.this.startActivity(intent);
        }

    }

}
