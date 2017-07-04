package com.api.starwars.repository;

import com.api.starwars.model.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

/**
 * Created by accesoeps on 30/06/17.
 */
@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long>{

    Planet findByName(String name); //con crudrepository accedemos a las opciones de un crud
    List<Planet> findPlanetBy(String name);
    List<Planet> findPlanetsByOrderByNameDesc();
    List<Planet> findPlanetsByPopulationIsGreaterThan(Long Population);
    List<Planet> findPlanetsByPopulationBetween(Long min, Long max);
    List<Planet> findTop10ByOrderByPopulationAsc();
    List<Planet> findTop10ByOrderByPopulationDesc();


}
