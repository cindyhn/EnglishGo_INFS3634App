package com.example.assignmentapp;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

public class WordAssociationQuestion extends AppCompatActivity {

    public static final String EXT_SCORE = "extraScore";

    private TextView textQuestion;
    private TextView textScore;
    private TextView textQuestionNo;
    private TextView textTimer;

    private RadioButton RB1;
    private RadioButton RB2;
    private RadioGroup radioGroup;

    private Button buttonSubmit;

    private ColorStateList textColourDefault;
    private List<WordAssociationQandA> questionList;

    private int questionNo;
    private int questionTotal;

    private WordAssociationQandA currentQuestion;

    private int score;
    private boolean answered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_association_question);

        textQuestion = findViewById(R.id.TVQuestion);
        textScore = findViewById(R.id.TVScore);
        textQuestionNo = findViewById(R.id.TVQuestionNo);
        textTimer = findViewById(R.id.TVTimer);

        RB1 = findViewById(R.id.RB1);
        RB2 = findViewById(R.id.RB2);
        radioGroup = findViewById(R.id.radioGroup);

        buttonSubmit = findViewById(R.id.BTSubmit);

        textColourDefault = RB1.getTextColors();

        WordAssociationDBHelper dbHelper = new WordAssociationDBHelper(this);
        questionList = dbHelper.getAllQuestions();
        questionTotal = questionList.size();
        Collections.shuffle(questionList);

        showNextQuestion();

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!answered) {
                    if (RB1.isChecked() || RB2.isChecked()) {
                        checkAnswer();
                    } else {
                        Toast.makeText(WordAssociationQuestion.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    showNextQuestion();
                }
            }
        });
    }


    private void showNextQuestion() {
        RB1.setTextColor(textColourDefault);
        RB2.setTextColor(textColourDefault);
        radioGroup.clearCheck();

        if (questionNo < questionTotal) {
            currentQuestion = questionList.get(questionNo);

            textQuestion.setText(currentQuestion.getQuestion());
            RB1.setText(currentQuestion.getOption1());
            RB2.setText(currentQuestion.getOption2());

            questionNo++;
            textQuestionNo.setText("Question " + questionNo + " out of " + questionTotal);
            answered = false;
            buttonSubmit.setText("Submit");


        } else {
            finishWordAssociationQuiz();

        }
    }

    private void checkAnswer() {
        answered = true;

        RadioButton rbSelected = findViewById(radioGroup.getCheckedRadioButtonId());
        int answerNr = radioGroup.indexOfChild(rbSelected) + 1;

        if (answerNr == currentQuestion.getAnswerNo()) {
            score++;
            textScore.setText("SCORE: " + score);
        }

        showSolution();
    }

    private void showSolution() {
        RB1.setTextColor(Color.RED);
        RB2.setTextColor(Color.RED);

        switch (currentQuestion.getAnswerNo()) {
            case 1:
                RB1.setTextColor(Color.GREEN);
                textQuestion.setText("Answer 1 is correct");
                break;

            case 2:
                RB2.setTextColor(Color.GREEN);
                textQuestion.setText("Answer 2 is correct");
                break;
        }

        if (questionNo < questionTotal) {
            buttonSubmit.setText("Next");
        } else {
            buttonSubmit.setText("Finish");
        }
    }

    //Send results back to starting screen activity
    //Pass ext_score constant and pass result

    private void finishWordAssociationQuiz() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra(EXT_SCORE, score);
        setResult(RESULT_OK, resultIntent);
        finish();
        }
    }
