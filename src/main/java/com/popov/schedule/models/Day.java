package com.popov.schedule.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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

    public Day() {}

    public Day(String date, long student_group_id) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "yyyy-MM-dd" );
        this.localDate = LocalDate.parse(date, formatter);
    }

    public void setDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "yyyy-MM-dd" );
        this.localDate = LocalDate.parse(date, formatter);
    }
}
