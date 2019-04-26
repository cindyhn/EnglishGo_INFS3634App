package com.example.assignmentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VocabQuiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocab_quiz);


        Button buttonPlay = findViewById(R.id.BTPlay);

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startQuiz();
            }
        });
    }

    private void startQuiz() {
        Intent intent = new Intent(VocabQuiz.this, VocabQuizQuestion.class);
        startActivity(intent);
    }
}