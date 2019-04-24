package com.example.assignmentapp.WritingVideos;

import java.util.ArrayList;

public class WritingVideoDetails {

    private int videoId;
    private String videoTitle;
    private String videoUrl;

    private WritingVideoDetails(int id, String title, String url) {
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
    private static ArrayList<com.example.assignmentapp.WritingVideos.WritingVideoDetails> myVideos = new ArrayList<com.example.assignmentapp.WritingVideos.WritingVideoDetails>() {{
        add(new com.example.assignmentapp.WritingVideos.WritingVideoDetails(1, "Testing writing", "vBkqn0RpbUk&list=PLTyvAtj9OYb2MCo7KLhXP49vHCCFxBbEi"));
        add(new com.example.assignmentapp.WritingVideos.WritingVideoDetails(2, "Advanced Listening English Conversation - Listening English Lesson 2", "H0ziWyTLd_c&list=PLTyvAtj9OYb2MCo7KLhXP49vHCCFxBbEi&index=2"));
        add(new com.example.assignmentapp.WritingVideos.WritingVideoDetails(3, "Advanced Listening English Conversation - Listening English Lesson 3", "_hkIVzHTDek&list=PLTyvAtj9OYb2MCo7KLhXP49vHCCFxBbEi&index=3"));
    }};

    //getter for the array
    public static ArrayList<com.example.assignmentapp.WritingVideos.WritingVideoDetails> getMyVideos() {
        return myVideos;
    }

    // getter for a specific item by index
    public static com.example.assignmentapp.WritingVideos.WritingVideoDetails getVideoById(int id) {
        for (com.example.assignmentapp.WritingVideos.WritingVideoDetails video : myVideos) {
            if(video.getVideoId() == id) {
                return video;
            }
        }
        return null;
    }
}

