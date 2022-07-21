package com.example.restdemo.entity;

import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, String>
{
    
}