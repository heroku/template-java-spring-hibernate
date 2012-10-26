package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.model.Person;
import com.example.service.PersonService;

@Controller
@RequestMapping("/people")
class PersonController {

    @Qualifier("personServiceGroovyJdbcImpl")
    @Autowired
    PersonService personService;

    @RequestMapping("/")
    String listPeople(Map<String, Object> map) {

        map.person = new Person()
        map.peopleList = personService.listPeople()

        "people"
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    String addPerson(@ModelAttribute("person") Person person, BindingResult result) {

        personService.addPerson(person)

        "redirect:/people/"
    }

    @RequestMapping("/delete/{personId}")
    String deletePerson(@PathVariable("personId") Integer personId) {

        personService.removePerson(personId)

        "redirect:/people/"
    }
}
