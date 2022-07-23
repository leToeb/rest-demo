package com.example.restdemo.control;

import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.restdemo.entity.Person;
import com.example.restdemo.entity.PersonRepository;

@Service
public class PersonService {

    private final PersonRepository repository;

    public PersonService(PersonRepository repository)
    {
        this.repository = repository;
    }

    public PersonRepository getRepository()
    {
        return repository;
    }

    public Iterable<Person> findAll() {
        return this.repository.findAll();
    }

    public Optional<Person> findById(String id) {
        return this.repository.findById(id);
    }

    public Person save(Person person) {
        return this.repository.save(person);
    }

    public Person update(String id, Person person) {
        if (!this.repository.existsById(id)) {
            return null;
        }

        person.setId(id);
        this.repository.save(person);
        return person;
    }

    public boolean delete(String id) {
        if (!this.repository.existsById(id)) {
            return false;
        }

        this.repository.deleteById(id);
        return true;
    }

    
}
