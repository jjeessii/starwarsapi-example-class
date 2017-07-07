package com.api.starwars.rest;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Jessica on 07/07/2017.
 */
@Controller
@RequestMapping(path = "/links")
public class LinkController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<ResourceSupport> allLinks() {
        Link swapiLink = new Link("http://swapi.co");
        Link planetsLink = new Link("http://localhost:8080/planets");
        ResourceSupport result = new ResourceSupport();
        result.add(swapiLink);
        result.add(planetsLink);
        return new ResponseEntity<ResourceSupport>(result, HttpStatus.OK);
    }
}
