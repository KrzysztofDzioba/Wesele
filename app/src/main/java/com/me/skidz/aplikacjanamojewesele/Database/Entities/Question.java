package com.me.skidz.aplikacjanamojewesele.Database.Entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by skidz on 09.06.2018.
 */

@Entity
public class Question {

    @PrimaryKey
    public int id;

    public String question;

    public Question(int id, String question) {
        this.id = id;
        this.question = question;
    }
}
