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
        add(new ReadingVideoDetails(1, "English Passages for Reading and Listening", "t5qrRALIyko"));
        add(new ReadingVideoDetails(2, "Reading and Understanding - practice English", "HIFzQdKcGNg"));
        add(new ReadingVideoDetails(3, "TOEFL Reading Strategy for Detail Questions", "m7gspetfUww"));
        add(new ReadingVideoDetails(4, "TOEFL Reading Skill 1: Summarize Information with Jay!", "igxu4xvta4c"));
        add(new ReadingVideoDetails(5, "TOEFL Reading Skill 2: Guess Vocabulary from Context with Jay!", "whOoDpXFH9A"));
        add(new ReadingVideoDetails(6, "TOEFL Reading Skill 3: Inference with Jay!", "EsMbzhw_wn4"));
        add(new ReadingVideoDetails(7, "TOEFL Reading Skill 4: Reference with Jay!", "zOr4mtCxu4A"));
        add(new ReadingVideoDetails(8, "TOEFL Practice Test - Reading Section (2019)", "72iwMaJ_ScI"));
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
