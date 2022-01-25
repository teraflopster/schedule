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
@Table(name = "student_group")
public class StudentGroup {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "course")
    private long course;

    @Column(name = "department_id")
    private long departmentId;

    public StudentGroup() {}

    public StudentGroup(String name, long course, long department_id) {
        this.name = name;
        this.course = course;
        this.departmentId = department_id;
    }
}
