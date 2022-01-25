package com.popov.schedule.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "theme")
public class Theme {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "teacher_id")
    private long teacherId;

    public Theme() {}

    public Theme(String name, long teacher_id) {
        this.name = name;
        this.teacherId = teacher_id;
    }
}
