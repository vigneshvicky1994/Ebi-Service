package com.vignesh.repository;

import com.vignesh.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Integer>
{
}
