package com.example.pasproject.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pasproject.DetailPage;
import com.example.pasproject.R;
import com.example.pasproject.model.ItemMovieModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FavoriteAdapter extends RecyclerView.Adapter<FavoriteAdapter.ItemMovieViewHolder> {

    private Context context;
    private List<ItemMovieModel> itemMovieModelList;

    public FavoriteAdapter(Context context, List<ItemMovieModel> itemMovieAdapterList) {
        this.context = context;
        this.itemMovieModelList = itemMovieAdapterList;
    }

    public static final class ItemMovieViewHolder extends RecyclerView.ViewHolder{

        ImageView image;

        public ItemMovieViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.ivPosterMv);
        }
    }

    @NonNull
    @Override
    public ItemMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemMovieViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_main_rv, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemMovieViewHolder holder, int position) {
        final ItemMovieModel itemMovieModel = this.itemMovieModelList.get(position);
        System.out.println(itemMovieModel);
        Picasso.get().load("https://image.tmdb.org/t/p/w200" + itemMovieModel.getMvPOster()).into(holder.image);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Selected Movie : " + itemMovieModel.getMvTitle(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(holder.itemView.getContext(), DetailPage.class);
                intent.putExtra("id", itemMovieModel.getId());
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return itemMovieModelList.size();
    }



}