package com.popov.schedule.services;

import com.popov.schedule.models.Theme;
import com.popov.schedule.repositories.ThemeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ThemeServiceImpl implements ThemeService {

    public final ThemeRepository themeRepository;

    public ThemeServiceImpl(ThemeRepository themeRepository) {
        this.themeRepository = themeRepository;
    }

    @Override
    public boolean saveTheme(Theme theme) {
        Optional<Theme> themeOptional = themeRepository.getThemeByName(theme.getName());

        if (themeOptional.isPresent()) {
            return false;
        }

        themeRepository.save(theme);

        return true;
    }

    @Override
    public boolean updateTheme(String name, Long teacherId, Long id) {
        Optional<Theme> themeOptional = themeRepository.findById(id);
        if (themeOptional.isEmpty()) {
            return false;
        }

        themeRepository.updateTheme(name, teacherId, id);

        return true;
    }

    @Override
    public Optional<Theme> getThemeById(Long id) {
        return themeRepository.findById(id);
    }
}
