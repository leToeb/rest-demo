package com.example.restdemo.boundary;

import java.net.URI;
import java.util.Optional;

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

@RestController
@RequestMapping("/person")
public class RestApiDemoController {
    
    private final PersonService personService;

    public RestApiDemoController(PersonService personService)
    {
        this.personService = personService;
    }

    @GetMapping
    ResponseEntity<Iterable<Person>> getPerson()
    {
        return ResponseEntity.ok(personService.findAll());
    }

    @GetMapping(value = "/{id}")
    ResponseEntity<Person> getGuiterById(@PathVariable String id)
    {
        Optional<Person> personOptional = this.personService.findById(id);
        return personOptional.isPresent() ? ResponseEntity.ok(personOptional.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping
    ResponseEntity<Person> postPerson(@RequestBody Person person)
    {
        return ResponseEntity.created(URI.create(String.format("/person/%s", person.getId())))
                .body(personService.save(person));
    }

    @PutMapping("/{id}")
    ResponseEntity<Person> putPerson(@PathVariable String id, @RequestBody Person person)
    {
        Person updatedPerson = this.personService.update(id, person);
        return updatedPerson == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(updatedPerson);
    }

    @DeleteMapping("/{id}")
    ResponseEntity deletePerson(@PathVariable String id)
    {
        return this.personService.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

}
