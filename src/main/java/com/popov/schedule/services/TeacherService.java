package com.popov.schedule.services;

import com.popov.schedule.models.Teacher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface TeacherService {
    boolean saveTeacher(Teacher teacher);

    Optional<Teacher> getTeacherById(Long id);

    Optional<Teacher> getTeacherByName(String name);

    boolean updateTeacher(String name, Long departmentId, Long id);

    boolean deleteTeacher(Long id);
}
