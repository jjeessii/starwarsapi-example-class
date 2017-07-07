package com.api.starwars.usecase.people;

import com.api.starwars.model.People;
import com.api.starwars.repository.PeopleRepository;
import org.springframework.stereotype.Service;

/**
 * Created by Jessica on 07/07/2017.
 */
@Service
public class SavePeople {
    private PeopleRepository peopleRepository;

    public SavePeople(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public People execute(People people) {
        if(people == null) throw new NullPointerException("planet is null");
        return peopleRepository.save(people);
    }
}
