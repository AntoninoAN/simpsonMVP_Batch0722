package com.example.rxjavatest.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.rxjavatest.R;
import com.example.rxjavatest.model.SimpsonCharacter;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CustomAdapter
        extends RecyclerView.Adapter<CustomViewHolder> {
    private ArrayList<SimpsonCharacter> dataset;
    private Context context;

    public CustomAdapter(Context context){
        this.context = context;
    }

    public void setDataset(ArrayList<SimpsonCharacter> dataset) {
        this.dataset = dataset;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CustomViewHolder(
                LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_layout,
                        parent,
                        false));
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.textView.setText(dataset.get(position).Text);
        Glide.with(context)
                .load(dataset.get(position).Icon.URL)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return dataset != null ? dataset.size() : 0;
    }
}
