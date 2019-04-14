package com.wldev.expandablecardviewlist.fragments;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
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
import com.yydcdut.markdown.callback.OnLinkClickCallback;
import com.yydcdut.markdown.callback.OnTodoClickCallback;
import com.yydcdut.markdown.loader.DefaultLoader;
import com.yydcdut.markdown.syntax.text.TextFactory;
import com.yydcdut.markdown.theme.ThemeDefault;
import com.yydcdut.rxmarkdown.RxMDConfiguration;
import com.yydcdut.rxmarkdown.RxMarkdown;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SystemInfoFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SystemInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SystemInfoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM_SYSINFO = "param_sysinfo";

    // TODO: Rename and change types of parameters
    private String mParamSysinfo;

    public SystemInfoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SystemInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SystemInfoFragment newInstance(String mParamSysinfo) {
        SystemInfoFragment fragment = new SystemInfoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM_SYSINFO, mParamSysinfo);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParamSysinfo = getArguments().getString(ARG_PARAM_SYSINFO);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_system_info, container, false);
        final TextView mtextview = (TextView) view.findViewById(R.id.text_systeminfo);
        mtextview.setMovementMethod(ScrollingMovementMethod.getInstance());
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mParamSysinfo = getArguments().getString(ARG_PARAM_SYSINFO);
        final TextView mtextview = ((TextView)view.findViewById(R.id.text_systeminfo));
        Log.w("fragment", "view fragment system");
        RxMarkdown.with(mParamSysinfo, getActivity())
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
