package com.example.pasproject.model;

public class ItemMovieModel {

    int mvPoster;

    public ItemMovieModel(int mvPoster) {this.mvPoster = mvPoster;}

    //    get-set Movie Poster
    public int getMvPoster() {return mvPoster;}

    public void setMvPoster(String mvPoster) {this.mvPoster = Integer.parseInt(mvPoster);}


}
