package com.example.assignmentapp.ReadingVideos;

import java.util.ArrayList;

public class ReadingVideoDetails {

    private int videoId;
    private String videoTitle;
    private String videoUrl;

    private ReadingVideoDetails(int id, String title, String url) {
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
    private static ArrayList<ReadingVideoDetails> myVideos = new ArrayList<ReadingVideoDetails>() {{
        add(new ReadingVideoDetails(1, "Testing reading", "vBkqn0RpbUk&list=PLTyvAtj9OYb2MCo7KLhXP49vHCCFxBbEi"));
        add(new ReadingVideoDetails(2, "Advanced Listening English Conversation - Listening English Lesson 2", "H0ziWyTLd_c&list=PLTyvAtj9OYb2MCo7KLhXP49vHCCFxBbEi&index=2"));
        add(new ReadingVideoDetails(3, "Advanced Listening English Conversation - Listening English Lesson 3", "_hkIVzHTDek&list=PLTyvAtj9OYb2MCo7KLhXP49vHCCFxBbEi&index=3"));
    }};

    //getter for the array
    public static ArrayList<ReadingVideoDetails> getMyVideos() {
        return myVideos;
    }

    // getter for a specific item by index
    public static ReadingVideoDetails getVideoById(int id) {
        for (ReadingVideoDetails video : myVideos) {
            if(video.getVideoId() == id) {
                return video;
            }
        }
        return null;
    }
}
