package com.api.starwars.usecase.people;

import com.api.starwars.model.People;
import com.api.starwars.repository.PeopleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Jessica on 07/07/2017.
 */
@Service
public class FindAllPeople {
    private PeopleRepository peopleRepository;

    public FindAllPeople(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<People> execute() {

        return peopleRepository.findAll();
    }
}
