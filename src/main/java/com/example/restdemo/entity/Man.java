package com.example.restdemo.entity;

import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Man {
    
    @Id
    private Long id;
    private String name, firstname;
    private int age;

    public Man ()
    {
        id = getRandomLong();
    }

    public Man (String name)
    {
        this.id = getRandomLong();
        this.name = name;
    }

    public Man (String name, String firstname)
    {
        this.id = getRandomLong();
        this.name = name;
        this.firstname = firstname;
    }

    
    public Man (String name, String firstname, int age)
    {
        this.id = getRandomLong();
        this.name = name;
        this.firstname = firstname;
        this.age = age;
    }

    private static Long getRandomLong(){
        Random rd = new Random();
        return rd.nextLong();
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;   
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public String getFirstname()
    {
        return this.firstname;   
    }

    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public int getAge()
    {
        return this.age;
    }

}
