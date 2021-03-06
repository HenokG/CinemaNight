package com.fractals.cinemanight.api.operations;

import com.fractals.cinemanight.models.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Henok G on 4/2/2017.
 */
public interface MovieApiService {

    @GET("get-currently-in-theater-movies/")
    Call<List<Movie>> getCurrentlyInTheaterMovies();

    @GET("get-upcoming-movies/")
    Call<List<Movie>> getUpcomingMovies();

    @GET("search")
    Call<List<Movie>> searchForMovies(
            @Query("q") String query
    );

    @GET("get-detail-of-movie/{id}")
    Call<Movie> getDetailOfMovie(
            @Path("id") String id
    );

}