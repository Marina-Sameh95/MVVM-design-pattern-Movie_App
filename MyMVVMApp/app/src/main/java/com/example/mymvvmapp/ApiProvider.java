package com.example.mymvvmapp;

import androidx.lifecycle.MutableLiveData;

import com.example.mymvvmapp.pojos.Movie;
import com.example.mymvvmapp.rest.RestClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiProvider {
    MutableLiveData<List<Movie>> data = new MutableLiveData<>();

    public MutableLiveData<List<Movie>> getMovies() {

        RestClient.getInstance().getAllMovies().enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                data.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {

            }
        });
        return data;
    }
}
