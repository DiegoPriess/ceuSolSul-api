package com.ceuSolAzul.api.controller;

import com.ceuSolAzul.api.enums.TypeRegister;
import com.ceuSolAzul.api.filtro.PersonFilter;
import com.ceuSolAzul.api.models.Person;
import com.ceuSolAzul.api.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/person")
@CrossOrigin
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
                             @PathVariable Integer size,
                             @RequestParam(required = false) String name,
                             @RequestParam(required = false) TypeRegister type,
                             @RequestParam(required =  false, defaultValue = "id") String sortBy,
                             @RequestParam(required = false, defaultValue = "asc") String sortDir       
    		) {	
    	
        Sort sort = Sort.by(Sort.Direction.ASC, sortBy);
        PageRequest pageable = PageRequest.of(page, size, sort);
        return service.listPage(PersonFilter.builder()
                                            .page(page)
                                            .size(size)
                                            .name(name)
                                            .type(type)
                                            .build(), pageable
                                            );
    }
}
