package com.popov.schedule.services;

import com.popov.schedule.models.LectureHall;
import com.popov.schedule.repositories.LectureHallRepository;
import org.springframework.stereotype.Service;

@Service
public class LectureHallServiceImpl implements LectureHallService {

    private final LectureHallRepository lectureHallRepository;

    public LectureHallServiceImpl(LectureHallRepository lectureHallRepository) {
        this.lectureHallRepository = lectureHallRepository;
    }

    @Override
    public void saveLectureHall(LectureHall lectureHall) {
        lectureHallRepository.save(lectureHall);
    }

    @Override
    public LectureHall getLectureHallById(Long id) {
        return lectureHallRepository.getById(id);
    }
}
