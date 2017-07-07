package com.api.starwars.usecase.planet;

import com.api.starwars.model.Planet;
import com.api.starwars.repository.PlanetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jessica on 07/07/2017.
 */
@Service
public class FindAllPlanets {

    private PlanetRepository planetRepository;

    public FindAllPlanets(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public List<Planet> execute() {

        return planetRepository.findAll();
    }
}
