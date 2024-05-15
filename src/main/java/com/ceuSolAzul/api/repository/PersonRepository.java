package com.ceuSolAzul.api.repository;

import com.ceuSolAzul.api.filtro.PersonFilter;
import com.ceuSolAzul.api.models.Person;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>, JpaSpecificationExecutor<Person> {

	default Page<Person> findByFilter(final PersonFilter filter, PageRequest pageable) {
		Specification<Person> spec = createSpecification(filter);
		return findAll(spec, pageable);
	}

	private Specification<Person> createSpecification(PersonFilter filter) {
		return (root, query, cb) -> {
			List<Predicate> predicates = new ArrayList<>();

			if (filter.getName() != null) {
				predicates.add(cb.like(root.get("name"), "%" + filter.getName() + "%"));
			}
			if (filter.getType() != null) {
				predicates.add(cb.equal(root.get("type"), filter.getType()));
			}

			return cb.and(predicates.toArray(new Predicate[0]));
		};
	}
}
