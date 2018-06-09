package com.me.skidz.aplikacjanamojewesele.Database.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;

import com.me.skidz.aplikacjanamojewesele.Database.Entities.Question;

/**
 * Created by skidz on 09.06.2018.
 */

@Dao
public interface QuestionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addNewQuestion(Question question);
}
