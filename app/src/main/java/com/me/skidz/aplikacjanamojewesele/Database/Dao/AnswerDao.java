package com.me.skidz.aplikacjanamojewesele.Database.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.me.skidz.aplikacjanamojewesele.Database.Entities.Answer;

/**
 * Created by skidz on 09.06.2018.
 */

@Dao
public interface AnswerDao {

    @Insert
    void addAnswer(Answer answer);

    @Query(value = "SELECT * FROM answer")
    public Answer[] getAnswers();
}
