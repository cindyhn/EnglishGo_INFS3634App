package com.example.assignmentapp.SpeakingVideos;

import java.util.ArrayList;

public class SpeakingVideoDetails {

    private int videoId;
    private String videoTitle;
    private String videoUrl;

    private SpeakingVideoDetails(int id, String title, String url) {
        this.videoId = id;
        this.videoTitle = title;
        this.videoUrl = url;
    }

    public int getVideoId() {
        return this.videoId;
    }

    public void setVideoId(int id) {
        this.videoId = id;
    }

    public String getVideoTitle() {
        return this.videoTitle;
    }

    public void setVideoTitle(String title) {
        this.videoTitle = title;
    }

    public String getVideoUrl() {
        return this.videoUrl;
    }


    //array list containing the video and details
    private static ArrayList<com.example.assignmentapp.SpeakingVideos.SpeakingVideoDetails> myVideos = new ArrayList<com.example.assignmentapp.SpeakingVideos.SpeakingVideoDetails>() {{
        add(new SpeakingVideoDetails(1, "Speaking English Practice Conversation - Questions and Answers English Conversation", "XVQlnP5Yu2A"));
        add(new SpeakingVideoDetails(2, "English Speaking Practice - 501 Most Common Questions and Answers in English", "ccAKVt2x_PQ"));
        add(new SpeakingVideoDetails(3, "Spoken English Leaning Video", "IhQt_fxGOcw"));
        add(new SpeakingVideoDetails(4, "Slow and Easy English Conversation Practice", "4IkM_Hb2B-A"));
        add(new SpeakingVideoDetails(5, "1000 Useful Expressions in English - Learn English Speaking", "r0npU0D51OA"));
        add(new SpeakingVideoDetails(6, "Basic English Conversation Practice | English Listening and Speaking Practice", "QGarmmz2S78"));
        add(new SpeakingVideoDetails(7, "TOEFL Speaking Practice Test", "INYFYq_D_Xc"));
        add(new SpeakingVideoDetails(8, "TOEFL Practice Test - The Speaking Section (2019))", "7a3W861_EiA"));
    }};

    //getter for the array
    public static ArrayList<com.example.assignmentapp.SpeakingVideos.SpeakingVideoDetails> getMyVideos() {
        return myVideos;
    }

    // getter for a specific item by index
    public static com.example.assignmentapp.SpeakingVideos.SpeakingVideoDetails getVideoById(int id) {
        for (com.example.assignmentapp.SpeakingVideos.SpeakingVideoDetails video : myVideos) {
            if(video.getVideoId() == id) {
                return video;
            }
        }
        return null;
    }
}
