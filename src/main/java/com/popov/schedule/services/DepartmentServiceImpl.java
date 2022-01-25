package com.popov.schedule.services;

import com.popov.schedule.models.Department;
import com.popov.schedule.repositories.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void saveDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public Optional<Department> getDepartmentById(Long id) {
        return departmentRepository.getDepartmentById(id);
    }

    @Override
    public void deleteDepartmentById(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public List<Department> getAllDepartmentsByFaculty(Long id) {
        return departmentRepository.getDepartmentByFacultyId(id);
    }
}
