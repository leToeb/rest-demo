package com.example.restdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/drittanbieter")
public class RestApiDrittanbieterController {
    
    public final DrittanbieterMock drittanbieterMock;

    public RestApiDrittanbieterController(DrittanbieterMock drittanbieterMock)
    {
        this.drittanbieterMock = drittanbieterMock;
    }

    @GetMapping
    DrittanbieterMock getDrittanbieterMock()
    {
        return drittanbieterMock;
    }
}
