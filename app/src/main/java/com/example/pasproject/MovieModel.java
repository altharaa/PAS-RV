package com.example.pasproject;

public class MovieModel {
    private String movieName;
    private String releasedDate;
    private String mvPoster;
    private String mvOverview;

    public String getMovieName() {return movieName;}

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(String releasedDate) {
        this.releasedDate = releasedDate;
    }

    public String getMvPoster() {return mvPoster;}

    public void setMvPoster(String mvPoster) {this.mvPoster = mvPoster;}

    public String getMvOverview() {return mvOverview;}

    public void setMvOverview(String overview) {this.mvOverview = overview;}

}
