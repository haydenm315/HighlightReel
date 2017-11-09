package com.example.myfirstapp;

import android.app.Activity;
import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ArrayAdapter;

import java.io.File;
import java.util.ArrayList;

public class ViewVideosFragment extends ListFragment {

    ListView List;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //OnVideoSelectedListener mCallback;

    public ViewVideosFragment() {
        // Required empty public constructor
    }

    /*public interface OnVideoSelectedListener
    {
        public void onVideoSelected(int position);
    }*/

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ViewVideosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ViewVideosFragment newInstance(String param1, String param2) {
        ViewVideosFragment fragment = new ViewVideosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ArrayList<File> filesInFolder = getFiles("video");
        View view =inflater.inflate(R.layout.fragment_view_videos, container, false);
        List = (ListView) view.findViewById(android.R.id.list);

        VideoListAdapter adapter = new VideoListAdapter(this.getActivity(),filesInFolder);
        List.setAdapter(adapter);
        //ArrayAdapter<File> arrayAdapter = new ArrayAdapter<File>(getActivity(),android.R.layout.simple_expandable_list_item_1, filesInFolder) ;
        //List.setAdapter(arrayAdapter);

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
        /*(try {
            mCallback = (OnVideoSelectedListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " must implement OnVideoSelectedListener");
        }*/
    }




    private ArrayList<File> getFiles(String path) {
        Activity activity = getActivity();
        ArrayList<File> videoFiles = new ArrayList<File>();
        File location = activity.getExternalFilesDir("video");

        location.mkdirs();
        File[] files = location.listFiles();
        if (files.length == 0) {
            return null;
        }
        else
        {
            for (int fileIndex = 0; fileIndex < files.length; fileIndex++)
            {
               videoFiles.add(files[fileIndex].getAbsoluteFile());
            }
        }
        return videoFiles;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        System.out.println("list was clicked bitch");
        File file = (File)l.getItemAtPosition(position);
        System.out.println("file name: " + file.getName());

        Intent intent = new Intent(this.getActivity(), PlayVideoActivity.class);
        startActivity(intent);
    }


}
