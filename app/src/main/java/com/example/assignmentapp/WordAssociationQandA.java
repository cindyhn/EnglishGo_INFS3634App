package com.example.assignmentapp;

public class WordAssociationQandA {
    private String question;
    private String option1;
    private String option2;
    private int answerNo;

    //Empty Constructor
    public WordAssociationQandA() {}

    //Constructor
    public WordAssociationQandA(String question, String option1, String option2, int answerNo) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.answerNo = answerNo;
    }

    //Getter and Setter Methods used to change the fields in the class and to get values to display
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public int getAnswerNo() {
        return answerNo;
    }

    public void setAnswerNo(int answerNo) {
        this.answerNo = answerNo;
    }
}
