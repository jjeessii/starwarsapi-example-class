package com.api.starwars.usecase.people;

import com.api.starwars.model.People;
import com.api.starwars.repository.PeopleRepository;
import org.springframework.stereotype.Service;

/**
 * Created by Jessica on 07/07/2017.
 */
@Service
public class FindPeople {
    private PeopleRepository peopleRepository;

    public FindPeople(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public People execute(Long id) {

        return peopleRepository.findOne(id);
    }
}
