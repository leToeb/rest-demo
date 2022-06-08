package com.example.restdemo;

import java.util.UUID;

public class Guitar {
    
    public final String id;
    public String name;

    public Guitar(String id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public Guitar(String name)
    {
        this(UUID.randomUUID().toString(), name);
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

}
