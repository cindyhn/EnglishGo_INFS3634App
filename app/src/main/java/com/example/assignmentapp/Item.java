package com.example.assignmentapp;

public class Item {

    //Container class for the Vocab Quiz - only has Question and Answer as it is an user-typed input quiz
    private String question, answer;

    public Item(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }
}
