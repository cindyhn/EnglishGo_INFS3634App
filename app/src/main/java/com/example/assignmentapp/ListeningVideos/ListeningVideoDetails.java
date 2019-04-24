package com.example.assignmentapp.ListeningVideos;

import java.util.ArrayList;

public class ListeningVideoDetails {

    private int videoId;
    private String videoTitle;
    private String videoUrl;

    private ListeningVideoDetails(int id, String title, String url) {
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
    private static ArrayList<ListeningVideoDetails> myVideos = new ArrayList<ListeningVideoDetails>() {{
        add(new ListeningVideoDetails(1, "Advanced Listening English Conversation - Listening English Lesson 1", "vBkqn0RpbUk&list=PLTyvAtj9OYb2MCo7KLhXP49vHCCFxBbEi"));
        add(new ListeningVideoDetails(2, "Advanced Listening English Conversation - Listening English Lesson 2", "H0ziWyTLd_c&list=PLTyvAtj9OYb2MCo7KLhXP49vHCCFxBbEi&index=2"));
        add(new ListeningVideoDetails(3, "Advanced Listening English Conversation - Listening English Lesson 3", "_hkIVzHTDek&list=PLTyvAtj9OYb2MCo7KLhXP49vHCCFxBbEi&index=3"));
    }};

    //getter for the array
    public static ArrayList<ListeningVideoDetails> getMyVideos() {
        return myVideos;
    }

    // getter for a specific item by index
    public static ListeningVideoDetails getVideoById(int id) {
        for (ListeningVideoDetails video : myVideos) {
            if(video.getVideoId() == id) {
                return video;
            }
        }
        return null;
    }
}
