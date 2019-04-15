package com.wldev.expandablecardviewlist.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.HttpAuthHandler;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.wldev.expandablecardviewlist.R;
import com.wldev.expandablecardviewlist.adapter.DeviceInfoAdapter;
import com.wldev.expandablecardviewlist.adapter.SensorInfoAdapter;
import com.wldev.expandablecardviewlist.data.DeviceData;
import com.wldev.expandablecardviewlist.data.SensorData;
import com.yydcdut.markdown.syntax.text.TextFactory;
import com.yydcdut.rxmarkdown.RxMarkdown;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link DeviceCardFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link DeviceCardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DeviceCardFragment extends ListFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM_DEVICE = "param_device";

    // TODO: Rename and change types of parameters
    private ArrayList<DeviceData> mParamDevice;
    private DeviceInfoAdapter adapter;

    public DeviceInfoAdapter getAdapter() {
        return adapter;
    }

    public DeviceCardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment DeviceInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DeviceCardFragment newInstance(String param_dev) {
        DeviceCardFragment fragment = new DeviceCardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM_DEVICE, param_dev);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DeviceData deviceData = new DeviceData("label", "value");
        ArrayList<DeviceData> deviceDatas = new ArrayList<DeviceData>();
        deviceDatas.add(deviceData);
        // set adapter
        adapter = new DeviceInfoAdapter(deviceDatas, getActivity(), R.layout.fragment_device_card);
        setListAdapter(adapter);
        if (getArguments() != null) {
            mParamDevice = (ArrayList<DeviceData>) getArguments().getSerializable(ARG_PARAM_DEVICE);
        }

        /**
        final Handler refreshHandler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                // do updates for imageview
                refreshHandler.postDelayed(this, 1 * 1000);
            }
        };
        refreshHandler.postDelayed(runnable, 1 * 1000);
         **/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_device_card, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mParamDevice = (ArrayList<DeviceData>) getArguments().getSerializable(ARG_PARAM_DEVICE);
        adapter.refresh(mParamDevice);
    }
}
