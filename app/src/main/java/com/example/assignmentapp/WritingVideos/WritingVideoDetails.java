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
        add(new WritingVideoDetails(1, "5 tips to improve your writing", "GgkRoYPLhts"));
        add(new WritingVideoDetails(2, "Learn English Grammar: The Sentence", "4dr5lN1jqRE"));
        add(new WritingVideoDetails(3, "The 4 English Sentence Types – simple, compound, complex, compound-complex", "urr55rAreWc"));
        add(new WritingVideoDetails(4, "Writing Skills: The Paragraph", "0IFDuhdB2Hk"));
        add(new WritingVideoDetails(5, "How to write a good essay: Paraphrasing the question", "o9aVjBHEEbU"));
        add(new WritingVideoDetails(6, "How to Improve Your English Writing - English Writing Lesson", "VgTqZOZ1UMQ"));
        add(new WritingVideoDetails(7, "English Sentence Structure - English Grammar Lesson", "jul2urONzOQ"));
        add(new WritingVideoDetails(8, "How to Improve English Grammar - Tips to Learn English Grammar Faster", "A5uz6LWeLPM"));
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

