package com.api.starwars.usecase.planet;

import com.api.starwars.model.Planet;
import com.api.starwars.repository.PlanetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jessica on 07/07/2017.
 */
@Service
public class SavePlanet {
    private PlanetRepository planetRepository;

    public SavePlanet(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public Planet execute(Planet planet)  {
        if(planet == null) throw new NullPointerException("planet is null");
        return planetRepository.save(planet);
    }
}
