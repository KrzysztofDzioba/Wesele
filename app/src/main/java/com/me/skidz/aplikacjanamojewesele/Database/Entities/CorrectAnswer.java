package com.me.skidz.aplikacjanamojewesele.Database.Entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;

/**
 * Created by skidz on 09.06.2018.
 */

@Entity(tableName = "CorrectAnswer",
        primaryKeys = { "answerId", "questionId" },
        foreignKeys = {
                @ForeignKey(entity = Answer.class,
                        parentColumns = "id",
                        childColumns = "answerId"),
                @ForeignKey(entity = Question.class,
                        parentColumns = "id",
                        childColumns = "questionId")
        })
public class CorrectAnswer {

    public final int answerId;
    public final int questionId;

    public CorrectAnswer(final int answerId, final int questionId) {
        this.answerId = answerId;
        this.questionId = questionId;
    }
}
