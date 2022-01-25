package com.popov.schedule.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "lecture")
public class Lecture {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "day_id")
    private long day;

    @Column(name = "theme_id")
    private long themeId;

    @Column(name = "lecture_hall_id")
    private long lectureHallId;

    @Column(name = "student_group_id")
    private long studentGroupId;

    public Lecture() {
    }

    public Lecture(long day_id, long theme_id, long lecture_hall_id) {
        this.day = day_id;
        this.themeId = theme_id;
        this.lectureHallId = lecture_hall_id;
    }
}
