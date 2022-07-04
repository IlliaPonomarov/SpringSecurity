package ua.ponomarov.illia.springsecuritycourse.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.ponomarov.illia.springsecuritycourse.models.Person;
import ua.ponomarov.illia.springsecuritycourse.security.PersonDetails;

import java.security.Principal;

@Controller
@RequestMapping("/hello")
public class MainController {

    @GetMapping
    public String hello(){
        return "hello";
    }

    @GetMapping("/admin")
    public String adminPage(){
        return "admin|";
    }

    @GetMapping("/show")
    public String show(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        PersonDetails personDetails = (PersonDetails)authentication.getPrincipal();

        System.out.println(personDetails.getPerson().getUsername());

        return "hello";
    }

}
