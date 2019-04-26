package com.example.assignmentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.example.assignmentapp.WordAssociation.WordAssociation;


public class QuizMenu extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_menu);

        //Defining Cards
        CardView cardWord = findViewById(R.id.CVWordAssociation);
        CardView cardVocab = findViewById(R.id.CVVocab);


        //Setting onClick Listener
        cardWord.setOnClickListener(this);
        cardVocab.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;

        //Adding intents to each Cardview, so that they start the corresponding activity
        //Also overriding the upward motion transition that occurs, with a horizontal slide to add natural flow
        switch (v.getId()) {
            case R.id.CVWordAssociation:
                i = new Intent(this, WordAssociation.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;

            case R.id.CVVocab:
                i = new Intent(this, VocabQuiz.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;

            default:
                break;
        }
    }


    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }


}