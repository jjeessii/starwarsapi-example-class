package com.api.starwars.usecase.film;

import com.api.starwars.model.Film;
import com.api.starwars.repository.FilmRepository;
import org.springframework.stereotype.Service;

/**
 * Created by Jessica on 07/07/2017.
 */
@Service
public class FindFilm {
    private FilmRepository filmRepository;

    public FindFilm(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public Film execute(Long id) {
        return filmRepository.findOne(id);
    }
}
