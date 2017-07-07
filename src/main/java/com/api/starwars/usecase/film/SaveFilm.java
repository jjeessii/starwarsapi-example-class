package com.api.starwars.usecase.film;

import com.api.starwars.model.Film;
import com.api.starwars.model.People;
import com.api.starwars.model.Planet;
import com.api.starwars.repository.FilmRepository;
import com.api.starwars.repository.PeopleRepository;
import com.api.starwars.repository.PlanetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jessica on 07/07/2017.
 */
@Service
public class SaveFilm {

    private FilmRepository filmRepository;
    private PlanetRepository planetRepository;
    private PeopleRepository peopleRepository;

    public SaveFilm(FilmRepository filmRepository, PlanetRepository planetRepository, PeopleRepository peopleRepository) {
        this.filmRepository = filmRepository;
        this.planetRepository = planetRepository;
        this.peopleRepository = peopleRepository;
    }

    public Film execute(Film film, List<Planet> planets, List<People> peoples) {
        createPlanetsWhenNotExists(film);
        createPeopleWhenNotExist(film);
        return filmRepository.save(film);
    }

    private void createPeopleWhenNotExist(Film film) {
        film.getPeople().forEach((People people) -> {
            if(!peopleRepository.exists(people.getPeopleId())) {
                peopleRepository.save(people);
            }
        });
    }

    private void createPlanetsWhenNotExists(Film film) {
        film.getPlanets().forEach((Planet planet) -> {
            if(!planetRepository.exists(planet.getId())) {
                planetRepository.save(planet);
            }
        });
    }
}
