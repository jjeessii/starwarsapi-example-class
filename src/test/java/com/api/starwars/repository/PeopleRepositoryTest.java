package com.api.starwars.repository;

import com.api.starwars.model.People;
import com.api.starwars.model.Planet;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

/**
 * Created by accesoeps on 30/06/17.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
//@AllArgsConstructor
public class PeopleRepositoryTest {

    //injeccion de dependencias
    @Autowired
    private PeopleRepository peopleRepository;

//    si ponemos @AllArgsConstructor las lineas de abajo no hace falta ponerlas
//    public PlanetRepositoryTest(PlanetRepository planetRepository){
//        this.planetRepository = planetRepository;
//    }

    @Test
    public void should_find_top_20_height_people() throws Exception {
        List<People> peopleList = peopleRepository.findFirst20ByOrderByMassDesc();
        Assert.assertNotNull(peopleList);
    }



}
