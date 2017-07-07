package com.api.starwars.rest;

import com.api.starwars.model.Film;
import com.api.starwars.model.People;
import com.api.starwars.model.Planet;
import com.api.starwars.usecase.film.FindAllFilms;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


/**
 * Created by Jessica on 07/07/2017.
 */
@Controller
@RequestMapping(path = "/films")
@AllArgsConstructor
public class FilmController {
    private FindAllFilms findAllFilms;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Film>> findAll() {
        List<Film> films = findAllFilms.execute();

        films.forEach((Film film) -> {
            film.getPlanets().forEach((Planet planet) -> {
                if(!planet.hasLink("self")){
                    Link selfLink = linkTo(methodOn(PlanetController.class)
                        .findById(planet.getId())).withSelfRel();
                    planet.add(selfLink);
                }
            }) ;
        });
        return new ResponseEntity<List<Film>>(films, HttpStatus.OK);
    }


}
