package com.api.starwars.repository;

import com.api.starwars.model.Film;
import com.api.starwars.model.People;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by accesoeps on 30/06/17.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
//@AllArgsConstructor
public class FilmRepositoryTest {

    //injeccion de dependencias
    @Autowired
    private FilmRepository filmRepository;

//    si ponemos @AllArgsConstructor las lineas de abajo no hace falta ponerlas
//    public PlanetRepositoryTest(PlanetRepository planetRepository){
//        this.planetRepository = planetRepository;
//    }

    @Test
    public void should_find_all_max_people() throws Exception {
        List<Film> filmList = filmRepository.findAllByOrderByEpisodeIdAsc();
        Assert.assertNotNull(filmList);
    }

//    @Test
//    public void should_print_all_films() {
//        List<Film> all = filmRepository.findAll();
//        all.stream().forEach(System.out::println);
//    }

    @Test
    public void should_print_all_films() {
        List<Film> all = filmRepository.findAll();
        all.stream().forEach(f -> filmRepository.logFilm(f));
    }

}
