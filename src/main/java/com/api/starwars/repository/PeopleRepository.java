package com.api.starwars.repository;

import com.api.starwars.model.People;
import com.api.starwars.model.Planet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Collection;
import java.util.List;

/**
 * Created by accesoeps on 30/06/17.
 */
@Repository
public interface PeopleRepository extends JpaRepository<People, Long> {
    People findByNameIgnoreCase(String name);

    //con: @Query("select ...") ya no implementa lo que esta debajo;
    List<People> findByHeightGreaterThanEqual(String height);
    List<People> findByEyeColorIn(Collection<String> eyeColors);
    List<People> findFirst20ByOrderByMassDesc();
    List<People> findByEyeColorInOrderByNameAsc(Collection<String> eyesColor);


    @Query(value= "select p from People p where name like 'S%'", nativeQuery = true)
    List<People> findByNameStartingWith(String name);

    List<Planet> findByName(String name);
    Page<Planet> findAllBy(Pageable pageable);

}
