package com.firstexample.emarkova.session13;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter {
    ArrayList<String> mDayName = null;
    ArrayList<String> mDayTemp = null;

    public WeatherAdapter(ArrayList<String> dayName, ArrayList<String> dayTemp) {
        this.mDayName = dayName;
        this.mDayTemp = dayTemp;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_layout, viewGroup, false);
        MyViewHolder holder = new MyViewHolder(view);
        return  holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        ((MyViewHolder) viewHolder).mTextView.setText(mDayName.get(position));
        ((MyViewHolder) viewHolder).mTextDate.setText(mDayTemp.get(position));
    }

    @Override
    public int getItemCount() {
        return mDayName.size();
    }

}
