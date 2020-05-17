package com.example.mymvvmapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mymvvmapp.R;
import com.example.mymvvmapp.pojos.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends

        RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private static final String TAG = MovieAdapter.class.getSimpleName();

    private Context context;

    private List<Movie> list = new ArrayList<>();



    public MovieAdapter(Context context) {

        this.context = context;



    }

    public void setList(List<Movie> list) {
        this.list = list;
    }



    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgView;
        TextView titleTV,rateTV,yearTV;
        public ViewHolder(View itemView) {
            super(itemView);
            imgView = itemView.findViewById(R.id.imageView);
            titleTV = itemView.findViewById(R.id.titleTV);
            rateTV = itemView.findViewById(R.id.rateTV);
            yearTV = itemView.findViewById(R.id.yearTV);

        }
    }

    @Override

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();

        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.movie_item, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;

    }

    @Override

    public void onBindViewHolder(ViewHolder holder, int position) {

        Movie item = list.get(position);
        holder.yearTV.setText(item.getReleaseYear());
        holder.titleTV.setText(item.getTitle());
        holder.rateTV.setText(""+item.getRating());
        Glide.with(context).load(item.getImage()).into(holder.imgView);



    }

    @Override

    public int getItemCount() {

        return list.size();

    }



}