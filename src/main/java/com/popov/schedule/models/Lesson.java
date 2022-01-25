package com.popov.schedule.models;

import lombok.Data;

@Data
public class Lesson {
    private String theme;
    private String teacher;
    private String lectureHall;

    public Lesson(String theme, String teacher, String lectureHall) {
        this.theme = theme;
        this.teacher = teacher;
        this.lectureHall = lectureHall;
    }
}
