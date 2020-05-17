package com.example.mymvvmapp;

import androidx.lifecycle.MutableLiveData;

import com.example.mymvvmapp.pojos.Movie;

import java.util.List;

public class Repo {
    private ApiProvider apiProvider = new ApiProvider();
    public MutableLiveData<List<Movie>> getData(){
        return apiProvider.getMovies();
    }
}
