package com.fractals.cinemanight.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.fractals.cinemanight.fragments.CurrentlyInTheaterMoviesFragment;
import com.fractals.cinemanight.util.FinalConstants;

/**
 * Created by Henok G on 12/11/2016.
 */

public class TabAdapter extends FragmentPagerAdapter {

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return CurrentlyInTheaterMoviesFragment.newInstance();
        } else {
            return CurrentlyInTheaterMoviesFragment.newInstance();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0)
            return FinalConstants.tabTitleCurrentlyInTheater;
        else
            return FinalConstants.tabTitleComingToTheater;
    }
}
