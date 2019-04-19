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
import com.wldev.expandablecardviewlist.data.DeviceData;

import java.util.ArrayList;
import java.util.List;

public class DeviceInfoAdapter extends ArrayAdapter<DeviceData> {
    private final LayoutInflater mInflater;
    private ArrayList<DeviceData> deviceDatas;

    public DeviceInfoAdapter(ArrayList<DeviceData> deviceDatas, @NonNull Context context, int resource) {
        super(context, resource);
        this.deviceDatas = deviceDatas;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(List<DeviceData> data) {
        clear();
        if (data != null) {
            for (DeviceData deviceData : data)
                add(deviceData);
        }
    }

    @Override
    public int getCount() {
        return this.deviceDatas.size();
    }

    @Override
    public DeviceData getItem(int position) {
        return this.deviceDatas.get(position);
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
            view = mInflater.inflate(R.layout.itemcard_deviceinfo, parent, false);
        else
            view = convertView;
        DeviceData deviceData = this.deviceDatas.get(position);
        ((TextView) view.findViewById(R.id.tv_device_label)).setText(deviceData.getLabelName());
        ((TextView) view.findViewById(R.id.tv_device_value)).setText(deviceData.getLabelValue());
        return view;
    }

    public void refresh(ArrayList<DeviceData> deviceDatas) {
        this.deviceDatas = deviceDatas;
        notifyDataSetChanged();
    }
}

