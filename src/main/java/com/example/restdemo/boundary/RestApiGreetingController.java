package com.example.restdemo.boundary;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restdemo.entity.Greeting;

@RestController
@RequestMapping("/greeting")
public class RestApiGreetingController {
    
    //Vorgabewert hinter dem :
    //wird genutzt, wenn die Variable greeting-name nicht im Environment definiert ist
    @Value("${greeting-name:Greeting_Vorgabewert}")
    private String name;

    @Value("${greeting-person:${greeting-name}_Vorgabewert}")
    private String person;

    @Value("${spring.application.name:demoservice_Vorgabewert}")
    private String appName;

    //Membervariable für die Greeting Bean
    public final Greeting greeting;

    //Member Variable gür Greeting Bean wird über die Konstruktor Injection initialisiert
    public RestApiGreetingController(Greeting greeting)
    {
        this.greeting = greeting;
    }

    @GetMapping("/name")
    String getGreeting()
    {
        return name;
    }

    @GetMapping("/lastName")
    String getLastName()
    {
        //Eigenschaft wird von der ConfigurationPropertie-Bean Greeting verwaltet
        return greeting.getLastName();
    }

    @GetMapping("/lastPerson")
    String getNameAndPerson()
    {
        return greeting.getLastPerson();
    }

    @GetMapping("/appname")
    String getAppName()
    {
        return appName;
    }
}
