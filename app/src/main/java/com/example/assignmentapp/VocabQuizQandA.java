package com.example.assignmentapp;

import android.support.v7.app.AppCompatActivity;

public class VocabQuizQandA extends AppCompatActivity {
    private String topic;
    private String question;
    private String answer;


    public VocabQuizQandA(String topic, String question, String answer) {
        this.topic = topic;
        this.question = question;
        this.answer = answer;

    }

    //Getters and setters for the questions
    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTopic() {
        return this.topic;
    }

    public void setQuestion(String question){
        this.question = question;
    }

    public String getQuestion(){
        return this.question;
    }

    public String getAnswer() { return answer; }

    public void setAnswer(String FBanswer) {
        this.answer = answer;
    }


}
