package com.example.mymvvmapp.rest;

import com.example.mymvvmapp.pojos.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IMovie {
    @GET("json/movies.json")
    public Call<List<Movie>> getMovies();
}
