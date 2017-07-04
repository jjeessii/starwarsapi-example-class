package com.api.starwars.repository;

import com.api.starwars.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by accesoeps on 30/06/17.
 */
public interface CustomFilmRepository {

    public void logFilm(Film film);

}
