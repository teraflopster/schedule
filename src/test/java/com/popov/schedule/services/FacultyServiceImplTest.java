package com.popov.schedule.services;

import com.popov.schedule.models.Faculty;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@Slf4j
@SpringBootTest
class FacultyServiceImplTest {

    private final FacultyService facultyService;

    @Autowired
    FacultyServiceImplTest(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @Test
    void testSaveFaculty() {
        Faculty faculty = new Faculty("NAME");
        facultyService.saveFaculty(faculty);
        Optional<Faculty> facultyFromDB = facultyService.getFacultyByName(faculty.getName());
        facultyFromDB.ifPresent(value -> Assertions.assertEquals(value, faculty));
        facultyService.deleteById(faculty.getId());
    }

    @Test
    void getFacultyById() {
        Faculty faculty = new Faculty("NAME");
        facultyService.saveFaculty(faculty);
        Optional<Faculty> facultyFromDB = facultyService.getFacultyById(faculty.getId());
        facultyFromDB.ifPresent(value -> Assertions.assertEquals(value, faculty));
        facultyService.deleteById(faculty.getId());
    }

    @Test
    void getFacultyByName() {
        Faculty faculty = new Faculty("NAME");
        facultyService.saveFaculty(faculty);
        Optional<Faculty> facultyFromDB = facultyService.getFacultyById(faculty.getId());
        facultyFromDB.ifPresent(value -> Assertions.assertEquals(value, faculty));
        facultyService.deleteById(faculty.getId());
    }

    @Test
    void deleteById() {
        Faculty faculty = new Faculty("NAME");
        facultyService.saveFaculty(faculty);
        facultyService.deleteById(faculty.getId());
        Optional<Faculty> facultyFromDB = facultyService.getFacultyById(faculty.getId());
        Assertions.assertTrue(facultyFromDB.isEmpty());
    }
}