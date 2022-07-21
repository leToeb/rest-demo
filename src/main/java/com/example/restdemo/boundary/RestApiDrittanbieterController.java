package com.example.restdemo.boundary;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restdemo.entity.DrittanbieterMock;

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
