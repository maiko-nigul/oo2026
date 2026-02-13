package ee.maiko.veebipood.controller;

import ee.maiko.veebipood.dto.PersonLoginRecordDto;
import ee.maiko.veebipood.entitiy.Person;
import ee.maiko.veebipood.repository.PersonRepository;
import ee.maiko.veebipood.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    // Dependency Injection. Kui luuakse see klass (PersonController), seotakse ära samala ajal temaga kõik allolvad muutujad
    // Injectiga võib ka läbi ka constructorite
    @Autowired
    private PersonService personService;

    //localhost:8080/products
    @GetMapping("persons")
    public List<Person> getPersons(){
        return personRepository.findAll();
    }

    @DeleteMapping("persons/{id}")
    public List<Person> deletePerson(@PathVariable Long id){
        personRepository.deleteById(id); // kustutan
        return personRepository.findAll(); // uuenenud seis
    }
    @PostMapping("signup")
    public Person signup(@RequestBody Person person){
        personService.validate(person);
        return personRepository.save(person);
    }
    @PostMapping("login")
    public Person login(@RequestBody PersonLoginRecordDto personDto){
        Person dbPerson = personRepository.findByEmail(personDto.email());
        if (dbPerson ==null){
            throw new RuntimeException("Invalid email");
        }
        if (!dbPerson.getPassword().equals(personDto.password())){
            throw new RuntimeException("Invalid passowrd");
        }
        return dbPerson;
    }

}
