package com.example.restdemo;

import org.springframework.data.repository.CrudRepository;

interface GuitarRepository extends CrudRepository<Guitar, String>
{
    
}