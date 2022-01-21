package com.popov.schedule.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@Entity
@Table(name = "day")
public class Day {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "date")
    private LocalDate localDate;

    @Column(name = "student_group_id")
    private long studentGroupId;

    public Day() {}

    public Day(String date, long student_group_id) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "MM/dd/yyyy" );
        this.localDate = LocalDate.parse(date, formatter);
        this.studentGroupId = student_group_id;
    }

    public void setDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "MM/dd/yyyy" );
        this.localDate = LocalDate.parse(date, formatter);
    }
}
