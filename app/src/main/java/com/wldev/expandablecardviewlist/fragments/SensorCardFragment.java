package com.wldev.expandablecardviewlist.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.wldev.expandablecardviewlist.R;
import com.wldev.expandablecardviewlist.adapter.SensorInfoAdapter;
import com.wldev.expandablecardviewlist.data.SensorData;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SensorCardFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SensorCardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SensorCardFragment extends ListFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM_SENSORINFO = "param_sensorinfo";
    SensorInfoAdapter adapter;

    private ArrayList<SensorData> mParamSensorsinfo;


    public SensorCardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment AppInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SensorCardFragment newInstance(String mParamSensorsinfo) {
        SensorCardFragment fragment = new SensorCardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM_SENSORINFO, mParamSensorsinfo);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SensorData appinfo = new SensorData("name", "factory", "detail");
        ArrayList<SensorData> sensorData = new ArrayList<SensorData>();
        sensorData.add(appinfo);
        adapter = new SensorInfoAdapter(sensorData, getActivity(), R.layout.fragment_sensor_card);
        setListAdapter(adapter);
        if (getArguments() != null) {
            mParamSensorsinfo = (ArrayList<SensorData>)getArguments().getSerializable(ARG_PARAM_SENSORINFO);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sensor_card, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mParamSensorsinfo = (ArrayList<SensorData>)getArguments().getSerializable(ARG_PARAM_SENSORINFO);
        Log.w("fragment", "view apps fragment");
        adapter.refresh(mParamSensorsinfo);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
    }
}
