package com.wldev.expandablecardviewlist.fragments;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.deviceinfocollector.systeminfo.SystemInfo;
import com.wldev.expandablecardviewlist.MainActivity;
import com.wldev.expandablecardviewlist.R;
import com.yydcdut.markdown.MarkdownProcessor;
import com.yydcdut.markdown.callback.OnLinkClickCallback;
import com.yydcdut.markdown.callback.OnTodoClickCallback;
import com.yydcdut.markdown.loader.DefaultLoader;
import com.yydcdut.markdown.syntax.text.TextFactory;
import com.yydcdut.markdown.theme.ThemeDefault;
import com.yydcdut.rxmarkdown.RxMDConfiguration;
import com.yydcdut.rxmarkdown.RxMarkdown;

import org.w3c.dom.Text;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 */
public class DeviceInfoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM_DEVICE = "param_device";

    // TODO: Rename and change types of parameters
    private String mParamDevice;
    public DeviceInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DeviceInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DeviceInfoFragment newInstance(String param_dev) {
        DeviceInfoFragment fragment = new DeviceInfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM_DEVICE, param_dev);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParamDevice = getArguments().getString(ARG_PARAM_DEVICE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_device_info, container, false);
        final TextView mtextview = (TextView) view.findViewById(R.id.text_deviceinfo);
        mtextview.setMovementMethod(ScrollingMovementMethod.getInstance());
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mParamDevice = getArguments().getString(ARG_PARAM_DEVICE);
        final TextView mtextview = (TextView) view.findViewById(R.id.text_deviceinfo);
        RxMarkdown.with(mParamDevice, getActivity())
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
