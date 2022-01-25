package com.popov.schedule.repositories;

import com.popov.schedule.models.StudentGroup;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentGroupRepository extends JpaRepository<StudentGroup, Long> {
    Optional<StudentGroup> getStudentGroupById(Long id);
    List<StudentGroup> getStudentGroupByCourseAndDepartmentId(Long course, Long departmentId);
}
