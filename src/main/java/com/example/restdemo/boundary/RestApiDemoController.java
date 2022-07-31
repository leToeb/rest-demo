package com.example.restdemo.boundary;

import java.net.URI;
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
    private final PersonService personService;

    public RestApiDemoController(PersonService personService)
    {
        this.personService = personService;
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
    ResponseEntity<Iterable<Person>> getPerson()
    {
        return ResponseEntity.ok(personService.findAll());
    }

    //genaues Abrufen eines Datensatzes über die URI-Variable "id"
    @GetMapping(value = "/{id}")
    ResponseEntity<Person> getGuiterById(@PathVariable String id)
    {
        Optional<Person> personOptional = this.personService.findById(id);
        return personOptional.isPresent() ? ResponseEntity.ok(personOptional.get()) : ResponseEntity.notFound().build();
    }

    //Für POST ist es empfohlen auch einen HTTP Status für den Response zurück zu geben. Vgl PUT
    //hier wird der Created Status über die entsprechende Methode von ResponseEntity erstellt
    @PostMapping
    ResponseEntity<Person> postPerson(@RequestBody Person person)
    {
        return ResponseEntity.created(URI.create(String.format("/person/%s", person.getId())))
                .body(personService.save(person));
    }

    @PutMapping("/{id}")
    ResponseEntity<Person> putPerson(@PathVariable String id, @RequestBody Person person)
    {
        //Bei Put Request muss ein HTTP Statuscode für den Response inplementiert werden          
        Person updatedPerson = this.personService.update(id, person);
        return updatedPerson == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(updatedPerson);
    }

    @DeleteMapping("/{id}")
    ResponseEntity deletePerson(@PathVariable String id)
    {
        return this.personService.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

}
