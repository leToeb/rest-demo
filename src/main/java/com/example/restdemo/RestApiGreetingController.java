package com.example.restdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/name")
    String getGreeting()
    {
        return name;
    }

    @GetMapping("/person")
    String getNameAndPerson()
    {
        return person;
    }

    @GetMapping("/appname")
    String getAppName()
    {
        return appName;
    }
}
