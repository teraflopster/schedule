package com.popov.schedule.services;

import com.popov.schedule.models.LectureHall;
import org.springframework.stereotype.Service;

@Service
public interface LectureHallService {
    void saveLectureHall(LectureHall lectureHall);

    LectureHall getLectureHallById(Long id);
}
