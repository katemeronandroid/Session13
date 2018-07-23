package com.firstexample.emarkova.session13;

import android.support.v7.widget.RecyclerView;


import com.firstexample.emarkova.session13.databinding.ItemLayoutBinding;


class MyViewHolder extends RecyclerView.ViewHolder {
    private ItemLayoutBinding binding;

    public MyViewHolder(ItemLayoutBinding binding) {
        super(binding.getRoot());
        this.binding = binding;

    }

    public ItemLayoutBinding getBinding() {
        return binding;
    }

    public void setBinding(ItemLayoutBinding binding) {
        this.binding = binding;
    }
}
