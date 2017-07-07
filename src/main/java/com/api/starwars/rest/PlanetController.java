package com.api.starwars.rest;

import com.api.starwars.model.Film;
import com.api.starwars.model.Planet;
import com.api.starwars.usecase.film.FindAllFilms;
import com.api.starwars.usecase.planet.FindAllPlanets;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Jessica on 07/07/2017.
 */
@RestController("/planets")
//@Controller  es lo mismo de arriba
//@RequestMapping(path = "planets")
public class PlanetController {
    private FindAllPlanets findAllPlanets;

    public PlanetController(FindAllPlanets findAllPlanets) {
        this.findAllPlanets = findAllPlanets;
    }

    @GetMapping()
    public ResponseEntity<List<Planet>> findAll() {
        List<Planet> planets = findAllPlanets.execute();

        return new ResponseEntity<List<Planet>>(planets, HttpStatus.OK);
    }
}
