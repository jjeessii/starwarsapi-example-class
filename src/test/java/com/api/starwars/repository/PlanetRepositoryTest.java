package com.api.starwars.repository;

import com.api.starwars.model.Planet;
import lombok.AllArgsConstructor;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by accesoeps on 30/06/17.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
//@AllArgsConstructor
public class PlanetRepositoryTest {

    //injeccion de dependencias
    @Autowired
    private PlanetRepository planetRepository;

//    si ponemos @AllArgsConstructor las lineas de abajo no hace falta ponerlas
//    public PlanetRepositoryTest(PlanetRepository planetRepository){
//        this.planetRepository = planetRepository;
//    }

    @Test
    public void should_find_by_name() throws Exception {
        Planet alderaan = planetRepository.findByName("Alderaan");
        Assert.assertThat(alderaan.getName(), is("Alderaan"));
    }


    //    Para probar la paginacion
    @Test
    public void should_find_all_paging() {
        PageRequest page = new PageRequest(0, 2);
        Page<Planet> all = planetRepository.findAll(page);

        Sort sort = new Sort(Sort.Direction.ASC, "episodeId")
                .and(new Sort(Sort.Direction.DESC, "releaseDate"));
        planetRepository.findAll(sort);
        System.out.println("test");
    }




}
