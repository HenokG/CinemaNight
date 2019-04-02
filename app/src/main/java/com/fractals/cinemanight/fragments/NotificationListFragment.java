package com.fractals.cinemanight.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fractals.cinemanight.R;
import com.fractals.cinemanight.models.Movie;

import java.util.List;

public class NotificationListFragment extends Fragment {

    private List<Movie> movieList;

    public NotificationListFragment() {}

    public static NotificationListFragment newInstance() {
        return new NotificationListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notification_list, container, false);
    }

}
