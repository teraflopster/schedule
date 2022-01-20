package com.popov.schedule.services;

import com.popov.schedule.models.Faculty;
import com.popov.schedule.repositories.FacultyRepository;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface FacultyService {

    void saveFaculty(Faculty faculty);

    Optional<Faculty> getFacultyById(Long id);

    Optional<Faculty> getFacultyByName(String name);

    void deleteById(Long id);

}
