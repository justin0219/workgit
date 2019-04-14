package com.wldev.expandablecardviewlist.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wldev.expandablecardviewlist.R;
import com.yydcdut.markdown.syntax.text.TextFactory;
import com.yydcdut.rxmarkdown.RxMarkdown;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 */
public class SensorInfoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM_SENSORINFO = "param_sensorinfo";

    // TODO: Rename and change types of parameters
    private String mParamSensorinfo;

    public SensorInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment SystemInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SensorInfoFragment newInstance(String mParamSensorinfo) {
        SensorInfoFragment fragment = new SensorInfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM_SENSORINFO, mParamSensorinfo);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParamSensorinfo = getArguments().getString(ARG_PARAM_SENSORINFO);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sensor_info, container, false);
        final TextView mtextview = (TextView) view.findViewById(R.id.text_sensorinfo);
        mtextview.setMovementMethod(ScrollingMovementMethod.getInstance());
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mParamSensorinfo = getArguments().getString(ARG_PARAM_SENSORINFO);
        final TextView mtextview = ((TextView)view.findViewById(R.id.text_sensorinfo));
        Log.w("fragment", "view sensor fragment");
        RxMarkdown.with(mParamSensorinfo, getActivity())
                .factory(TextFactory.create())
                .intoObservable()
                .subscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<CharSequence>() {
                    @Override
                    public void onCompleted() {}

                    @Override
                    public void onError(Throwable e) {}

                    @Override
                    public void onNext(CharSequence charSequence) {
                        mtextview.setText(charSequence, TextView.BufferType.SPANNABLE);
                    }
                });
    }
}
