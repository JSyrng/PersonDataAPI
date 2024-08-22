package com.persondataapi.controller;

import com.persondataapi.model.Person;
import com.persondataapi.service.PersonService;
import com.persondataapi.utils.CsvDataHandler;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    private final PersonService personService;
    private final CsvDataHandler csvDataHandler = new CsvDataHandler();

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/")
    public List<Person> home() {
        return personService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Person> getById(@PathVariable("id") long id) {
        return personService.getById(id);
    }

    @PostMapping("/create")
    public void create(@RequestBody Person person) {
        List<Person> singlePerson = new ArrayList<>();
        singlePerson.add(person);

        csvDataHandler.savePersonToCsv(singlePerson.get(0));
    }

    @GetMapping("/persons/color/{colour}")
    public List<Person> getPersonsWithColour(@PathVariable("colour") String colour){
        return personService.getByColour(colour);
    }
}
