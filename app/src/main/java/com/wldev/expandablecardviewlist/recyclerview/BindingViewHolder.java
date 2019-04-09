package com.wldev.expandablecardviewlist.recyclerview;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;


public class BindingViewHolder<ViewBinding extends ViewDataBinding> extends RecyclerView.ViewHolder {

    private ViewBinding binding;

    public BindingViewHolder(ViewBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public BindingViewHolder(@LayoutRes int layout, ViewGroup parent) {
        this(DataBindingUtil.<ViewBinding>inflate(LayoutInflater.from(parent.getContext()), layout, parent, false));
    }

    public ViewBinding getBinding() {
        return binding;
    }
}

