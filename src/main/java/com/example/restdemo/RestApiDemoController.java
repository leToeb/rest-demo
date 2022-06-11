package com.example.restdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guitar")
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


    //alternativ kann auch folgende genauere Annotation für das RequestMapping genutzt werden
    //wenn die Requestmethode nicht über eine genauere Annotion bestimmt wurde
    //@RequestMapping(value = "/guitar", method = RequestMethod.GET)
    //Iterable<Guitar> getGuitar()
    //{
    //    return guitars;
    //}

    //Value muss nicht mehr angegeben werden, weil der Endpoint schon in der Obersten Annotation der Klasse beschrieben wurde
    //@GetMapping(value = "/guitar")
    @GetMapping
    Iterable<Guitar> getGuitar()
    {
        return guitars;
    }

    //genaues Abrufen eines Datensatzes über die URI-Variable "id"
    @GetMapping(value = "/{id}")
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

    @PostMapping
    Guitar postGuitar(@RequestBody Guitar guitar)
    {
        guitars.add(guitar);
        return guitar;
        //Für POST ist es empfohlen auch einen HTTP Status für den Response zurück zu geben. Vgl PUT
    }

    @PutMapping("/{id}")
    ResponseEntity<Guitar> putGuitar(@PathVariable String id, @RequestBody Guitar guitar)
    {
        int guitarIndex = -1;

        for (Guitar g : guitars) {
            if(g.getId().equals(id))
            {
                guitarIndex = guitars.indexOf(g);
                guitars.set(guitarIndex, guitar);
            }
        }
        //Bei Put Request muss ein HTTP Statuscode für den Response inplementiert werden
        return (guitarIndex == -1) ? new ResponseEntity<Guitar>(postGuitar(guitar), HttpStatus.CREATED)  : new ResponseEntity<Guitar>(guitar, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    void deleteGuitar(@PathVariable String id)
    {
        //removeIf gibt true zurück, wenn das entfernen erfolgriech war
        guitars.removeIf(o -> o.getId().equals(id));
        //Für DELETE ist es empfohlen auch einen HTTP Status für den Response zurück zu geben. Vgl PUT
    }

}
