package com.api.starwars.repository;

import com.api.starwars.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by accesoeps on 30/06/17.
 */
@Repository
public interface FilmRepository extends JpaRepository<Film, Long>, CustomFilmRepository{

    List<Film> findAllByOrderByEpisodeIdAsc();
    List<Film> findAllByReleaseDateIsGreaterThanEqual(Date releaseDate);

    @Query("select f from Film f where f.people.size = (select min(f2.people.size) from Film f2)")
    List<Film> findAllByMinFilms();

    @Query("select f from Film f where f.people.size = (select max(f2.people.size) from Film f2)")
    List<Film> findAllByMaxFilms();

    @Query("select f from Film f join f.people p where p.name = name")
    List<Film> findAllByPeopleContains(@Param("name") String name);
}
