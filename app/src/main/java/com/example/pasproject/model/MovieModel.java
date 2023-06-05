package com.example.pasproject.model;

import java.util.List;

public class MovieModel {
    String categoryTitle;
    List<ItemMovieModel> itemMovieModelList;

    //      constructor Category Title
    public MovieModel(String categoryTittle,  List<ItemMovieModel> itemMovieModelList) {
        this.categoryTitle = categoryTittle;
        this.itemMovieModelList = itemMovieModelList;
    }

    //      get-set Movie Category Title
    public String getCategoryTitle() {return categoryTitle;}

    public void setCategoryTitle(String categoryTitle) {this.categoryTitle = categoryTitle;}

    //      get-set ArrayList
    public List<ItemMovieModel> getItemMovieModelList() {return itemMovieModelList;}

    public void setItemMovieModelList(List<ItemMovieModel> itemMovieModelList) {this.itemMovieModelList = itemMovieModelList;}
}
