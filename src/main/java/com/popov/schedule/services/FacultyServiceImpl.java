package com.popov.schedule.services;

import com.popov.schedule.models.Faculty;
import com.popov.schedule.repositories.FacultyRepository;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepository facultyRepository;

    public FacultyServiceImpl(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }


    @Override
    public void saveFaculty(Faculty faculty) {
        facultyRepository.save(faculty);
    }

    @Override
    public Optional<Faculty> getFacultyById(Long id) {
        return facultyRepository.getFacultyById(id);
    }

    @Override
    public Optional<Faculty> getFacultyByName(String name) {
        return facultyRepository.getAllByName(name);
    }

    @Override
    public void deleteFacultyById(Long id) {
        facultyRepository.deleteById(id);
    }

    @Override
    public List<Faculty> findAllFaculty() {
        return facultyRepository.findAll();
    }
}
