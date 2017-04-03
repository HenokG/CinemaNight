package com.fractals.cinemanight.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.fractals.cinemanight.R;
import com.fractals.cinemanight.structural.design.Movie;

import java.util.List;

/**
 * Created by Henok G on 4/2/2017.
 */

public class MoviesRecyclerAdapter extends RecyclerView.Adapter {

    public List<Movie> movieList;

    public MoviesRecyclerAdapter(List<Movie> movieList) {
        this.movieList = movieList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_movie_layout, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        MovieViewHolder movieViewHolder = (MovieViewHolder) holder;
        Glide.with(movieViewHolder.moviePoster.getContext()).load(movie.getPosterUrl())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(movieViewHolder.moviePoster);
    }

    @Override
    public int getItemCount() {
        return movieList != null ? movieList.size() : 0 ;
    }

    private class MovieViewHolder extends RecyclerView.ViewHolder{

        private ImageView moviePoster;

        MovieViewHolder(View itemView) {
            super(itemView);
            moviePoster = (ImageView) itemView.findViewById(R.id.single_movie_poster);
        }
    }

}