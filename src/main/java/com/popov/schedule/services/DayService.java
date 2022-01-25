package com.popov.schedule.services;

import com.popov.schedule.models.Day;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DayService {
    void saveDay(Day day);

    Optional<Day> getDayById(Long id);

    void deleteDayById(Long id);

    List<Day> getAllDays();

}
