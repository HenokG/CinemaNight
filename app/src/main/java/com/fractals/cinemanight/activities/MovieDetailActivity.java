package com.fractals.cinemanight.activities;

import android.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.fractals.cinemanight.R;
import com.fractals.cinemanight.adapters.MoviesRecyclerAdapter;
import com.fractals.cinemanight.api.operations.MovieApiService;
import com.fractals.cinemanight.databinding.ActivityMovieDetailBinding;
import com.fractals.cinemanight.models.Movie;
import com.fractals.cinemanight.util.FinalConstants;

import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.util.Log.i;

public class MovieDetailActivity extends AppCompatActivity {

    private Movie movie;
    private MovieApiService movieApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMovieDetailBinding movieDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_movie_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Movie added to notification bucket.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        movie = getIntent().getExtras().getParcelable(FinalConstants.movieTag);
        movieDetailBinding.setMovie(movie);

//        Glide.with(this).load(movie.getPosterUrl()).diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into((ImageView) findViewById(R.id.detail_movie_poster));

        LoadDetailOfMovieOnNewThread loadDetailOfMovieOnNewThread = new LoadDetailOfMovieOnNewThread();
        loadDetailOfMovieOnNewThread.execute(null, null, null);

        Parcelable[] similarMoviesParcelable =  getIntent().getExtras().getParcelableArray(FinalConstants.similarMoviesTag);
        Movie[] similarMovies = Movie.toMovies(similarMoviesParcelable);
        populateSimilarMovies(similarMovies);

    }

    public void onDescriptionClick(View view) {
        TextView textView = (TextView) findViewById(R.id.detail_movie_description);
        Button moreButton = (Button) findViewById(R.id.more_button);
        if (textView.getEllipsize() == null) {
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setMaxLines(6);
            moreButton.setText("More");
        } else {
            textView.setEllipsize(null);
            textView.setMaxLines(100);
            moreButton.setText("Less");
        }
    }

    private void populateSimilarMovies(Movie[] similarMovies) {
        MoviesRecyclerAdapter moviesRecyclerAdapter = new MoviesRecyclerAdapter(Arrays.asList(similarMovies));
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.similar_movies_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(moviesRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

    private class LoadDetailOfMovieOnNewThread extends AsyncTask{

        @Override
        protected Object doInBackground(Object[] objects) {
            Retrofit retrofit = new Retrofit.Builder().baseUrl(FinalConstants.testIp)
                    .addConverterFactory(GsonConverterFactory.create()).build();

            movieApiService = retrofit.create(MovieApiService.class);
            movieApiService.getDetailOfMovie(movie.getId()).enqueue(new Callback<Movie>() {
                @Override
                public void onResponse(Call<Movie> call, Response<Movie> response) {
                    movie.setDescription(response.body().getDescription());
                    movie.setBudget(response.body().getBudget());
                    movie.setCinemaOpeningDate(response.body().getCinemaOpeningDate());
                    movie.setRemovalDate(response.body().getRemovalDate());
                    movie.setPlayingDates(response.body().getPlayingDates());
                    movie.setTicketPrice(response.body().getTicketPrice());
                    i("info", ">> HenokG:: " + movie.getPlayingDates());
                }

                @Override
                public void onFailure(Call<Movie> call, Throwable throwable) {
                    i("info", ">> HenokG:: " + throwable.getMessage());
                }
            });
            return null;
        }
    }

    private class LoadTrailerOfMovieOnNewThread extends AsyncTask{

        @Override
        protected Object doInBackground(Object[] objects) {
            Retrofit retrofit = new Retrofit.Builder().baseUrl(FinalConstants.youTubeRequestUrl)
                    .addConverterFactory(GsonConverterFactory.create()).build();

            movieApiService = retrofit.create(MovieApiService.class);
            return null;
        }
    }

}