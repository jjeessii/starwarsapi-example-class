package com.api.starwars.usecase.film;

import com.api.starwars.repository.FilmRepository;
import lombok.NonNull;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

/**
 * Created by Jessica on 07/07/2017.
 */
@Service
public class DeleteFilm {
    private FilmRepository filmRepository;

    public DeleteFilm(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }
//@SneakyThrows hace un try catch
    public void execute(@NonNull Long id) {
        filmRepository.delete(id);
    }
}
