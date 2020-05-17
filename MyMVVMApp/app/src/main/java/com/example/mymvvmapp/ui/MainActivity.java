package com.example.mymvvmapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.example.mymvvmapp.R;
import com.example.mymvvmapp.adapters.MovieAdapter;
import com.example.mymvvmapp.pojos.Movie;
import com.example.mymvvmapp.viewmodels.MovieViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    MovieViewModel viewModel;
    RecyclerView recyclerView;
    MovieAdapter movieAdapter;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar2);
        viewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        viewModel.getMovies();
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setHasFixedSize(true);
        movieAdapter = new MovieAdapter(getApplicationContext());


       // recyclerView.setVisibility(View.GONE);
        viewModel.mutableLiveData.observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                progressBar.setVisibility(View.GONE);
                movieAdapter.setList(movies);
                recyclerView.setAdapter(movieAdapter);
            }
        });


    }
}
