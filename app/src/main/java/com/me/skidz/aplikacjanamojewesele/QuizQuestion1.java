package com.me.skidz.aplikacjanamojewesele;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class QuizQuestion1 extends AppCompatActivity {

    private Button q1a1;
    private Button q1a2;
    private Button q1a3;
    private Button q1a4;

    public int givenAnswer;
    public static String answerNumber = "answerNumber";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_question1);

        setButtons();
        setOnClicks();

    }

    private void setButtons() {
        q1a1 = findViewById(R.id.q1a1);
        q1a2 = findViewById(R.id.q1a2);
        q1a3 = findViewById(R.id.q1a3);
        q1a4 = findViewById(R.id.q1a4);
    }

    private void setOnClicks() {
        q1a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                givenAnswer = 1;
                startNextActivity();
            }
        });

        q1a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                givenAnswer = 2;
                startNextActivity();
            }
        });

        q1a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                givenAnswer = 3;
                startNextActivity();
            }
        });

        q1a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                givenAnswer = 4;
                startNextActivity();
            }
        });
    }

    private void startNextActivity() {
        Class nextActivityClass = QuizEnd.class;
        Intent nextActivity = new Intent(this, nextActivityClass);
        nextActivity.putExtra(answerNumber, givenAnswer);
        startActivity(nextActivity);
    }




}
