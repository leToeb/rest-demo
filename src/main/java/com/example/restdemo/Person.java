package com.example.restdemo;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;

//JPA Annotation für die Datenpank. Person ist damit eine gültige JPA Entität
@Entity
public class Person {
    
    //JPA Annotation zur kennzeichung des DB Identifiers
    @Id
    //keine final Menber bei Konstriktoren ohne Argumente
    //private final String id;
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

    //Konstruktor ohne Argumente für die JPA
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
