package com.api.starwars.usecase.film;

import com.api.starwars.model.Film;
import com.api.starwars.repository.FilmRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jessica on 07/07/2017.
 */
@Service
public class FindAllFilms {

    //si le pongo @Autowired tengo que levantar el contexto de spring para poder testear
    // si le pongo @Autowired podria quitar el constructor
    private FilmRepository filmRepository;

    public FindAllFilms(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<Film> execute() {
        return filmRepository.findAll();
    }
}
