package com.popov.schedule.repositories;

import com.popov.schedule.models.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface DayRepository extends JpaRepository<Day, Long> {
    Optional<Day> getDayByLocalDateAndStudentGroupId(LocalDate localDate, Long id);
}
