package com.api.starwars.usecase.planet;

import com.api.starwars.model.Planet;
import com.api.starwars.repository.PlanetRepository;
import org.springframework.stereotype.Service;

/**
 * Created by Jessica on 07/07/2017.
 */
@Service
public class DeletePlanets {

    private PlanetRepository planetRepository;

    public DeletePlanets(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public void execute(Long id) {

        planetRepository.delete(id);
    }
}
