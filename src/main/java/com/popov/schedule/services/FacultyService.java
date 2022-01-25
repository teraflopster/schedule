package com.popov.schedule.services;

import com.popov.schedule.models.Faculty;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface FacultyService {

    void saveFaculty(Faculty faculty);

    Optional<Faculty> getFacultyById(Long id);

    Optional<Faculty> getFacultyByName(String name);

    void deleteFacultyById(Long id);

    List<Faculty> findAllFaculty();
}
