package com.api.starwars.usecase.planet;

import com.api.starwars.model.Planet;
import com.api.starwars.repository.PlanetRepository;
import org.springframework.stereotype.Service;

/**
 * Created by Jessica on 07/07/2017.
 */
@Service
public class FindPlanet {

    private PlanetRepository planetRepository;

    public FindPlanet(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public Planet execute(Long id) {

        return planetRepository.findOne(id);
    }

}
