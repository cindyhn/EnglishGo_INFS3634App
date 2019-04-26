package com.example.assignmentapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;


public class VocabQuizQuestion extends AppCompatActivity {

    Button buttonNext;
    TextView textVQuestion;
    EditText editAnswer;

    List<Item> questions;
    int currentQuestion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocab_quiz_question);

        //Defining the buttons, text views and edit answer items
        buttonNext = findViewById(R.id.BTVSubmit);
        textVQuestion = findViewById(R.id.TVVQuestion);
        editAnswer = findViewById(R.id.ETAnswer);

        buttonNext.setVisibility(View.INVISIBLE);

        questions = new ArrayList<>();

        //Add all questions and answers to the game
        for(int i = 0; i < VocabDatabase.questions.length; i++) {
            questions.add(new Item(VocabDatabase.questions[i], VocabDatabase.answers[i]));
        }

        //Shuffle questions
        Collections.shuffle(questions);
        textVQuestion.setText(questions.get(currentQuestion).getQuestion());

        editAnswer.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //Checks if the answer inputted is correct (whilst the user is inputting their questions)
                if (editAnswer.getText().toString().equalsIgnoreCase(questions.get(currentQuestion).getAnswer())){
                    //Makes next button visible if it is correct
                    buttonNext.setVisibility(View.VISIBLE);
                } else {
                    //Not visible when incorrect
                    Toast.makeText(VocabQuizQuestion.this, "Almost there!" +
                            "", Toast.LENGTH_SHORT).show();
                    buttonNext.setVisibility(View.INVISIBLE);

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //Loop to ensure all questions are shown to the user
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentQuestion < (VocabDatabase.questions.length - 1)) {

                    //Next Question
                    currentQuestion++;
                textVQuestion.setText(questions.get(currentQuestion).getQuestion());
                buttonNext.setVisibility(View.INVISIBLE);
                editAnswer.setText("");

            } else {
                   //If no more questions - game over
                    Toast.makeText(VocabQuizQuestion.this, "Your vocab and grammar are on par!", Toast.LENGTH_SHORT).show();
                    finish();
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                }
        }


    });

    }
}