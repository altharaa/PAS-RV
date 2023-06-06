package com.example.pasproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.pasproject.adapter.FavoriteAdapter;
import com.example.pasproject.adapter.ItemMovieAdapter;
import com.example.pasproject.adapter.ShowingAdapter;
import com.example.pasproject.databinding.ActivityMainListmovieBinding;
import com.example.pasproject.model.ItemMovieModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListMovieMain extends AppCompatActivity{
    RecyclerView rvMovie;
    List<ItemMovieModel> itemMovieModelList = new ArrayList<>();
    List<ItemMovieModel> itemMovieModelList1 = new ArrayList<>();
    List<ItemMovieModel> itemMovieModelList2 = new ArrayList<>();
    ItemMovieAdapter movieAdapter;
    FavoriteAdapter movieAdapter1;
    ShowingAdapter movieAdapter2;
    ActivityMainListmovieBinding mainListmovieBinding;

    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        mainListmovieBinding = ActivityMainListmovieBinding.inflate(getLayoutInflater());
        setContentView(mainListmovieBinding.getRoot());
        getAPIMovieList(1);
        getAPIMovieList(2);
        getAPIMovieList(3);
    }

    private void getAPIMovieList(int page) {
        ProgressBar progressBar = findViewById(R.id.progress_bar);
        AndroidNetworking.get("https://api.themoviedb.org/3/movie/popular?page="+page+"&api_key=9e96256f5d1e6a4f9c415b852558c8d2")
                .setTag("test")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject jsonObject) {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                progressBar.setVisibility(View.GONE);
                            }
                        });
                        try {
                            JSONArray jsonArray = jsonObject.getJSONArray("results");
                            getList(jsonArray);
                            if (page == 1){
                                itemMovieModelList.addAll(getList(jsonArray));
                            }else if (page == 2){
                                itemMovieModelList1.addAll(getList(jsonArray));
                            }else {
                                itemMovieModelList2.addAll(getList(jsonArray));
                            }

                            setMainCategoryRecycler(itemMovieModelList,itemMovieModelList1,itemMovieModelList2);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log. d( "failed ",  "onError: "+ anError.toString());
                    }
                });
    }

    private List<ItemMovieModel> getList(JSONArray jsonArray) {
        List<ItemMovieModel> model = new ArrayList<>();
        for (int i= 0; i < jsonArray.length(); i++) {
            JSONObject movie = null;
            try {
                movie = jsonArray.getJSONObject(i);
                String title = movie.getString("title");
                String overview = movie.getString("overview");
                String releasedDt = movie.getString("release_date");
                String voteAvg = movie.getString("vote_average");
                String language = movie.getString("original_language");
                String image = movie.getString("poster_path");
                int id = movie.getInt("id");

                ItemMovieModel movieModel = new ItemMovieModel();
                movieModel.setMvTitle(title);
                movieModel.setMvOverview(overview);
                movieModel.setMvReleasedDate(releasedDt);
                movieModel.setMvVoteAvg(voteAvg);
                movieModel.setMvLanguage(language);
                movieModel.setMvPOster(image);
                movieModel.setId(id);

                model.add(movieModel);
            } catch (JSONException e) {
                e.printStackTrace();
            }

        } return model;
    }

    private void setMainCategoryRecycler(List<ItemMovieModel> movieModelList, List<ItemMovieModel> movieModelList1, List<ItemMovieModel> movieModelList2) {
        rvMovie= findViewById(R.id.rvMovieParent);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL,false);
        rvMovie.setLayoutManager(layoutManager);
        mainListmovieBinding.rvMovieParent1.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        mainListmovieBinding.rvMovieParent2.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
        movieAdapter = new ItemMovieAdapter(this, movieModelList);
        movieAdapter1 = new FavoriteAdapter(this, movieModelList1);
        movieAdapter2 = new ShowingAdapter(this, movieModelList2);
        rvMovie.setAdapter(movieAdapter);
        mainListmovieBinding.rvMovieParent1.setAdapter(movieAdapter1);
        mainListmovieBinding.rvMovieParent2.setAdapter(movieAdapter2);


    }


}