package com.persondataapi.service;


import com.persondataapi.model.Person;
import com.persondataapi.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Optional<Person> getById(Long id) {
        return personRepository.findById(id);
    }

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public void saveAll(List<Person> persons) {
        personRepository.saveAll(persons);
    }

    public List<Person> getByColour(String colour) {
        return personRepository.findByColour(colour);
    }

}
