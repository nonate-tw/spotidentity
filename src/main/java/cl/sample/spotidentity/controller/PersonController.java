package cl.sample.spotidentity.controller;

import cl.sample.spotidentity.repository.PersonRepository;
import cl.sample.spotidentity.tables.Person;
import cl.sample.spotidentity.tables.PersonKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraAdminOperations;
import org.springframework.data.cassandra.core.cql.CqlIdentifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.UUID;

@RestController
public class PersonController {

    private final String DATA_TABLE_NAME = "people_by_first_name";

    /*@Autowired
    private CassandraAdminOperations adminTemplate;*/

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/person")
    public Person getPerson() {
        //adminTemplate.createTable(true, CqlIdentifier.of(DATA_TABLE_NAME), Person.class, new HashMap<String, Object>());
        LocalDateTime birth = LocalDateTime.now();
        PersonKey personKey = new PersonKey("Test", birth, UUID.randomUUID());
        Person person = new Person(personKey, "Test", 200.0);

        System.out.println(person.toString());
        personRepository.save(person);

        Person test = personRepository.findByKeyFirstName("Test").get(0);
        System.out.println(test.toString());

        return test;
    }
}
