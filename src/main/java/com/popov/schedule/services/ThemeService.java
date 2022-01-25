package com.popov.schedule.services;

import com.popov.schedule.models.Theme;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ThemeService {
    boolean saveTheme(Theme theme);

    boolean updateTheme(String name, Long teacherId, Long id);

    Optional<Theme> getThemeById(Long id);
}
