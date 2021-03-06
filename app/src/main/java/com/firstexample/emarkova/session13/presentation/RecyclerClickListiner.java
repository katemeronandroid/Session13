package com.firstexample.emarkova.session13.presentation;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

public abstract class RecyclerClickListiner implements RecyclerView.OnItemTouchListener {
    private GestureDetector gestureDetector;
    private GestureDetector.OnGestureListener gestureListener =
            new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }
            };
    public RecyclerClickListiner(Context context) {
        gestureDetector = new GestureDetector(context, gestureListener);
    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {
        if (gestureDetector.onTouchEvent(motionEvent)) {
            View clickedChild = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());
            if (clickedChild != null && !clickedChild.dispatchTouchEvent(motionEvent)) {
                int clickedPosition = recyclerView.getChildPosition(clickedChild);
                if (clickedPosition != RecyclerView.NO_POSITION) {
                    onItemClick(recyclerView, clickedChild, clickedPosition);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView recyclerView, @NonNull MotionEvent motionEvent) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean b) {

    }

    public abstract void onItemClick(RecyclerView recyclerView, View itemView, int position);
}
