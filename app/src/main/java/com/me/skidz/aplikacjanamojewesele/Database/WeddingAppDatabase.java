package com.me.skidz.aplikacjanamojewesele.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.me.skidz.aplikacjanamojewesele.Database.Dao.AnswerDao;
import com.me.skidz.aplikacjanamojewesele.Database.Dao.CorrectAnswerDao;
import com.me.skidz.aplikacjanamojewesele.Database.Dao.QuestionDao;
import com.me.skidz.aplikacjanamojewesele.Database.Entities.Answer;
import com.me.skidz.aplikacjanamojewesele.Database.Entities.CorrectAnswer;
import com.me.skidz.aplikacjanamojewesele.Database.Entities.Question;

/**
 * Created by skidz on 09.06.2018.
 */

@Database(entities = {Answer.class, CorrectAnswer.class, Question.class}, version = 1)
public abstract class WeddingAppDatabase extends RoomDatabase {

    public abstract AnswerDao answerDao();
    public abstract CorrectAnswerDao correctAnswerDao();
    public abstract QuestionDao questionDao();
}
