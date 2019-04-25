package com.example.assignmentapp.SpeakingVideos;

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

public class SpeakingVideoAdapter extends ArrayAdapter<SpeakingVideoDetails> {

    public SpeakingVideoAdapter(Context context, List<SpeakingVideoDetails> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        //get the video for this position
        SpeakingVideoDetails videoDetails = getItem(position);

        //check if an existing view is being reused? Otherwise inflate the view with this
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_speaking_videos,parent,false);
        }

        //create/find the imageview and two textviews from the xml file we're going to be using
        ImageView videoThumbnail = (ImageView) convertView.findViewById(R.id.thumbnail);
        TextView title = (TextView) convertView.findViewById(R.id.videoTitle);

        //set the image using the youtube video url using Picasso API
        String url = videoDetails.getVideoUrl();
        String imageUrl = "https://img.youtube.com/vi/" + url + "/0.jpg";
        Picasso.with(getContext()).load(imageUrl).into(videoThumbnail);

        //set the title
        title.setText(videoDetails.getVideoTitle());

        return convertView;
    }
}

