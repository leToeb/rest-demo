package com.example.restdemo;

import org.springframework.data.repository.CrudRepository;

interface PersonRepository extends CrudRepository<Person, String>
{
    
}