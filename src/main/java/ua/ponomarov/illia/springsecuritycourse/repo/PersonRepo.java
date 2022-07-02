package ua.ponomarov.illia.springsecuritycourse.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.ponomarov.illia.springsecuritycourse.models.Person;

import java.util.Optional;

public interface PersonRepo extends JpaRepository<Person, Integer> {

    Optional<Person> findByUsername(String username);
}
