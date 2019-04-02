package com.fractals.cinemanight.adapters;

import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.fractals.cinemanight.R;
import com.fractals.cinemanight.activities.MovieDetailActivity;
import com.fractals.cinemanight.models.Movie;
import com.fractals.cinemanight.util.FinalConstants;

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
//        Glide.with(movieViewHolder.moviePoster.getContext()).load(movie.getPosterUrl())
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(movieViewHolder.moviePoster);
    }

    @Override
    public int getItemCount() {
        return movieList != null ? movieList.size() : 0;
    }

    private class MovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView moviePoster;

        MovieViewHolder(View itemView) {
            super(itemView);
            moviePoster = (ImageView) itemView.findViewById(R.id.single_movie_poster);

            moviePoster.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (view.getId() == moviePoster.getId()) {
                Intent i = new Intent(view.getContext(), MovieDetailActivity.class);
                i.putExtra(FinalConstants.movieTag, movieList.get(getAdapterPosition()));
                i.putExtra(FinalConstants.similarMoviesTag, (new Parcelable[]{movieList.get(0), movieList.get(1), movieList.get(2)}));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    //For Shared Element Transition
                    ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(null, view.findViewById(R.id.single_movie_poster), "sharedTransition");
                    view.getContext().startActivity(i, optionsCompat.toBundle());
                } else {
                    view.getContext().startActivity(i);
                }
            }
        }

    }

}