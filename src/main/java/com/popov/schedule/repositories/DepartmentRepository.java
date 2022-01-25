package com.popov.schedule.repositories;

import com.popov.schedule.models.Department;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> getDepartmentById(Long id);
    List<Department> getDepartmentByFacultyId(Long id);
}
