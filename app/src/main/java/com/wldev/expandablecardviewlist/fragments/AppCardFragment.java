package com.wldev.expandablecardviewlist.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.wldev.expandablecardviewlist.R;
import com.wldev.expandablecardviewlist.adapter.AppsInfoAdapter;
import com.wldev.expandablecardviewlist.data.AppData;

import java.util.ArrayList;

/**
 * Use the {@link AppCardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AppCardFragment extends ListFragment{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM_APPSINFO = "param_appsinfo";

    public AppsInfoAdapter getAdapter() {
        return adapter;
    }

    AppsInfoAdapter adapter;

    private ArrayList<AppData> mParamAppsinfo;


    public AppCardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment AppCardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AppCardFragment newInstance(String mParamAppsinfo) {
        AppCardFragment fragment = new AppCardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM_APPSINFO, mParamAppsinfo);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppData appinfo = new AppData("pack", "name");
        ArrayList<AppData> appData = new ArrayList<AppData>();
        appData.add(appinfo);
        adapter = new AppsInfoAdapter(appData, getActivity(), R.layout.fragment_app_card);
        setListAdapter(adapter);
        if (getArguments() != null) {
            mParamAppsinfo = (ArrayList<AppData>)getArguments().getSerializable(ARG_PARAM_APPSINFO);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_app_card, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mParamAppsinfo = (ArrayList<AppData>)getArguments().getSerializable(ARG_PARAM_APPSINFO);
        Log.w("fragment", "view apps fragment");
        //mParamAppsinfo.add(new AppData("package", "app name"));
        adapter.refresh(mParamAppsinfo);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
    }
}
