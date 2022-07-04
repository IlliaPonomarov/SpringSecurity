package ua.ponomarov.illia.springsecuritycourse.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.ponomarov.illia.springsecuritycourse.models.Person;
import ua.ponomarov.illia.springsecuritycourse.repo.PersonRepo;

import java.util.Optional;

@Service
public class PeopleService {

    private final PersonRepo personRepo;

    @Autowired
    public PeopleService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public Optional<Person> findByUserName(String username){
        return personRepo.findByUsername(username);
    }


}
