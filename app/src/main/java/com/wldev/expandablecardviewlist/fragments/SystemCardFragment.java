package com.wldev.expandablecardviewlist.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wldev.expandablecardviewlist.R;
import com.wldev.expandablecardviewlist.adapter.SystemInfoAdapter;
import com.wldev.expandablecardviewlist.data.SystemData;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SystemCardFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SystemCardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SystemCardFragment extends ListFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM_SYSINFO = "param_sysinfo";

    // TODO: Rename and change types of parameters
    private ArrayList<SystemData> mParamSysinfo;
    private SystemInfoAdapter adapter;

    public SystemCardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment SystemCardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SystemCardFragment newInstance(String mParamSysinfo) {
        SystemCardFragment fragment = new SystemCardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM_SYSINFO, mParamSysinfo);
        fragment.setArguments(args);
        return fragment;
    }

    public SystemInfoAdapter getAdapter() {
        return adapter;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SystemData systemData = new SystemData("label", "value");
        ArrayList<SystemData> systemDatas = new ArrayList<SystemData>();
        systemDatas.add(systemData);
        // set adapter
        adapter = new SystemInfoAdapter(systemDatas, getActivity(), R.layout.fragment_system_card);
        setListAdapter(adapter);
        // get args
        if (getArguments() != null) {
            mParamSysinfo = (ArrayList<SystemData>) getArguments().getSerializable(ARG_PARAM_SYSINFO);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_system_card, container, false);
        /**
         final TextView mtextview = (TextView) view.findViewById(R.id.text_systeminfo);
         mtextview.setMovementMethod(ScrollingMovementMethod.getInstance());
         **/
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mParamSysinfo = (ArrayList<SystemData>) getArguments().getSerializable(ARG_PARAM_SYSINFO);
        adapter.refresh(mParamSysinfo);
        /**
         final TextView mtextview = ((TextView)view.findViewById(R.id.text_systeminfo));
         Log.w("fragment", "view fragment system");
         RxMarkdown.with(mParamSysinfo, getActivity())
         .factory(TextFactory.create())
         .intoObservable()
         .subscribeOn(Schedulers.computation())
         .observeOn(AndroidSchedulers.mainThread())
         .subscribe(new Subscriber<CharSequence>() {
        @Override public void onCompleted() {}

        @Override public void onError(Throwable e) {}

        @Override public void onNext(CharSequence charSequence) {
        mtextview.setText(charSequence, TextView.BufferType.SPANNABLE);
        }
        });
         **/
    }
}
