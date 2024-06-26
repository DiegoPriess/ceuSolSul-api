package com.ceuSolAzul.api.service;

import com.ceuSolAzul.api.filtro.PersonFilter;
import com.ceuSolAzul.api.models.Person;
import com.ceuSolAzul.api.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonService {

	@Autowired
	public PersonService(final PersonRepository repository) {
		this.repository = repository;
	}

	private final PersonRepository repository;

	public Person create(final Person payment) {
		return repository.save(payment);
	}

	public Optional<Person> getById(final Long id) {
		return repository.findById(id);
	}

	public Page<Person> listPage(final PersonFilter filter) {
		return repository.findByFilter(filter);
	}
}
