package com.example.myfirstapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.camera2video.Camera2Fragment;
import com.example.camera2video.Camera2Listener;

import java.io.File;
import java.io.IOException;
import java.util.Date;





public class RecordVideoFragment extends Camera2Fragment implements Camera2Listener {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRationaleMessage("Hey man, we need to use your camera please!");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_record_video, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView button = (ImageView) view.findViewById(R.id.camera_control);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCameraControlClick((ImageView)v);
            }
        });
    }

    @Override
    public int getTextureResource() {

        return R.id.camera_preview;
    }

    @Override
    public File getVideoFile(Context context) {
        File file;
        try {
            File location = context.getExternalFilesDir("video");
            file = File.createTempFile(String.valueOf(new Date().getTime()), ".mp4", location);
        } catch (IOException e) {
            file = new File(context.getExternalFilesDir("video"),String.valueOf(new Date().getTime()) + ".mp4");
        }
        return file;
    }

    public void onCameraControlClick(ImageView view) {
        if (isRecording()) {
            Log.d("TEST", "File saved: " + getCurrentFile().getName());
            view.setImageResource(R.drawable.ic_record);
            stopRecordingVideo();
        } else {
            view.setImageResource(R.drawable.ic_pause);
            startRecordingVideo();
        }
    }
}
