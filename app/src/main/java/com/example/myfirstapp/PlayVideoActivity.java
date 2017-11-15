package com.example.myfirstapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.MediaController;
import android.widget.VideoView;

public class PlayVideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();

        Bundle extras = intent.getExtras();
        extras.getString(ViewVideosActivity.VIDEO_FILE);

        String videoFile = intent.getStringExtra(ViewVideosActivity.VIDEO_FILE);

        setContentView(R.layout.activity_play_video);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.playVideoToolbar);
        setSupportActionBar(myToolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        VideoView videoView = (VideoView)findViewById(R.id.videoView);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);


        System.out.println("The video file: " + videoFile);
        Uri uri = Uri.parse(videoFile);

        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
    }
}
