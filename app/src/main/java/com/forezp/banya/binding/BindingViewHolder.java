package com.forezp.banya.binding;

import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 *
 */
public class BindingViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder{
    private T mBinding;

    public BindingViewHolder(T binding) {
        super(binding.getRoot());
        this.mBinding = binding;
    }

    public T getBinding() {
        return this.mBinding;
    }
}
