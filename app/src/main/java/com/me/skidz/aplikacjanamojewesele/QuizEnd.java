package com.me.skidz.aplikacjanamojewesele;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.me.skidz.aplikacjanamojewesele.Database.Entities.Answer;
import com.me.skidz.aplikacjanamojewesele.Database.Entities.CorrectAnswer;
import com.me.skidz.aplikacjanamojewesele.Database.Entities.Question;
import com.me.skidz.aplikacjanamojewesele.Database.WeddingAppDatabase;

public class QuizEnd extends AppCompatActivity {

    final String DATABASE_NAME = "wedding.db";
    WeddingAppDatabase db;


    private TextView quizEndText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_end);

        quizEndText = findViewById(R.id.quizEndText);

        testingDb();
    }

    private void testingDb() {
        WeddingAppDatabase db = Room.databaseBuilder(getApplicationContext(), WeddingAppDatabase.class, DATABASE_NAME)
                .allowMainThreadQueries()
                .build();

        Question firstQuestion = new Question(1, getString(R.string.pytanie1));
        db.questionDao().addNewQuestion(firstQuestion);

        String q1a1 = getString(R.string.odpowiedz1Pyt1);
        String q1a2 = getString(R.string.odpowiedz2Pyt1);
        String q1a3 = getString(R.string.odpowiedz3Pyt1);
        String q1a4 = getString(R.string.odpowiedz4Pyt1);

        db.answerDao().addAnswer(new Answer(1, q1a1));
        db.answerDao().addAnswer(new Answer(2, q1a2));
        db.answerDao().addAnswer(new Answer(3, q1a3));
        db.answerDao().addAnswer(new Answer(4, q1a4));

        CorrectAnswer correctAnswer = new CorrectAnswer(4, 1);
        db.correctAnswerDao().addCorrectAnswer(correctAnswer);

        Intent thisActivity = getIntent();
        Bundle extras = thisActivity.getExtras();
        int answerNumber = extras.getInt(QuizQuestion1.answerNumber);
        
        boolean answerIsCorrect = db.correctAnswerDao().getCorrectAnswer(1) == answerNumber;
        String message = answerIsCorrect ? "Brawo! :D" : "Niestety nie :(";

        quizEndText.setText(message);
    }
}
