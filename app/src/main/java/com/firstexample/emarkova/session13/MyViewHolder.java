package com.firstexample.emarkova.session13;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView mTextView;
    public TextView mTextDate;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        mTextView = itemView.findViewById(R.id.fileName);
        mTextDate = itemView.findViewById(R.id.fileDate);
    }
}
