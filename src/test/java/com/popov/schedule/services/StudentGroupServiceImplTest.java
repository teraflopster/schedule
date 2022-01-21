package com.popov.schedule.services;

import com.popov.schedule.models.Department;
import com.popov.schedule.models.Faculty;
import com.popov.schedule.models.StudentGroup;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class StudentGroupServiceImplTest {

    private final StudentGroupService studentGroupService;
    private final DepartmentService departmentService;
    private final FacultyService facultyService;

    @Autowired
    StudentGroupServiceImplTest(StudentGroupService studentGroupService, DepartmentService departmentService, FacultyService facultyService) {
        this.studentGroupService = studentGroupService;
        this.departmentService = departmentService;
        this.facultyService = facultyService;
    }

    @Test
    void saveStudentGroup() {
        Faculty faculty = new Faculty("NAME");
        facultyService.saveFaculty(faculty);
        Department department = new Department("NAME", faculty.getId());
        departmentService.saveDepartment(department);
        StudentGroup studentGroup = new StudentGroup("KNDM-51", 5, department.getId());
        studentGroupService.saveStudentGroup(studentGroup);
        Optional<StudentGroup> studentGroupFromDB = studentGroupService.getStudentGroupById(studentGroup.getId());
        studentGroupFromDB.ifPresent(value -> Assertions.assertEquals(value, studentGroup));
        studentGroupService.deleteStudentGroupById(studentGroup.getId());
        departmentService.deleteDepartmentById(department.getId());
        facultyService.deleteFacultyById(faculty.getId());
    }
}