package com.api.starwars.usecase.people;

import com.api.starwars.repository.PeopleRepository;
import org.springframework.stereotype.Service;

/**
 * Created by Jessica on 07/07/2017.
 */
@Service
public class DeletePeople {
    private PeopleRepository peopleRepository;

    public DeletePeople(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public void execute(Long id) {

        peopleRepository.delete(id);
    }
}
