package com.me.skidz.aplikacjanamojewesele.Database.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.me.skidz.aplikacjanamojewesele.Database.Entities.CorrectAnswer;

/**
 * Created by skidz on 09.06.2018.
 */

@Dao
public interface CorrectAnswerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addCorrectAnswer(CorrectAnswer correctAnswer);

    @Query(value = "SELECT answerId FROM CorrectAnswer WHERE :questionId == questionId")
    int getCorrectAnswer(int questionId);
}
