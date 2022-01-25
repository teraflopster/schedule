package com.popov.schedule.services;

import com.popov.schedule.models.Teacher;
import com.popov.schedule.repositories.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }


    @Override
    public boolean saveTeacher(Teacher teacher) {
        Optional<Teacher> teacherOptional = teacherRepository.getTeacherByName(teacher.getName());

        if (teacherOptional.isPresent()) {
            return false;
        }

        teacherRepository.save(teacher);

        return true;
    }

    @Override
    public Optional<Teacher> getTeacherById(Long id) {
        return teacherRepository.getTeacherById(id);
    }

    @Override
    public Optional<Teacher> getTeacherByName(String name) {
        return teacherRepository.getTeacherByName(name);
    }

    @Override
    public boolean updateTeacher(String name, Long departmentId, Long id) {
        Optional<Teacher> teacherOptional = teacherRepository.getTeacherById(id);

        if (teacherOptional.isEmpty()) {
            return false;
        }

        teacherRepository.updateTeacher(name, departmentId, id);

        return true;
    }

    @Override
    public boolean deleteTeacher(Long id) {
        Optional<Teacher> teacherOptional = teacherRepository.getTeacherById(id);

        if (teacherOptional.isEmpty()) {
            return false;
        }

        teacherRepository.deleteTeacherById(id);

        return true;
    }
}
