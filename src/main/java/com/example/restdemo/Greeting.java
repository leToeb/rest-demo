package com.example.restdemo;

import org.springframework.boot.context.properties.ConfigurationProperties;

//Kalsse wird num in das Application-Environment einbezogen
@ConfigurationProperties(prefix = "greeting")
public class Greeting {
    
    private String lastName;
    private String lastGuitar;

    public String getLastName()
    {
        return this.lastName;
    }

    public String getLastGuitar()
    {
        return this.lastGuitar;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setLastGuitar(String guitar)
    {
        this.lastGuitar = guitar;
    }

}
