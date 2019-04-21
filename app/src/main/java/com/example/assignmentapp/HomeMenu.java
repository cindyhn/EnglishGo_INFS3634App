package com.example.assignmentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class HomeMenu extends AppCompatActivity implements View.OnClickListener {
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";


    private CardView quizCard, wotdCard, dictionaryCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_menu);

        //Defining Cards
        quizCard = (CardView) findViewById(R.id.CVQuizCard);
        wotdCard = (CardView) findViewById(R.id.CVWOTDCard);
        dictionaryCard = (CardView) findViewById(R.id.CVDictionaryCard);

        //Adding OnClick Listener to Cards
        quizCard.setOnClickListener(this);
        wotdCard.setOnClickListener(this);
        dictionaryCard.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.CVQuizCard:
                i = new Intent(this, QuizMenu.class); startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.CVWOTDCard:
                i = new Intent(this, WOTD.class); startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.CVDictionaryCard:
                i = new Intent(this, Dictionary.class); startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            default: break;
        }

    }




}
