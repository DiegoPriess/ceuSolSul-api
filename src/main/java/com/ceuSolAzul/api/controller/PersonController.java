package com.ceuSolAzul.api.controller;

import com.ceuSolAzul.api.models.Person;
import com.ceuSolAzul.api.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    public PersonController(final PersonService service) {
        this.service = service;
    }

    private final PersonService service;

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody Person person) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(person));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Person>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(this.service.getById(id));
    }

    @GetMapping("/{page}/{size}")
    public Page<Person> list(@PathVariable Integer page,
                             @PathVariable Integer size) {
        return service.listPage(page, size);
    }
}
