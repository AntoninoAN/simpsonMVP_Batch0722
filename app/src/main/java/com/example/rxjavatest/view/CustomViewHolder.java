package com.example.rxjavatest.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rxjavatest.R;

public class CustomViewHolder
        extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView textView;
    public CustomViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.iv_character_item);
        textView = itemView.findViewById(R.id.tv_character_item);

    }
}
