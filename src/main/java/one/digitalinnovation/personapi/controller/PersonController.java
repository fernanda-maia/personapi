package one.digitalinnovation.personapi.controller;

import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.service.PersonService;
import one.digitalinnovation.personapi.dto.MessageResponseDTO;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;


import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }
}
