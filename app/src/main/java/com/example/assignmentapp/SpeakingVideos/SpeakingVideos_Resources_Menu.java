package com.example.assignmentapp.SpeakingVideos;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.assignmentapp.R;
import com.example.assignmentapp.VideoMenu;

import java.util.ArrayList;

public class SpeakingVideos_Resources_Menu extends AppCompatActivity {
    private static final String TAG = "Additional_Resources_M";

    public static final String YOUTUBE_API_KEY = "AIzaSyCqwpllIfLUAZFWhvCWbPQqWVAY6KbOeZ8";

    public static String getApiKey(){
        return YOUTUBE_API_KEY;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speaking_resources_menu);

        SpeakingVideoAdapter adapter = new SpeakingVideoAdapter(this, SpeakingVideoDetails.getMyVideos());

        ListView listView = (ListView) findViewById(R.id.myListview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(playVideo);
    }

    //set an listener for the video thumbnails to play
    AdapterView.OnItemClickListener playVideo = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            //made a copy the array to get the details
            ArrayList<SpeakingVideoDetails> videoDetails = SpeakingVideoDetails.getMyVideos();

            //Get the name of the video (Test)
            String title = videoDetails.get(position).getVideoTitle();
            String url = videoDetails.get(position).getVideoUrl();

            Log.d(TAG, "onItemClick: Playing video " + title);
            Toast.makeText(SpeakingVideos_Resources_Menu.this, title, Toast.LENGTH_SHORT).show();

            //creates an intent for both the youtube app and default browser if no youtube app is available
            Intent youtubeIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtube.com/watch?v=" + url)); //I swapped youtubeIntent and altIntent around
            Intent altIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + url));

            //runs one or the other based on what is available via a try-catch block
            try {
                startActivity(youtubeIntent);
            } catch (ActivityNotFoundException e){
                startActivity(altIntent);
            }
        }
    };

    //takes it back to the home screen rather than go home
    public void onBackPressed() {
        Intent intent = new Intent(this, VideoMenu.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }
}

