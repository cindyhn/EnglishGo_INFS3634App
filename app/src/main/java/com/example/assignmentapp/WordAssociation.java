package com.example.assignmentapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class WordAssociation extends AppCompatActivity {

    private static final int REQUEST_CODE_QUIZ = 1;
    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String KEY_HIGHSCORE = "keyHighScore";
    public static final String EXTRA_DIFFICULTY = "extraDifficulty";

    private TextView textHighScore;

    private int highscore;

    private Spinner spinnerDifficulty;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_association);

        textHighScore = findViewById(R.id.TVHighscore);
        loadHighscore();

        spinnerDifficulty = findViewById(R.id.SPDifficulty);
        String[] difficultyLevels = WordAssociationQandA.getAllDifficultyLevels();
        ArrayAdapter<String> adapterDifficulty = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, difficultyLevels);
        adapterDifficulty.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDifficulty.setAdapter(adapterDifficulty);

        Button buttonStartQuiz = findViewById(R.id.BTPlay);
        buttonStartQuiz.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startQuiz();
            }
        });
    }

    private void startQuiz() {
        String difficulty = spinnerDifficulty.getSelectedItem().toString();

        Intent intent = new Intent(WordAssociation.this, WordAssociationQuestion.class);
        intent.putExtra(EXTRA_DIFFICULTY, difficulty);

        //To send score value back from the Word Association Quiz Activity
        startActivityForResult(intent, REQUEST_CODE_QUIZ);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Getting score back from the Word Association Quiz Activity
        super.onActivityResult(requestCode, resultCode, data);

        //Comparing with the current high score, if it's bigger - update it
        if (requestCode == REQUEST_CODE_QUIZ) {
            if (resultCode == RESULT_OK) {
                int score = data.getIntExtra(WordAssociationQuestion.EXT_SCORE, 0);
                if (score > highscore) {
                    updateHighscore(score);
                }
            }
        }

    }
    //Load high score from Shared Preferences to display it
    private void loadHighscore() {
        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        highscore = prefs.getInt(KEY_HIGHSCORE, 0);
        textHighScore.setText("Current High Score: " + highscore);
    }


    //Save high score values in Shared Preferences
    private void updateHighscore(int highscoreNew){
        highscore = highscoreNew;
        textHighScore.setText("Current High Score: " + highscore);

        SharedPreferences prefs = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE, highscore);
        editor.apply();
    }
}