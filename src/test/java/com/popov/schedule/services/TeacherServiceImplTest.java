package com.popov.schedule.services;

import com.popov.schedule.models.Teacher;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@Slf4j
@SpringBootTest
class TeacherServiceImplTest {

    private final TeacherService teacherService;

    @Autowired
    TeacherServiceImplTest(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    Teacher teacher = new Teacher("TEST", 1L);
    @Test
    void saveTeacher() {

        Assertions.assertNull(teacherService.getTeacherByName(teacher.getName()));
        Assertions.assertTrue(teacherService.saveTeacher(teacher));
        Assertions.assertNotNull(teacherService.getTeacherByName(teacher.getName()));
    }

    @Test
    void getTeacherById() {
        Teacher teacher = new Teacher("TEST", 1L);
        teacherService.saveTeacher(teacher);
        Optional<Teacher> teacherOptional = teacherService.getTeacherByName(teacher.getName());
        Optional<Teacher> optionalTeacher = teacherService.getTeacherById(teacherOptional.get().getId());
        Assertions.assertEquals(teacher, optionalTeacher.get());
        teacherService.deleteTeacher(teacherOptional.get().getId());
    }

    @Test
    void getTeacherByName() {
        Teacher teacher = new Teacher("TEST", 1L);
        teacherService.saveTeacher(teacher);
        Optional<Teacher> teacherOptional = teacherService.getTeacherByName(teacher.getName());
        Assertions.assertEquals(teacher, teacherOptional.get());
        teacherService.deleteTeacher(teacherOptional.get().getId());
    }

    @Test
    void updateTeacher() {
        Teacher teacher = new Teacher("TEST", 1L);
        teacherService.saveTeacher(teacher);
        Optional<Teacher> teacherOptional = teacherService.getTeacherByName(teacher.getName());
        Teacher newTeacher = new Teacher("JUNIT", 1L);
        Assertions.assertTrue(teacherService.updateTeacher(
                newTeacher.getName(),newTeacher.getDepartmentId(), teacherOptional.get().getId()));
        Assertions.assertTrue(newTeacher.equals(teacherService.getTeacherByName(newTeacher.getName()).get()));
    }

//    @Test
//    void deleteTeacher() {
//        Teacher teacherFromDB = teacherService.getTeacherByName("JUNIT");
//        Assertions.assertTrue(teacherService.deleteTeacher(teacherFromDB.getId()));
//    }
}