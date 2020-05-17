package com.example.mymvvmapp.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mymvvmapp.Repo;
import com.example.mymvvmapp.pojos.Movie;
import com.example.mymvvmapp.rest.RestClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieViewModel extends ViewModel {
    public Repo repo = new Repo();
    public MutableLiveData<List<Movie>> mutableLiveData = new MutableLiveData<>();
    public void getMovies(){
       mutableLiveData = repo.getData();
    }
}
