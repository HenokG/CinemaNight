package com.fractals.cinemanight.fragments;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fractals.cinemanight.R;
import com.fractals.cinemanight.RecyclerViewItemClickListener;
import com.fractals.cinemanight.activities.MovieDetailActivity;
import com.fractals.cinemanight.adapters.MoviesRecyclerAdapter;
import com.fractals.cinemanight.api.operations.MovieApiService;
import com.fractals.cinemanight.structural.design.Movie;
import com.fractals.cinemanight.util.FinalConstants;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.util.Log.i;

public class CurrentlyInTheaterMoviesFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private RecyclerView recyclerView;
    private MoviesRecyclerAdapter moviesRecyclerAdapter;
    private List<Movie> movieList;
    private MovieApiService movieApiService;

    public CurrentlyInTheaterMoviesFragment() {

        movieList = new ArrayList<>();
        moviesRecyclerAdapter = new MoviesRecyclerAdapter(movieList);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(FinalConstants.testIp)
                .addConverterFactory(GsonConverterFactory.create()).build();

        movieApiService = retrofit.create(MovieApiService.class);
        movieApiService.getCurrentlyInTheaterMovies().enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                movieList = response.body();
                moviesRecyclerAdapter.movieList = movieList;
                if(movieList != null && movieList.size() > 0){
                    for (int i = 0; i < movieList.size(); i++) {
                        Movie movie = movieList.get(i);
                        moviesRecyclerAdapter.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable throwable) {

            }
        });
    }

    public static CurrentlyInTheaterMoviesFragment newInstance() {
        return new CurrentlyInTheaterMoviesFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_currently_in_theater_movies, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.fragment_currently_in_theater_recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(moviesRecyclerAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.addOnItemTouchListener(new RecyclerViewItemClickListener(getContext(), new RecyclerViewItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent i = new Intent(getContext(), MovieDetailActivity.class);
                i.putExtra(FinalConstants.movieTag, movieList.get(position));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    //For Shared Element Transition
                    ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity()
                            , view.findViewById(R.id.single_movie_poster), "sharedTransition");
                    startActivity(i, optionsCompat.toBundle());
                }
                else{
                    startActivity(i);
                }
            }
        }));
        return view;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(String command);
    }
}
