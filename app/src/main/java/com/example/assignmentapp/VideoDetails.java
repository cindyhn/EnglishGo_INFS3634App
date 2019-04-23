package com.example.assignmentapp;

import java.util.ArrayList;

public class VideoDetails {

    private int videoId;
    private String videoTitle;
    private String videoUrl;
    private String videoDescription;

    private VideoDetails(int id, String title, String url, String description) {
        this.videoId = id;
        this.videoTitle = title;
        this.videoUrl = url;
        this.videoDescription = description;
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

    public String getVideoDescription() {
        return this.videoDescription;
    }

    //array list containing the video and details
    private static ArrayList<VideoDetails> myVideos = new ArrayList<VideoDetails>() {{
        add(new VideoDetails(1, "What is Object Orientated Programming? - Processing Tutorial", "YcbcfkLzgvs", "This video explains the role of OOP in Java and how it works to develop more effective code."));
        add(new VideoDetails(2, "What is Object Orientated Programming?", "gJLtvKMGjhU", "This is another video providing a more everyman's definition and explanation of OOP."));
        add(new VideoDetails(3, "Introduction to Polymorphism", "0xw06loTm1k", "This video is provides an introduction to the concepts of polymorphism within the context of Java. It contains code examples to help explain the idea."));
        add(new VideoDetails(4, "Inheritance in Java", "9JpNY-XAseg", "This video explains the way Inheritance works in Java programming. It contains code examples to help explain the idea."));
        add(new VideoDetails(5, "Inheritance", "wlA66hZ4Z74", "This is another video by blondiebytes that helps explain inheritance in Java using animals as the basis for her examples."));
        add(new VideoDetails(6, "Abstract Classes + Casting", "xSQKDWTahvs", "This is also another video by blondiebytes. It continues on from the concepts in here inheritance videos, going further in detail about abstract classes and casting between sub and super classes."));
        add(new VideoDetails(7, "Encapsulation", "OOVQAk4HGqM", "This is video explains the how to implement encapsulation in your Java code, using real-time examples to demonstrate the usage."));
    }};

    //getter for the array
    public static ArrayList<VideoDetails> getMyVideos() {
        return myVideos;
    }

    // getter for a specific item by index
    public static VideoDetails getVideoById(int id) {
        for (VideoDetails video : myVideos) {
            if(video.getVideoId() == id) {
                return video;
            }
        }
        return null;
    }
}
