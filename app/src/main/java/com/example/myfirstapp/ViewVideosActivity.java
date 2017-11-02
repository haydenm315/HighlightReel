package com.example.myfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.app.ActionBar;
import android.os.Bundle;

public class ViewVideosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_videos);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getFragmentManager().beginTransaction().add(R.id.content, new ViewVideosFragment()).commit();
        //Toolbar viewVideosToolbar = (Toolbar) findViewById(R.id.displayMessageToolbar);
        //setSupportActionBar(viewVideosToolbar);


    }
}
