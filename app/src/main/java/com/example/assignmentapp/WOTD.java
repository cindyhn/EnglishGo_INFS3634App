package com.example.assignmentapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class WOTD extends AppCompatActivity {

    //Declare variables from activity_wotd
    private Button generateWordBtn;
    private TextView wordTV;
    private WordsDB wordsDB = new WordsDB();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wotd);

        //Assigning widgets from xml file to corresponding variables above
        generateWordBtn = (Button) findViewById(R.id.generateWordBtn);
        wordTV = (TextView) findViewById(R.id.wordTV);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String word = (String) WordsDB.getWord();
                wordTV.setText(word);
            }
        };

        generateWordBtn.setOnClickListener(listener);
    }
}

