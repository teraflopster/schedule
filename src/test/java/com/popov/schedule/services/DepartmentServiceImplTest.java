package com.popov.schedule.services;

import com.popov.schedule.models.Department;
import com.popov.schedule.models.Faculty;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@Slf4j
@SpringBootTest
class DepartmentServiceImplTest {

    private final DepartmentService departmentService;

    private final FacultyService facultyService;

    @Autowired
    DepartmentServiceImplTest(DepartmentService departmentService, FacultyService facultyService) {
        this.departmentService = departmentService;
        this.facultyService = facultyService;
    }

    @Test
    void saveDepartment() {
        Faculty faculty = new Faculty("NAME");
        facultyService.saveFaculty(faculty);
        Department department = new Department("CS", faculty.getId());
        departmentService.saveDepartment(department);
        Optional<Department> departmentFromDB = departmentService.getDepartmentById(department.getId());
        departmentFromDB.ifPresent(value -> Assertions.assertEquals(value, department));
        departmentService.deleteDepartmentById(department.getId());
        facultyService.deleteFacultyById(faculty.getId());
    }


    @Test
    void getDepartmentById() {
        Faculty faculty = new Faculty("NAME");
        facultyService.saveFaculty(faculty);
        Department department = new Department("CS", faculty.getId());
        departmentService.saveDepartment(department);
        Optional<Department> departmentFromDB = departmentService.getDepartmentById(department.getId());
        departmentFromDB.ifPresent(value -> Assertions.assertEquals(value, department));
        departmentService.deleteDepartmentById(department.getId());
        facultyService.deleteFacultyById(faculty.getId());
    }

    @Test
    void deleteDepartmentById() {
        Faculty faculty = new Faculty("NAME");
        facultyService.saveFaculty(faculty);
        Department department = new Department("CS", faculty.getId());
        departmentService.saveDepartment(department);
        departmentService.deleteDepartmentById(department.getId());
        Optional<Department> departmentFromDB = departmentService.getDepartmentById(department.getId());
        Assertions.assertTrue(departmentFromDB.isEmpty());
        facultyService.deleteFacultyById(faculty.getId());
    }
}