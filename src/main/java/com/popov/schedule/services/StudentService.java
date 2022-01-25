package com.popov.schedule.services;

import com.popov.schedule.models.Student;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface StudentService {
    void saveStudent(Student student);

    Optional<Student> getStudentById(Long id);
}
