package com.popov.schedule.services;

import com.popov.schedule.models.Day;
import com.popov.schedule.repositories.DayRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class DayServiceImpl implements DayService {

    private final DayRepository dayRepository;

    public DayServiceImpl(DayRepository dayRepository) {
        this.dayRepository = dayRepository;
    }

    @Override
    public void saveDay(Day day) {
        dayRepository.save(day);
    }

    @Override
    public Optional<Day> getDayById(Long id) {
        return dayRepository.findById(id);
    }

    @Override
    public void deleteDayById(Long id) {
        dayRepository.deleteById(id);
    }

    @Override
    public List<Day> getAllDays() {
        return dayRepository.findAll();
    }

    @Override
    public Optional<Day> getDayByDateAndGroupId(String input, Long id) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM.dd.yyyy") ;
        LocalDate localDate = LocalDate.parse(input, formatter);
        return dayRepository.getDayByLocalDateAndStudentGroupId(localDate, id);
    }
}
