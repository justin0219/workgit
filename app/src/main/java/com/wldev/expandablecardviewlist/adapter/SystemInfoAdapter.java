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
import com.wldev.expandablecardviewlist.data.SystemData;

import java.util.ArrayList;
import java.util.List;

public class SystemInfoAdapter extends ArrayAdapter<SystemData> {
    private final LayoutInflater mInflater;
    private ArrayList<SystemData> systemDatas;

    public SystemInfoAdapter(ArrayList<SystemData> systemDatas, @NonNull Context context, int resource) {
        super(context, resource);
        this.systemDatas = systemDatas;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(List<SystemData> data) {
        clear();
        if (data != null) {
            for (SystemData systemData : data)
                add(systemData);
        }
    }

    @Override
    public int getCount() {
        return this.systemDatas.size();
    }

    @Override
    public SystemData getItem(int position) {
        return this.systemDatas.get(position);
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
            view = mInflater.inflate(R.layout.itemcard_systeminfo, parent, false);
        else
            view = convertView;
        SystemData systemData = this.systemDatas.get(position);
        ((TextView) view.findViewById(R.id.tv_system_label)).setText(systemData.getLabelName());
        ((TextView) view.findViewById(R.id.tv_system_value)).setText(systemData.getLabelValue());
        return view;
    }

    public void refresh(ArrayList<SystemData> systemDatas) {
        this.systemDatas = systemDatas;
        notifyDataSetChanged();
    }
}
