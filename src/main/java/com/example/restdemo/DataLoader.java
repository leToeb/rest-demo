package com.example.restdemo;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    private final PersonRepository personRepository;

    public DataLoader(PersonRepository personRepository){

        this.personRepository = personRepository;
    }

    @PostConstruct
    private void loadData(){

        this.personRepository.saveAll(List.of(
            new Person("Paul"),
            new Person("Peter"),
            new Person("Inge"),
            new Person("Hans"),
            new Person("Marie"),
            new Person("Person X aus dem DataLoader")
        ));

    }
    
}
