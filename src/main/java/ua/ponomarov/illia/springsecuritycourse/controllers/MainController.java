package ua.ponomarov.illia.springsecuritycourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.ponomarov.illia.springsecuritycourse.models.Person;

@Controller
@RequestMapping("/hello")
public class MainController {

    @GetMapping
    public String hello(){



        return "hello";
    }

}
