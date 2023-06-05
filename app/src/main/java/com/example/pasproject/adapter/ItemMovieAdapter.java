package com.example.pasproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pasproject.R;
import com.example.pasproject.model.ItemMovieModel;

import java.util.List;

public class ItemMovieAdapter extends RecyclerView.Adapter<ItemMovieAdapter.ItemMovieViewHolder> {

    private Context context;
    private List<ItemMovieModel> itemMovieModelList;

    public ItemMovieAdapter(Context context, List<ItemMovieModel> itemMovieAdapterList) {
        this.context = context;
        this.itemMovieModelList = itemMovieModelList;
    }

    @NonNull
    @Override
    public ItemMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemMovieViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_item_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemMovieViewHolder holder, int position) {
        final ItemMovieModel itemMovieModel = this.itemMovieModelList.get(position);
        Glide.with(holder.itemView.getContext()).load(itemMovieModel.getMvPoster()).into(holder.ivPoster);
    }

    @Override
    public int getItemCount() {
        return itemMovieModelList.size();
    }

    public static final class ItemMovieViewHolder extends RecyclerView.ViewHolder{

        ImageView ivPoster;

        public ItemMovieViewHolder(@NonNull View itemView) {
            super(itemView);

            ivPoster = itemView.findViewById(R.id.ivPosterMv);
        }
    }


}
