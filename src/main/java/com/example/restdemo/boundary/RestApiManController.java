package com.example.restdemo.boundary;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.restdemo.control.ManService;
import com.example.restdemo.entity.Man;

@RestController
@RequestMapping("/man")
public class RestApiManController {

    private final ManService manService;

    public RestApiManController(ManService manService)
    {
        this.manService = manService;
    }

    @GetMapping
    ResponseEntity<Iterable<Man>> getMan()
    {
        return ResponseEntity.ok(manService.findAll());
    }
    
}
