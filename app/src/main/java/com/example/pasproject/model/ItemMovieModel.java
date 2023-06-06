package com.example.pasproject.model;


public class ItemMovieModel {

    int id;
    String mvTitle;
    String mvOverview;
    String mvPOster;
    String mvReleasedDate;
    String mvLanguage;
    String mvVoteAvg;

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getMvTitle() {
        return mvTitle;
    }

    public void setMvTitle(String mvTitle) {
        this.mvTitle = mvTitle;
    }

    public String getMvOverview() {
        return mvOverview;
    }

    public void setMvOverview(String mvOverview) {
        this.mvOverview = mvOverview;
    }

    public String getMvPOster() {
        return mvPOster;
    }

    public void setMvPOster(String mvPOster) {
        this.mvPOster = mvPOster;
    }

    public String getMvReleasedDate() {
        return mvReleasedDate;
    }

    public void setMvReleasedDate(String mvReleasedDate) {
        this.mvReleasedDate = mvReleasedDate;
    }

    public String getMvLanguage() {
        return mvLanguage;
    }

    public void setMvLanguage(String mvLanguage) {this.mvLanguage = mvLanguage;}

    public String getMvVoteAvg() {
        return mvVoteAvg;
    }

    public void setMvVoteAvg(String mvVoteAvg) {
        this.mvVoteAvg = mvVoteAvg;
    }


}
