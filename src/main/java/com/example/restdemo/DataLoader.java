package com.example.restdemo;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class DataLoader {

    private final GuitarRepository guitarRepository;

    public DataLoader(GuitarRepository guitarRepository){

        this.guitarRepository = guitarRepository;
    }

    @PostConstruct
    private void loadData(){

        this.guitarRepository.saveAll(List.of(
            new Guitar("Les Paul"),
            new Guitar("Telecaster"),
            new Guitar("Stratocaster"),
            new Guitar("Firebird"),
            new Guitar("T-Bird"),
            new Guitar("Guitar aus dem DataLoader")
        ));

    }
    
}
