package ua.ponomarov.illia.springsecuritycourse.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.ponomarov.illia.springsecuritycourse.models.Person;
import ua.ponomarov.illia.springsecuritycourse.repo.PersonRepo;

@Service
public class RegistrationService {

    private final PersonRepo personRepo;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public RegistrationService(PersonRepo personRepo, PasswordEncoder passwordEncoder) {
        this.personRepo = personRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void register(Person person){

        String encodedPassword = passwordEncoder.encode(person.getPassword());
        person.setPassword(encodedPassword);
        person.setRole("ROLE_USER");
        personRepo.save(person);
    }



}
