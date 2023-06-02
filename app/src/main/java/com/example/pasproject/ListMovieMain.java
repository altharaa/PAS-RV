package com.example.pasproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.pasproject.databinding.ActivityMainListmovieBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListMovieMain extends AppCompatActivity {
    RecyclerView rvMovie;
    ArrayList<MovieModel> ListDataMovie;

    public void getEPLOnline() {
        ProgressBar progressBar = findViewById(R.id.progress_bar);
        String url = "https://api.themoviedb.org/3/movie/3?api_key=c55d7a681874ffa1020ff3ab97f8c655";

    }
}