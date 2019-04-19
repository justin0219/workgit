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
import com.wldev.expandablecardviewlist.data.SensorData;

import java.util.ArrayList;
import java.util.List;

public class SensorInfoAdapter extends ArrayAdapter<SensorData> {
    private final LayoutInflater mInflater;
    private ArrayList<SensorData> sensorData;

    public SensorInfoAdapter(ArrayList<SensorData> sensorData, @NonNull Context context, int resource) {
        super(context, resource);
        this.sensorData = sensorData;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setData(List<SensorData> data) {
        clear();
        if (data != null) {
            for (SensorData sensorData : data)
                add(sensorData);
        }
    }


    @Override
    public int getCount() {
        return this.sensorData.size();
    }

    @Override
    public SensorData getItem(int position) {
        return this.sensorData.get(position);
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
            view = mInflater.inflate(R.layout.itemcard_sensorinfo, parent, false);
        else
            view = convertView;
        SensorData sensorData = this.sensorData.get(getCount() - position - 1);
        ((TextView) view.findViewById(R.id.sensor_name)).setText(sensorData.getSensorName());
        ((TextView) view.findViewById(R.id.sensor_factory)).setText(sensorData.getSensorFactory());
        ((TextView) view.findViewById(R.id.sensor_detail)).setText(sensorData.getSensorDetail());
        return view;
    }

    public void refresh(ArrayList<SensorData> sensorData) {
        this.sensorData = sensorData;
        notifyDataSetChanged();
    }
}
