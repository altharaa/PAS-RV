package com.example.pasproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.pasproject.databinding.ActivityDetailMovieBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DetailPage extends AppCompatActivity {

    ActivityDetailMovieBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailMovieBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int id = getIntent().getIntExtra("id", 0);
        getAPIMovieList(id);
    }

    private void getAPIMovieList(int id) {
        ProgressBar progressBar = findViewById(R.id.progress_bar);
        AndroidNetworking.get("https://api.themoviedb.org/3/movie/"+id+"?api_key=9e96256f5d1e6a4f9c415b852558c8d2")
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
                            String title = jsonObject.getString("title");
                            String overview = jsonObject.getString("overview");
                            String releasedDt = jsonObject.getString("release_date");
                            String voteAvg = jsonObject.getString("vote_average");
                            String language = jsonObject.getString("original_language");
                            String image = jsonObject.getString("poster_path");

                            dataUI(title, overview,releasedDt, voteAvg, language, image);
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

    public void dataUI(String title, String overview, String releasedDt, String voteAvg, String language, String image) {
        binding.tvMvTitle.setText(title);
        binding.tvOverview.setText(overview);
        binding.tvMvReleaseDate.setText(releasedDt);
        binding.tvVoteAvg.setText(voteAvg);
        binding.tvMvLanguage.setText(language);
        Glide.with(DetailPage.this).load( "https://image.tmdb.org/t/p/w200" + image).apply(new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL)).into(binding.ivMvPoster);
    }
}