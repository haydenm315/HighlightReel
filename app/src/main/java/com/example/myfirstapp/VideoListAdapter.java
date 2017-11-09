package com.example.myfirstapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Hayden on 11/8/2017.
 */

public class VideoListAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<File> mFilesDataSource;

    public VideoListAdapter(Context context, ArrayList<File> videos)
    {
        mContext = context;
        mFilesDataSource = videos;
        mInflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return mFilesDataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return mFilesDataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        View rowView = mInflater.inflate(R.layout.list_video_file, parent, false);
        TextView titleTextView = (TextView)rowView.findViewById(R.id.video_list_title);
        TextView subTitleTextView = (TextView) rowView.findViewById(R.id.video_list_subtitle);
        TextView detailTextView = (TextView)rowView.findViewById(R.id.video_list_detail);
        File file = (File)getItem(position);

        titleTextView.setText(file.getName());
        subTitleTextView.setText(file.getAbsolutePath());
        detailTextView.setText("File Size: " + file.getTotalSpace());

        return rowView;
    }
}
