package com.fractals.cinemanight.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fractals.cinemanight.R;

public class MovieDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
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
}
