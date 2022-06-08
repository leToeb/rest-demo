package com.example.restdemo;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestApiDemoController {
    
    private List<Guitar> guitars = new ArrayList<>();

    public RestApiDemoController()
    {
        guitars.addAll(List.of(
            new Guitar("Les Paul"),
            new Guitar("Telecaster"),
            new Guitar("Stratocaster"),
            new Guitar("Firebird"),
            new Guitar("T-Bird")
        ));
    }


    @RequestMapping(value = "/guitar", method = RequestMethod.GET)
    Iterable<Guitar> getGuitar()
    {
        return guitars;
    }

    //alternativ kann auch folgende genauere Annotation für das RequestMapping genutzt werden
    @GetMapping(value = "/guitar2")
    Iterable<Guitar> getGuitar2()
    {
        return guitars;
    }

    //genaues Abrufen eines Datensatzes über die URI-Variable "id"
    @GetMapping(value = "/guitar/{id}")
    Optional<Guitar> getGuiterById(@PathVariable String id)
    {
        for (Guitar guitar : guitars) {
            if(guitar.getId().equals(id))
            {
                return Optional.of(guitar);
            }
        }

        return Optional.empty();
    }


}
