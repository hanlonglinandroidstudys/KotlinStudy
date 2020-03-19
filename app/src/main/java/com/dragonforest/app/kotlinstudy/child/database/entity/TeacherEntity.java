package com.dragonforest.app.kotlinstudy.child.database.entity;

import org.litepal.crud.LitePalSupport;

/**
 * create by DragonForest at 2020/3/17
 */
public class TeacherEntity extends LitePalSupport {
    String name;
    String hobby;
    long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
