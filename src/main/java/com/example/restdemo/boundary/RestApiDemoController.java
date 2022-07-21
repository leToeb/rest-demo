package com.example.restdemo.boundary;

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

import com.example.restdemo.control.PersonService;
import com.example.restdemo.entity.Person;
import com.example.restdemo.entity.PersonRepository;

@RestController
@RequestMapping("/person")
public class RestApiDemoController {
    
    //Zugriff auf die DB über die Repo-API
    private final PersonRepository personRepository;

    //das PersonRepository ist eine Spring Bean, die automatisch verdrathet wird
    public RestApiDemoController(PersonService personRepository)
    {
        this.personRepository = personRepository.getRepository();
    }

    //alternativ kann auch folgende genauere Annotation für das RequestMapping genutzt werden
    //wenn die Requestmethode nicht über eine genauere Annotion bestimmt wurde
    //@RequestMapping(value = "/person", method = RequestMethod.GET)
    //Iterable<Person> getPerson()
    //{
    //    return person;
    //}

    //Value muss nicht mehr angegeben werden, weil der Endpoint schon in der obersten Annotation der Klasse beschrieben wurde
    //@GetMapping(value = "/person")
    @GetMapping
    Iterable<Person> getPerson()
    {
        return personRepository.findAll();
    }

    //genaues Abrufen eines Datensatzes über die URI-Variable "id"
    @GetMapping(value = "/{id}")
    Optional<Person> getGuiterById(@PathVariable String id)
    {
        return personRepository.findById(id);
    }

    @PostMapping
    Person postPerson(@RequestBody Person person)
    {
        //Für POST ist es empfohlen auch einen HTTP Status für den Response zurück zu geben. Vgl PUT
        return personRepository.save(person);
    }

    @PutMapping("/{id}")
    ResponseEntity<Person> putPerson(@PathVariable String id, @RequestBody Person person)
    {
        //Bei Put Request muss ein HTTP Statuscode für den Response inplementiert werden          
        return (personRepository.existsById(id) ? new ResponseEntity<Person>(personRepository.save(person), HttpStatus.OK)  : new ResponseEntity<Person>(personRepository.save(person), HttpStatus.CREATED));
    }

    @DeleteMapping("/{id}")
    void deletePerson(@PathVariable String id)
    {
        //removeIf gibt true zurück, wenn das Entfernen erfolgriech war
        //Für DELETE ist es empfohlen auch einen HTTP Status für den Response zurück zu geben. Vgl PUT  
        personRepository.deleteById(id);
    }

}
