package com.example.pasproject;

public class MovieModel {
    private String mvTitle;
    private String mvReleasedDate;
    private String mvPoster;
    private String mvOverview;
    private String mvLanguage;


    public String getMovieName() {return mvTitle;}

    public void setMovieName(String mvTitle) {
        this.mvTitle = mvTitle;
    }

    public String getReleasedDate() {
        return mvReleasedDate;
    }

    public void setReleasedDate(String mvReleasedDate) {
        this.mvReleasedDate = mvReleasedDate;
    }

    public String getMvPoster() {return mvPoster;}

    public void setMvPoster(String mvPoster) {this.mvPoster = mvPoster;}

    public String getMvOverview() {return mvOverview;}

    public void setMvOverview(String overview) {this.mvOverview = overview;}

    public String getMvLanguage() { return mvLanguage; }

    public void setMvLanguage(String mvLanguage) { this.mvLanguage = mvLanguage;}

}
