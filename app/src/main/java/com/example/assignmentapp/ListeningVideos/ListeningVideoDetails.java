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


    //Array list containing video details and url
    private static ArrayList<ListeningVideoDetails> myVideos = new ArrayList<ListeningVideoDetails>() {{
        add(new ListeningVideoDetails(1, "Advanced Listening English Conversation - Listening English Lesson 1", "vBkqn0RpbUk"));
        add(new ListeningVideoDetails(2, "Advanced Listening English Conversation - Listening English Lesson 2", "H0ziWyTLd_c"));
        add(new ListeningVideoDetails(3, "Advanced Listening English Conversation - Listening English Lesson 3", "_hkIVzHTDek"));
        add(new ListeningVideoDetails(4, "English Listening Practice - Learn English Listening Comprehension", "qYb0LCqqJbU"));
        add(new ListeningVideoDetails(5, "English Listening Practice Level 2 - Learn English Listening With Subtitle", "64DApbWVaLI"));
        add(new ListeningVideoDetails(6, "English Listening Practice Level 3 - Listening English Comprehension with Subtitle", "64DApbWVaLI"));
        add(new ListeningVideoDetails(7, "English Listening Practice Level 4 - Learn English By Listening With Subtitle", "l3wC49vEYRg"));
        add(new ListeningVideoDetails(8, "TOEFL Practice Test - The Listening Section (2019)", "X1fi29olrc4"));

    }};

    //Getter method for the array
    public static ArrayList<ListeningVideoDetails> getMyVideos() {
        return myVideos;
    }

    //Getter method for a specific index item in the array
    public static ListeningVideoDetails getVideoById(int id) {
        for (ListeningVideoDetails video : myVideos) {
            if(video.getVideoId() == id) {
                return video;
            }
        }
        return null;
    }
}
