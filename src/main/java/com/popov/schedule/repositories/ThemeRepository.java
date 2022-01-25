package com.popov.schedule.repositories;

import com.popov.schedule.models.Theme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface ThemeRepository extends JpaRepository<Theme, Long> {
    Optional<Theme> getThemeByName(String name);

    @Modifying
    @Transactional
    @Query("UPDATE Theme theme SET theme.name = ?1, theme.teacherId = ?2 where theme.id = ?3")
    void updateTheme(String name, Long teacherId, Long id);
}
