package com.popov.schedule.services;

import com.popov.schedule.models.Department;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface DepartmentService {
    void saveDepartment(Department department);

    Optional<Department> getDepartmentById(Long id);

    void deleteDepartmentById(Long id);

    List<Department> getAllDepartmentsByFaculty(Long id);
}
