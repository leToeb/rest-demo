package com.example.restdemo.control;

import org.springframework.stereotype.Service;

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

    
}
