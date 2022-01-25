package com.popov.schedule.services;

import com.popov.schedule.models.Day;
import com.popov.schedule.models.Lecture;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LectureService {
    void saveLecture(Lecture lecture);

    List<Lecture> getLectureByDay(Long id);
}
