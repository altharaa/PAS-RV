package com.example.pasproject.model;

public class MovieModel {
//    private String mvTitle;
//    private String mvReleasedDate;
//    private String mvPoster;
//    private String mvOverview;
//    private String mvLanguage;
    String categoryTitle;

//
////    get-set Movia name/title
//    public String getMovieName() {return mvTitle;}
//
//    public void setMovieName(String mvTitle) {
//        this.mvTitle = mvTitle;
//    }
//
////      get-set Movie Released date
//    public String getReleasedDate() {
//        return mvReleasedDate;
//    }
//
//    public void setReleasedDate(String mvReleasedDate) {
//        this.mvReleasedDate = mvReleasedDate;
//    }
//
////      get-set Movie Poster
//    public String getMvPoster() {return mvPoster;}
//
//    public void setMvPoster(String mvPoster) {this.mvPoster = mvPoster;}
//
////      get-set Movie Overview
//    public String getMvOverview() {return mvOverview;}
//
//    public void setMvOverview(String overview) {this.mvOverview = overview;}
//
////      get-set Movie Language
//    public String getMvLanguage() { return mvLanguage; }
//
//    public void setMvLanguage(String mvLanguage) { this.mvLanguage = mvLanguage;}

    //      constructor Category Title
    public MovieModel(String categoryTittle) {this.categoryTitle = categoryTittle;}

    //      get-set Movie Category Title
    public String getCategoryTitle() {return categoryTitle;}

    public void setCategoryTitle(String categoryTitle) {this.categoryTitle = categoryTitle;}
}
