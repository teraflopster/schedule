package com.popov.schedule.services;

import com.popov.schedule.models.StudentGroup;
import com.popov.schedule.repositories.StudentGroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentGroupServiceImpl implements StudentGroupService {

    private final StudentGroupRepository studentGroupRepository;

    public StudentGroupServiceImpl(StudentGroupRepository studentGroupRepository) {
        this.studentGroupRepository = studentGroupRepository;
    }

    @Override
    public void saveStudentGroup(StudentGroup studentGroup) {
        studentGroupRepository.save(studentGroup);
    }

    @Override
    public Optional<StudentGroup> getStudentGroupById(Long id) {
        return studentGroupRepository.getStudentGroupById(id);
    }

    @Override
    public void deleteStudentGroupById(Long id) {
        studentGroupRepository.deleteById(id);
    }

    @Override
    public List<StudentGroup> getAllStudent() {
        return studentGroupRepository.findAll();
    }

    @Override
    public List<StudentGroup> getGroupByCourseAndDepartment(Long course, Long departmentId) {
        return studentGroupRepository.getStudentGroupByCourseAndDepartmentId(course, departmentId);
    }
}
