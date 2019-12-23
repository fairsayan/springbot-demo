package by.wink.springbot.service;

import by.wink.springbot.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
public class PersonService {
    static private final List<Person> list = new ArrayList<>(
            Arrays.asList(
                    new Person(1, "Domenico"),
                    new Person(2, "Pasquale" )
            )
    );

    @Autowired
    public PersonService() {
    }

    public Optional<Person> selectPersonById(Integer id) {
        return list.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();
    }
}
