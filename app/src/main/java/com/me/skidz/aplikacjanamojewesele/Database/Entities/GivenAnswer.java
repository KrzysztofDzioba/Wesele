package com.me.skidz.aplikacjanamojewesele.Database.Entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

/**
 * Created by skidz on 09.06.2018.
 */

@Entity(tableName = "GivenAnswer",
        primaryKeys = { "answerId", "questionId" },
        foreignKeys = {
        @ForeignKey(entity = Question.class,
                    parentColumns = "id",
                    childColumns = "questionId"),
        @ForeignKey(entity = Answer.class,
                    parentColumns = "id",
                    childColumns = "answerId"),
        @ForeignKey(entity = User.class,
                    parentColumns = "id",
                    childColumns = "userId")
})
public class GivenAnswer {
    public final int questionId;
    public final int answerId;
    public final int userId;


    public GivenAnswer(int questionId, int answerId, int userId) {
        this.questionId = questionId;
        this.answerId = answerId;
        this.userId = userId;
    }
}
