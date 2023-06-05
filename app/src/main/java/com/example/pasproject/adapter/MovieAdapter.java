package com.example.pasproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pasproject.R;
import com.example.pasproject.model.MovieModel;

import java.util.List;


public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MainViewHolder> {

    private Context context;
    private List<MovieModel> movieModelList;
//    private MovieAdapterListener movieAdapterListener;

    public MovieAdapter(Context context, List<MovieModel> movieModelList) {
        this.context = context;
        this.movieModelList = movieModelList;
//        this.movieAdapterListener = movieAdapterListener;
    }

    @NonNull
    @Override
    public MovieAdapter.MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(context).inflate(R.layout.activity_main_rv, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.tvCategoryTitle.setText(movieModelList.get(position).getCategoryTitle());
//        final MovieModel movieModel = this.movieModelList.get(position);
//        holder.tvTitle.setText(movieModel.getMovieName());
//        holder.tvReleasedDate.setText(movieModel.getReleasedDate());
//        holder.tvLang.setText(movieModel.getMvLanguage());
//        holder.tvOverview.setText(movieModel.getMvOverview());
//        holder.tvCategoryTitle.setText(movieModel.getCategoryTitle());
//        Glide.with(holder.itemView.getContext()).load(movieModel.getMvPoster()).into(holder.ivPoster);
    }

    @Override
    public int getItemCount() {
        return movieModelList.size();
    }

    public static final class MainViewHolder extends RecyclerView.ViewHolder{
        public TextView tvTitle, tvReleasedDate, tvOverview, tvLang, tvCategoryTitle;
        public ImageView ivPoster;
        RecyclerView recyclerView;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCategoryTitle = itemView.findViewById(R.id.tvCategoryTitle);
            recyclerView = itemView.findViewById(R.id.rvMovieChild);
//            tvTitle = itemView.findViewById(R.id.tv_mvTitle);
//            tvReleasedDate = itemView.findViewById(R.id.tv_mvReleaseDate);
//            tvLang = itemView.findViewById(R.id.tv_mvLanguage);
//            tvOverview = itemView.findViewById(R.id.tv_overview);
//            ivPoster = itemView.findViewById(R.id.iv_mvPoster);
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    // send selected contact in callback
//                    listener.onContactSelected(contactList.get(getAdapterPosition()));
//                }
//            });
        }
    }




//    public interface MovieAdapterListener {
//        void onContactSelected (MovieModel model);
//    }
}
