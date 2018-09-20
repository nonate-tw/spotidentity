package cl.sample.spotidentity;

import cl.sample.spotidentity.repository.PersonRepository;
import cl.sample.spotidentity.tables.Person;
import cl.sample.spotidentity.tables.PersonKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.time.LocalDateTime;
import java.util.UUID;

@SpringBootApplication
public class SpotidentityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpotidentityApplication.class, args);

	}
}
