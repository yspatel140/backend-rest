package com.example.backendrest.controller;

import com.example.backendrest.model.Person;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BackendController {
    private Map<String, Person> personMap = new HashMap<>();
    {
        personMap.put("Yogesh", new Person("Yogesh", 31, "London"));
        personMap.put("Raj", new Person("Raj", 35, "Mumbai"));
        personMap.put("Tom", new Person("Tom", 34, "Paris"));
    }

    @RequestMapping(value = "/person/{name}", method = RequestMethod.GET)
    public Person personByName(@PathVariable String name) {
        return personMap.get(name);
    }

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public List<Person> personList() {
        return new ArrayList<>(personMap.values());
    }
}
