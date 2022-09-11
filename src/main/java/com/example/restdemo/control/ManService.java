package com.example.restdemo.control;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.restdemo.entity.Man;
import com.example.restdemo.entity.ManRepository;

@Service
public class ManService {
    
    private final ManRepository repository;

    public ManService(ManRepository repository)
    {
        this.repository = repository;
    }

    public ManRepository getRepository()
    {
        return repository;
    }

    public Iterable<Man> findAll() {
        return this.repository.findAll();
    }

    public Optional<Man> findById(Long id) {
        return this.repository.findById(id);
    }

    public Man save(Man man) {
        return this.repository.save(man);
    }

    public Man update(Long id, Man man) {
        if (!this.repository.existsById(id)) {
            return null;
        }

        man.setId(id);
        this.repository.save(man);
        return man;
    }

    public boolean delete(Long id) {
        if (!this.repository.existsById(id)) {
            return false;
        }

        this.repository.deleteById(id);
        return true;
    }
}
