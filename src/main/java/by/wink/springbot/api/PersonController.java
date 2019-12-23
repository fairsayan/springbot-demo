package by.wink.springbot.api;

import by.wink.springbot.model.Person;
import by.wink.springbot.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/persons")
@RestController
public class PersonController {
    private final PersonService person;

    @Autowired
    public PersonController(PersonService person) {
        this.person = person;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable("id") Integer id) {
        return person.selectPersonById(id).orElse(null);
    }
}
