package com.example.restdemo.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {
    
    @Id
    private String id;
    private String name;

    public Person(String id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public Person(String name)
    {
        this(UUID.randomUUID().toString(), name);
    }

    public Person()
    {

    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;   
    }

    public String getId()
    {
        return this.id;
    }

    public void setId(String id)
    {
        this.id  = id;
    }

}
