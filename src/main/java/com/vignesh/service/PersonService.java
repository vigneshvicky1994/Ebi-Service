package com.vignesh.service;

import com.vignesh.model.Person;
import com.vignesh.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//defining the business logic
@Service
public class PersonService
{
@Autowired
PersonRepository personRepository;
//getting all Person records
public List<Person> getAllPerson()
{
List<Person> persons = new ArrayList<Person>();
    personRepository.findAll().forEach(person -> persons.add(person));
return persons;
}
//getting a specific record
public Person getPersonById(int id)
{
return personRepository.findById(id).get();
}
public void saveOrUpdate(Person person)
{
    personRepository.save(person);
}
//deleting a specific record
public void delete(int id) 
{
    personRepository.deleteById(id);
}
}