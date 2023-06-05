package com.example.pasproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.pasproject.adapter.MovieAdapter;
import com.example.pasproject.model.ItemMovieModel;
import com.example.pasproject.model.MovieModel;

import java.util.ArrayList;
import java.util.List;

public class ListMovieMain extends AppCompatActivity{
    RecyclerView rvMovie;
//    ArrayList<MovieModel> listDataMovie;
    MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_main_listmovie);
//        listDataMovie = new ArrayList<>();
//        rvMovie= findViewById(R.id.rvMovieParent);

//        movieAdapter = new MovieAdapter(getApplicationContext(), listDataMovie, ListMovieMain.this);
//        movieAdapter = new MovieAdapter(getApplicationContext(), ListMovieMain.this);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext ()) ;
//        rvMovie.setLayoutManager(layoutManager);

//        dummy data
        List<ItemMovieModel> itemMovieModelList = new ArrayList<>();
        itemMovieModelList.add(new ItemMovieModel(R.drawable.slide));

        List<ItemMovieModel> itemMovieModelList1 = new ArrayList<>();
        itemMovieModelList1.add(new ItemMovieModel(R.drawable.slide));

        List<ItemMovieModel> itemMovieModelList3 = new ArrayList<>();
        itemMovieModelList3.add(new ItemMovieModel(R.drawable.slide));

        List<MovieModel> movieModelList = new ArrayList<>();
        movieModelList.add(new MovieModel("Latest Movie", itemMovieModelList));
        movieModelList.add(new MovieModel("Recently Watched", itemMovieModelList1));
        movieModelList.add(new MovieModel("Favorites", itemMovieModelList3));

        setMainCategoryRecycler(movieModelList);
    }

//    @Override
//    public void onContactSelected(MovieModel model) {
//        Toast.makeText(this, "selected movie " + model.getMovieName(), Toast.LENGTH_SHORT).show();
//    }

    private void setMainCategoryRecycler(List<MovieModel> movieModelList) {
        rvMovie= findViewById(R.id.rvMovieParent);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this) ;
        rvMovie.setLayoutManager(layoutManager);
        movieAdapter = new MovieAdapter(this, movieModelList);
        rvMovie.setAdapter(movieAdapter);
    }

//    public void getEPLOnline() {
//        ProgressBar progressBar = findViewById(R.id.progress_bar);
//        String url = "https://api.themoviedb.org/3/movie/3?api_key=c55d7a681874ffa1020ff3ab97f8c655";
//
//    }
}