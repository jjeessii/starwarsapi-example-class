package com.api.starwars.rest;

import com.api.starwars.model.Film;
import com.api.starwars.model.Planet;
import com.api.starwars.usecase.film.FindAllFilms;
import com.api.starwars.usecase.planet.DeletePlanets;
import com.api.starwars.usecase.planet.FindAllPlanets;
import com.api.starwars.usecase.planet.FindPlanet;
import com.api.starwars.usecase.planet.SavePlanet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Jessica on 07/07/2017.
 */
//@RestController("/planets")
@Controller
@RequestMapping(path = "/planets")
public class PlanetController {
    private FindAllPlanets findAllPlanets;
    private SavePlanet savePlanet;
    private FindPlanet findPlanet;
    private DeletePlanets deletePlanets;

    public PlanetController(FindAllPlanets findAllPlanets, SavePlanet savePlanet, FindPlanet findPlanet, DeletePlanets deletePlanets) {
        this.findAllPlanets = findAllPlanets;
        this.savePlanet = savePlanet;
        this.findPlanet = findPlanet;
        this.deletePlanets = deletePlanets;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Planet>> findAll() {
        List<Planet> planets = findAllPlanets.execute();

        return new ResponseEntity<List<Planet>>(planets, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Planet> save(@RequestBody Planet planet) {
        Planet saved = savePlanet.execute(planet);
        return new ResponseEntity<Planet>(saved, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<Planet> update(@PathVariable Long id, @RequestBody Planet planet) {
        Planet found = findPlanet.execute(id);
        if(found == null) {
            return new ResponseEntity<Planet>(HttpStatus.NO_CONTENT);
        }

        Planet updated = savePlanet.execute(planet);
        return new ResponseEntity<Planet>(updated, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity<Planet> delete(@PathVariable Long id) {
        deletePlanets.execute(id);
        return new ResponseEntity<Planet>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity<Planet> findById(Long id) {
        Planet planet = findPlanet.execute(id);
        return new ResponseEntity<Planet>(planet, HttpStatus.OK);
    }
}
