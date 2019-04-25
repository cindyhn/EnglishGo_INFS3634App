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
        add(new com.example.assignmentapp.SpeakingVideos.SpeakingVideoDetails(1, "Testing speaking", "vBkqn0RpbUk&list=PLTyvAtj9OYb2MCo7KLhXP49vHCCFxBbEi"));
        add(new com.example.assignmentapp.SpeakingVideos.SpeakingVideoDetails(2, "Advanced Listening English Conversation - Listening English Lesson 2", "H0ziWyTLd_c&list=PLTyvAtj9OYb2MCo7KLhXP49vHCCFxBbEi&index=2"));
        add(new com.example.assignmentapp.SpeakingVideos.SpeakingVideoDetails(3, "Advanced Listening English Conversation - Listening English Lesson 3", "_hkIVzHTDek&list=PLTyvAtj9OYb2MCo7KLhXP49vHCCFxBbEi&index=3"));
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
