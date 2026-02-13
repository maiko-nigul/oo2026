package ee.maiko.veebipood.repository;

import ee.maiko.veebipood.entitiy.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Person findByEmail(String email);
}
