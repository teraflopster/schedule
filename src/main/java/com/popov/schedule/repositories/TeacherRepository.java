package com.popov.schedule.repositories;

import com.popov.schedule.models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    @Transactional
    void deleteTeacherById(Long id);

    Optional<Teacher> getTeacherByName(String name);

    Optional<Teacher> getTeacherById(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Teacher teacher SET teacher.name = ?1, teacher.departmentId = ?2 where teacher.id = ?3")
    void updateTeacher(String name, Long departmentId, Long id);

}
