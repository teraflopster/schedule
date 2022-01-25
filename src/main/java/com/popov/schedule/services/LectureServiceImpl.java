package com.popov.schedule.services;

import com.popov.schedule.models.Day;
import com.popov.schedule.models.Lecture;
import com.popov.schedule.repositories.LectureRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LectureServiceImpl implements LectureService {

    private final LectureRepository lectureRepository;

    public LectureServiceImpl(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    @Override
    public void saveLecture(Lecture lecture) {
        lectureRepository.save(lecture);
    }

    @Override
    public List<Lecture> getLectureByDay(Long id) {
        return lectureRepository.getLectureByDay(id);
    }
}
