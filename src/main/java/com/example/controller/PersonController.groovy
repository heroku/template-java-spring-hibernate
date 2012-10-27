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
import com.example.service.PersonService
import org.springframework.web.bind.annotation.ResponseBody
import groovy.json.JsonBuilder
import groovy.xml.MarkupBuilder;

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

    @RequestMapping(value = "/status/json", method = RequestMethod.GET, produces="application/json")
    @ResponseBody
    public String getJson() {
        def json = new JsonBuilder()
        json.status {
            date new Date()
            peopleCount personService.listPeople().size()
        }
        json.toPrettyString()
    }

    @RequestMapping(value = "/xml", method = RequestMethod.GET, produces="application/xml")
    @ResponseBody
    public String getXml() {
        StringWriter writer = new StringWriter()
        def xml = new MarkupBuilder(writer)

        xml.people {
            personService.listPeople().each { Person p ->
                person {
                    id p.id
                    firstName p.firstName
                    lastName p.lastName
                }
            }
        }
        writer.toString()
    }
}
