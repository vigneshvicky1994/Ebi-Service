package com.vignesh.controller;

import com.vignesh.exception.PersonNotFoundException;
import com.vignesh.model.Person;
import com.vignesh.service.PersonService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//creating RestController
@RestController
@RequestMapping("/api")
public class PersonController
{
    Logger logger = LoggerFactory.getLogger(PersonController.class);
//autowired the PersonService class
@Autowired
PersonService personService;
//creating a get mapping that retrieves all the persons detail from the database
@GetMapping("/person")
@ApiOperation( value = "Find all Persons", notes = "retrieves all the persons detail from the database", response = Person.class)
private List<Person> getAllPerson()
{
return personService.getAllPerson();
}


//creating a get mapping that retrieves the detail of a specific person
@GetMapping("/person/{id}")
@ApiOperation( value = "Find Person by id", notes = "retrieves the details of a specific person")
private Person getPerson(@PathVariable("id") int id)
{
return personService.getPersonById(id);
}



//creating a delete mapping that deletes a specific person
@DeleteMapping("/person/{id}")
@ApiOperation( value = "Delete Person by id", notes = "delete a specific person")
private void deletePerson(@PathVariable("id") int id)
{
    Person person = personService.getPersonById(id);
    if(person == null){
        throw new PersonNotFoundException();
    }
    try {
        personService.delete(id);
    }
    catch(Exception e){
        logger.error(e.toString());
    }
}

//creating a delete mapping that deletes a specific person
@DeleteMapping("/person")
@ApiOperation( value = "Delete Person by id", notes = "delete a specific person")
private void deletePersonByParamId(@RequestParam(required = true) int id)
{
    Person person = personService.getPersonById(id);
    if(person == null){
        throw new PersonNotFoundException();
    }
    try {
        personService.delete(id);
    }
    catch(Exception e){
        logger.error(e.toString());
    }
}


//creating post mapping that post the person detail in the database
@PostMapping("/person")
@ApiOperation( value = "Save/Update Person", notes = "Save/Update the person detail in the database", response = Person.class)
private int savePerson(@RequestBody Person person)
{
    personService.saveOrUpdate(person);
    return person.getId();
}

}
