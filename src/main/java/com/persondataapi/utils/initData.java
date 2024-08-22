package com.persondataapi.utils;

import com.persondataapi.model.Person;
import com.persondataapi.service.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class initData implements CommandLineRunner {

    private final CsvDataHandler csvDataHandler = new CsvDataHandler();

    private final PersonService personService;

    public initData(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public void run(String... args) {
        List<Person> people = csvDataHandler.loadData();
        personService.saveAll(people);
    }

}
