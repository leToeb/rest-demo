package com.example.restdemo;

import org.springframework.boot.context.properties.ConfigurationProperties;

//Kalsse wird num in das Application-Environment einbezogen
@ConfigurationProperties
public class Greeting {
    
    private String lastName;
    private String guitar;

    public String getLastName()
    {
        return this.lastName;
    }

    public String getGuitar()
    {
        return this.guitar;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setGuitar(String guitar)
    {
        this.guitar = guitar;
    }

}
