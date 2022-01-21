package com.popov.schedule.services;

import com.popov.schedule.models.Day;
import com.popov.schedule.models.Department;
import com.popov.schedule.models.Faculty;
import com.popov.schedule.models.StudentGroup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class DayServiceImplTest {

    private final StudentGroupService studentGroupService;
    private final DepartmentService departmentService;
    private final FacultyService facultyService;
    private final DayService dayService;

    @Autowired
    DayServiceImplTest(StudentGroupService studentGroupService, DepartmentService departmentService, FacultyService facultyService, DayService dayService) {
        this.studentGroupService = studentGroupService;
        this.departmentService = departmentService;
        this.facultyService = facultyService;
        this.dayService = dayService;
    }

    @Test
    void saveDay() {
        Faculty faculty = new Faculty("NAME");
        facultyService.saveFaculty(faculty);
        Department department = new Department("NAME", faculty.getId());
        departmentService.saveDepartment(department);
        StudentGroup studentGroup = new StudentGroup("KNDM-51", 5, department.getId());
        studentGroupService.saveStudentGroup(studentGroup);
        Day day = new Day("01/20/2022", studentGroup.getId());
        dayService.saveDay(day);
        Optional<Day> dayOptional = dayService.getDayById(day.getId());
        dayOptional.ifPresent(value -> Assertions.assertEquals(value, day));
        dayService.deleteDayById(day.getId());
        studentGroupService.deleteStudentGroupById(studentGroup.getId());
        departmentService.deleteDepartmentById(department.getId());
        facultyService.deleteFacultyById(faculty.getId());
    }
}