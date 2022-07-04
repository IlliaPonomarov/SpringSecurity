package ua.ponomarov.illia.springsecuritycourse.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ua.ponomarov.illia.springsecuritycourse.models.Person;
import ua.ponomarov.illia.springsecuritycourse.service.PeopleService;
import ua.ponomarov.illia.springsecuritycourse.service.PersonDetailsService;

@Component
public class PersonValidator implements Validator {


    private final PeopleService personDetailsService;

    @Autowired
    public PersonValidator(PeopleService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Person person = (Person) target;

        if (personDetailsService.findByUserName(person.getUsername()).isPresent())
            errors.rejectValue("username", "",  "This username exist, already");

    }
}
