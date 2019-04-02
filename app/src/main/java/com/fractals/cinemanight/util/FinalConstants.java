package com.fractals.cinemanight.util;

/**
 * Created by Henok G on 4/2/2017.
 */

public interface FinalConstants {

    //    Tab Titles
    String tabTitleCurrentlyInTheater = "In Theater";
    String tabTitleComingToTheater = "Coming Soon";

    //    Activity Transfer
    String movieTag = "movie";
    String similarMoviesTag = "similar_movies";

    //    YouTube Components
    String youTubeApiKey = "apikey";
    String youTubeRequestUrl = "https://www.googleapis.com/youtube/v3/search?part=snippet&maxResults=1&type=video&videoDefinition=high&key=" + youTubeApiKey + "&q=";
    String youTubeFrameBegin = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/";
    String youTubeFrameEnd = "\" frameborder=\"0\" allowfullscreen></iframe>";
    String youTubeVideoIdTag = "videoId";
    String youTubeItemsTag = "items";
    String youTubeIdTag = "id";
    String youTubeTrailerTag = "+Trailer";

        String testIp = "http://192.168.1.112:4000/";
//    String testIp = "http://192.168.137.1:4000/";

}
