package com.example.restdemo.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;

//Kalsse wird num in das Application-Environment einbezogen
@ConfigurationProperties(prefix = "greeting")
public class Greeting {
    
    private String lastName;
    private String lastPerson;

    public String getLastName()
    {
        return this.lastName;
    }

    public String getLastPerson()
    {
        return this.lastPerson;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setLastPerson(String Person)
    {
        this.lastPerson = Person;
    }

}
