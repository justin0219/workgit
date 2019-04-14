package com.wldev.expandablecardviewlist.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.telephony.data.ApnSetting;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;

import com.wldev.expandablecardviewlist.R;
import com.wldev.expandablecardviewlist.data.AppsInfo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class AppsInfoAdapter extends ArrayAdapter<AppsInfo>{
    private final LayoutInflater mInflater;
    private ArrayList<AppsInfo> appsInfos;
    public AppsInfoAdapter(ArrayList<AppsInfo> appsInfos, @NonNull Context context, int resource) {
        super(context, resource);
        this.appsInfos = appsInfos;
        mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(List<AppsInfo> data)
    {
        clear();
        if(data!=null)
        {
            for(AppsInfo appsInfo:data)
                add(appsInfo);
        }
    }



    @Override
    public int getCount() {
        return this.appsInfos.size();
    }

    @Override
    public AppsInfo getItem(int position) {
        return this.appsInfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view;

        if(convertView == null)
            view = mInflater.inflate(R.layout.item_appsinfo, parent, false);
        else
            view = convertView;
        AppsInfo appinfo = this.appsInfos.get(getCount() - position - 1);
        Log.w("adapter", "get view");
        ((CheckedTextView)view.findViewById(R.id.item_apps_pkg)).setText(appinfo.getPackageName());
        ((CheckedTextView)view.findViewById(R.id.item_apps_name)).setText(appinfo.getAppName());
        return view;
    }

    public void refresh(ArrayList<AppsInfo> appsInfos)
    {
        this.appsInfos = appsInfos;
        notifyDataSetChanged();
    }
}
