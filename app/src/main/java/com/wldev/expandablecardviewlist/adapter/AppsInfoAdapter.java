package com.wldev.expandablecardviewlist.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.wldev.expandablecardviewlist.R;
import com.wldev.expandablecardviewlist.data.AppData;

import java.util.ArrayList;
import java.util.List;

public class AppsInfoAdapter extends ArrayAdapter<AppData> {
    private final LayoutInflater mInflater;
    private ArrayList<AppData> appData;

    public AppsInfoAdapter(ArrayList<AppData> appData, @NonNull Context context, int resource) {
        super(context, resource);
        this.appData = appData;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(List<AppData> data) {
        clear();
        if (data != null) {
            for (AppData appData : data)
                add(appData);
        }
    }


    @Override
    public int getCount() {
        return this.appData.size();
    }

    @Override
    public AppData getItem(int position) {
        return this.appData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view;

        if (convertView == null)
            view = mInflater.inflate(R.layout.itemcard_appinfo, parent, false);
        else
            view = convertView;
        AppData appinfo = this.appData.get(getCount() - position - 1);
        ((TextView) view.findViewById(R.id.item_apps_pkg)).setText(appinfo.getPackageName());
        ((TextView) view.findViewById(R.id.item_apps_name)).setText(appinfo.getAppName());
        return view;
    }

    public void refresh(ArrayList<AppData> appData) {
        this.appData = appData;
        notifyDataSetChanged();
    }
}
