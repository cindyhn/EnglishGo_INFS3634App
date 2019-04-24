package com.example.assignmentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

public class HomeMenu extends AppCompatActivity implements View.OnClickListener {
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    private CardView quizCard, wotdCard, videoCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_menu);

        //Defining Cards
        quizCard = (CardView) findViewById(R.id.CVQuizCard);
        wotdCard = (CardView) findViewById(R.id.CVWOTDCard);
        videoCard = (CardView) findViewById(R.id.CVVideoCard);


        //Adding OnClick Listener to Cards
        quizCard.setOnClickListener(this);
        wotdCard.setOnClickListener(this);
        videoCard.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        Intent i;

        //Adding intents to each Cardview, so that they start the corresponding activity
        //Also overriding the upward motion transition that occurs, with a horizontal slide to add natural flow
        switch (v.getId()) {
            case R.id.CVQuizCard:
                i = new Intent(this, QuizMenu.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.CVWOTDCard:
                i = new Intent(this, WOTD.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case R.id.CVVideoCard:
                i = new Intent(this, Additional_Resources_Menu.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            default:
                break;
        }

    }

    public void onButtonShowPopupWindowClick(View view) {

        // inflate the layout of the popup window
        LayoutInflater inflater = (LayoutInflater)
                getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.activity_pop_up_window, null);

        // create the popup window
        int width = LinearLayout.LayoutParams.WRAP_CONTENT;
        int height = LinearLayout.LayoutParams.WRAP_CONTENT;
        boolean focusable = true; // lets taps outside the popup also dismiss it
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

        // show the popup window
        // which view you pass in doesn't matter, it is only used for the window tolken
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

        // dismiss the popup window when touched
        popupView.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });


    }
}
