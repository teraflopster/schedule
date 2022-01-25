package com.popov.schedule.services;

import com.popov.schedule.models.StudentGroup;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface StudentGroupService {
    void saveStudentGroup(StudentGroup studentGroup);

    Optional<StudentGroup> getStudentGroupById(Long id);

    void deleteStudentGroupById(Long id);

    List<StudentGroup> getAllStudent();

    List<StudentGroup> getGroupByCourseAndDepartment(Long course, Long department);
}
