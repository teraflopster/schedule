package com.popov.schedule.repositories;

import com.popov.schedule.models.Faculty;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    Optional<Faculty> getFacultyById(Long id);

    Optional<Faculty> getAllByName(String name);
}
