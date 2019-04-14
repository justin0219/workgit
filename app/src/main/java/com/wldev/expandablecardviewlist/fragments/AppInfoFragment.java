package com.wldev.expandablecardviewlist.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.wldev.expandablecardviewlist.NaviActivity;
import com.wldev.expandablecardviewlist.R;
import com.wldev.expandablecardviewlist.adapter.AppsInfoAdapter;
import com.wldev.expandablecardviewlist.data.AppsInfo;
import com.yydcdut.markdown.syntax.text.TextFactory;
import com.yydcdut.rxmarkdown.RxMarkdown;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Use the {@link AppInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AppInfoFragment extends ListFragment{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM_APPSINFO = "param_appsinfo";
    AppsInfoAdapter adapter;

    private ArrayList<AppsInfo> mParamAppsinfo;


    public AppInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment AppInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AppInfoFragment newInstance(String mParamAppsinfo) {
        AppInfoFragment fragment = new AppInfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM_APPSINFO, mParamAppsinfo);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppsInfo appinfo = new AppsInfo("pack", "name");
        ArrayList<AppsInfo> appsInfos = new ArrayList<AppsInfo>();
        appsInfos.add(appinfo);
        adapter = new AppsInfoAdapter(appsInfos, getActivity(), R.layout.fragment_app_info);
        setListAdapter(adapter);
        if (getArguments() != null) {
            mParamAppsinfo = (ArrayList<AppsInfo>)getArguments().getSerializable(ARG_PARAM_APPSINFO);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_app_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mParamAppsinfo = (ArrayList<AppsInfo>)getArguments().getSerializable(ARG_PARAM_APPSINFO);
        Log.w("fragment", "view apps fragment");
        adapter.refresh(mParamAppsinfo);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
    }
}
