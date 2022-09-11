package com.example.restdemo.entity;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class DataLoaderMan {

    private final ManRepository repository;

    public DataLoaderMan(ManRepository repository){

        this.repository = repository;
    }

    @PostConstruct
    private void loadData(){

        this.repository.saveAll(List.of(
            new Man("Schmitt", "Paul", 23),
            new Man("Schmidt", "Peter", 78),
            new Man("Mayer", "Inge", 56),
            new Man("Schuster", "Hans", 89),
            new Man("Herold", "Marie", 34),
            new Man("Meier", "Person X aus dem DataLoader", 45)
        ));

    }
    
}
