package cl.sample.spotidentity.repository;

import cl.sample.spotidentity.tables.Person;
import cl.sample.spotidentity.tables.PersonKey;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PersonRepository extends CassandraRepository<Person, PersonKey> {


  List<Person> findByKeyFirstName(final String firstName);
  List<Person> findByKeyFirstNameAndKeyDateOfBirthGreaterThan(
      final String firstName, final LocalDateTime dateOfBirth);


}