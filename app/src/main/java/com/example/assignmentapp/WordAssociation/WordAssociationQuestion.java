package com.example.assignmentapp.WordAssociation;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignmentapp.R;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class WordAssociationQuestion extends AppCompatActivity {

    public static final String EXT_SCORE = "extraScore";

    private static final long COUNTDOWN_IN_MILLIS = 15000;

    private TextView textQuestion;
    private TextView textScore;
    private TextView textQuestionNo;
    private TextView textTimer;

    private RadioButton RB1;
    private RadioButton RB2;
    private RadioGroup radioGroup;

    private Button buttonSubmit;

    private ColorStateList textColourDefault;
    private ColorStateList textColourDefaultTimer;

    private List<WordAssociationQandA> questionList;

    private CountDownTimer countDownTimer;
    private long timeLeftInMillis;

    private int questionNo;
    private int questionTotal;

    private WordAssociationQandA currentQuestion;

    private int score;
    private boolean answered;

    private long backPressedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_association_question);

        textQuestion = findViewById(R.id.TVVQuestion);
        textScore = findViewById(R.id.TVScore);
        textQuestionNo = findViewById(R.id.TVQuestionNo);
        textTimer = findViewById(R.id.TVTimer);

        RB1 = findViewById(R.id.RB1);
        RB2 = findViewById(R.id.RB2);
        radioGroup = findViewById(R.id.radioGroup);

        buttonSubmit = findViewById(R.id.BTSubmit);

        textColourDefault = RB1.getTextColors();
        textColourDefaultTimer = textTimer.getTextColors();

        Intent intent = getIntent();
        String difficulty = intent.getStringExtra(WordAssociation.EXTRA_DIFFICULTY);

        //Collecting the questions from the database class, shuffling and picking 5
        WordAssociationDBHelper dbHelper = new WordAssociationDBHelper(this);
        questionList = dbHelper.getQuestions(difficulty);
        Collections.shuffle(questionList);
        questionTotal = 5;//questionList.size();

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
        //Setting radio buttons to default colour and reverting radioGroup back to initial state
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

            timeLeftInMillis = COUNTDOWN_IN_MILLIS;
            startCountDown();

        } else {
            finishWordAssociationQuiz();
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);


        }
    }

    private void startCountDown() {
        //Countdown timer decreasing by a second as time passes

        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            //OnTick method will be called every second (because of the line above)
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }

            @Override
            public void onFinish() {
                timeLeftInMillis = 0;
                updateCountDownText();
                checkAnswer();
            }
            //Start countdown timer when creating it
        }.start();
    }

    private void updateCountDownText() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        textTimer.setText(timeFormatted);

        if (timeLeftInMillis < 5000) {
            textTimer.setTextColor(Color.RED);
        } else {
            textTimer.setTextColor(textColourDefaultTimer);
        }
    }


    private void checkAnswer() {
        answered = true;

        //Stop the timer
        countDownTimer.cancel();

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
                break;

            case 2:
                RB2.setTextColor(Color.GREEN);
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


        @Override
        public void onBackPressed() {
        //If back button pressed twice within 2 seconds, finish quiz activity
            if (backPressedTime + 2000 > System.currentTimeMillis()) {
                finishWordAssociationQuiz();
            } else {
                //If back button is pressed, display a toas
                Toast.makeText(this, "Press back again to finish", Toast.LENGTH_SHORT).show();
            }

            backPressedTime = System.currentTimeMillis();
        }

        @Override
        //Method when timer runs out
        protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}