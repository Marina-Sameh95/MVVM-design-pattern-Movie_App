package com.example.mymvvmapp.rest;

import com.example.mymvvmapp.pojos.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {
    private static final String BASE_URL = "https://api.androidhive.info/";
    private Retrofit retrofit ;
    private static RestClient instance;
    private IMovie iMovie;

    private RestClient() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //Q here
        iMovie = retrofit.create(IMovie.class);
    }
    public static RestClient getInstance(){
        if(instance == null){
            instance = new RestClient();
        }
        return instance;
    }

    public Call<List<Movie>> getAllMovies(){
        return iMovie.getMovies();
    }
}
