package com.example.assignmentapp.ListeningVideos;

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

public class ListeningVideos_Resources_Menu extends AppCompatActivity {
    private static final String TAG = "Additional_Resources_M";

    public static final String YOUTUBE_API_KEY = "AIzaSyD3V-DYkbWzbHajYyZPFL8eh_yFPgGoZoU";
    public static String getApiKey(){
        return YOUTUBE_API_KEY;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listening_resources_menu);

        ListeningVideoAdapter adapter = new ListeningVideoAdapter(this, ListeningVideoDetails.getMyVideos());

        ListView listView = (ListView) findViewById(R.id.myListview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(playVideo);
    }

    //Set an listener for the video to play
    AdapterView.OnItemClickListener playVideo = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            //A copy of the array to get details
            ArrayList<ListeningVideoDetails> videoDetails = ListeningVideoDetails.getMyVideos();

            //Gets the name and url of the video
            String title = videoDetails.get(position).getVideoTitle();
            String url = videoDetails.get(position).getVideoUrl();

            Log.d(TAG, "onItemClick: Playing video " + title);
            Toast.makeText(ListeningVideos_Resources_Menu.this, title, Toast.LENGTH_SHORT).show();

            //Creates an intent for both the youtube app and default browser if no youtube app is available
            Intent youtubeIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtube.com/watch?v=" + url)); //I swapped youtubeIntent and altIntent around
            Intent altIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:" + url));

            //Runs one or the other above based on what is available via a try-catch block
            try {
                startActivity(youtubeIntent);
            } catch (ActivityNotFoundException e){
                startActivity(altIntent);
            }
        }
    };

    //Takes user back to the VideoMenu, rather than YouTube Home
    public void onBackPressed() {
        Intent intent = new Intent(this, VideoMenu.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }
}
