package com.example.assignmentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.example.assignmentapp.ListeningVideos.ListeningVideoAdapter;
import com.example.assignmentapp.ListeningVideos.ListeningVideos_Resources_Menu;
import com.example.assignmentapp.ReadingVideos.ReadingVideos_Resources_Menu;
import com.example.assignmentapp.SpeakingVideos.SpeakingVideos_Resources_Menu;
import com.example.assignmentapp.WritingVideos.WritingVideos_Resources_Menu;

public class VideoMenu extends AppCompatActivity implements View.OnClickListener {

    public CardView listeningCard, writingCard, readingCard, speakingCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_menu);


        //Defining Cards
        listeningCard = findViewById(R.id.CVListening);
        writingCard = findViewById(R.id.CVWriting);
        readingCard = findViewById(R.id.CVReading);
        speakingCard = findViewById(R.id.CVSpeaking);

        //Adding OnClick Listener to Cards
        listeningCard.setOnClickListener(this);
        writingCard.setOnClickListener(this);
        readingCard.setOnClickListener(this);
        speakingCard.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;

        //Adding intents to each Cardview, so that they start the corresponding activity
        //Also overriding the upward motion transition that occurs, with a horizontal slide to add natural flow
        switch (v.getId()) {
            case R.id.CVListening:
                i = new Intent(this, ListeningVideos_Resources_Menu.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.CVReading:
                i = new Intent(this, ReadingVideos_Resources_Menu.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.CVWriting:
                i = new Intent(this, WritingVideos_Resources_Menu.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.CVSpeaking:
                i = new Intent(this, SpeakingVideos_Resources_Menu.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            default:
                break;
        }

    }

    //takes it back to HomeMenu
    public void onBackPressed() {
        Intent intent = new Intent(this, HomeMenu.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }
}


