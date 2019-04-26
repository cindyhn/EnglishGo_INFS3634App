package com.example.assignmentapp.WritingVideos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.assignmentapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class WritingVideoAdapter extends ArrayAdapter<WritingVideoDetails> {

    public WritingVideoAdapter(Context context, List<WritingVideoDetails> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        //Retrieve the video for this position using 'get' method
        WritingVideoDetails videoDetails = getItem(position);

        //Inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_writing_videos,parent,false);
        }

        //Assigning widgets from xml file to corresponding variables above
        ImageView videoThumbnail = (ImageView) convertView.findViewById(R.id.thumbnail);
        TextView title = (TextView) convertView.findViewById(R.id.videoTitle);

        //Set the thumbnail image of the youtube video url using Picasso API
        String url = videoDetails.getVideoUrl();
        String imageUrl = "https://img.youtube.com/vi/" + url + "/0.jpg";
        Picasso.with(getContext()).load(imageUrl).into(videoThumbnail);

        //Set the title
        title.setText(videoDetails.getVideoTitle());

        return convertView;
    }
}

