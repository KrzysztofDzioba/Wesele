package com.me.skidz.aplikacjanamojewesele.Database.Entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by skidz on 09.06.2018.
 */

@Entity
public class Answer {

    @PrimaryKey
    public int id;

    public String answer;

    public Answer(int id, String answer) {
        this.id = id;
        this.answer = answer;
    }

    @Override
    public String toString() {
        return " Answer: " + answer;
    }
}
