package com.api.starwars.repository;

import com.api.starwars.model.Film;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by accesoeps on 30/06/17.
 */
@Slf4j
public class FilmRepositoryImpl implements CustomFilmRepository {

    @Override
    public void logFilm(Film film) {
        log.info(film.toString());
    }
}
