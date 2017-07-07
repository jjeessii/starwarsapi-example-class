package com.api.starwars.rest;

import com.api.starwars.model.People;
import com.api.starwars.usecase.people.FindAllPeople;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Jessica on 07/07/2017.
 */
@Controller
@RequestMapping(path = "/people")
@AllArgsConstructor
public class PeopleController {
    private FindAllPeople findAllPeople; //al poner el allargsconstructor lombok me mete el constructor

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<People>> findAll() {
        List<People> people = findAllPeople.execute();
        return new ResponseEntity<List<People>>(people, HttpStatus.OK);
    }

//    @RequestMapping(method = RequestMethod.POST)
//    public ResponseEntity<People> save(@)
}
