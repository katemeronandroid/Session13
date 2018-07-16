package com.firstexample.emarkova.session13;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import com.firstexample.emarkova.session13.databinding.ItemLayoutBinding;
import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter {
    List<WeatherCell> mData;
    Context context;

    public WeatherAdapter(ArrayList<WeatherCell> data, Context context) {
        this.mData = data;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ItemLayoutBinding binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.item_layout, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(binding);
        return  holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) viewHolder;
        myViewHolder.getBinding().setWeathercell(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

}
