package com.example.assignmentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WordAssociation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_association);

        Button buttonStartQuiz = findViewById(R.id.BTPlay);
        buttonStartQuiz.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                startQuiz();
            }
        });
    }

    private void startQuiz() {
        Intent intent = new Intent(WordAssociation.this, WordAssociationQuestion.class);
        startActivity(intent);
    }
}