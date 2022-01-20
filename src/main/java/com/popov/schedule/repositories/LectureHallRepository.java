package com.popov.schedule.repositories;

import com.popov.schedule.models.LectureHall;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureHallRepository extends JpaRepository<LectureHall, ID> {
}
