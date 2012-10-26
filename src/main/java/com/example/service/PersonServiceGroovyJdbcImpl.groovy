package com.example.service;


import com.example.model.Person
import groovy.sql.Sql
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import javax.sql.DataSource

@Service
public class PersonServiceGroovyJdbcImpl implements PersonService {

    @Autowired
    DataSource dataSource;

    @Override
    public void addPerson(Person person) {
        new Sql(dataSource).execute('INSERT INTO PERSON(FIRSTNAME,LASTNAME) VALUES (?,?)',
                [person.firstName, person.lastName])
    }

    @Override
    public List<Person> listPeople() {
        List<Person> people = []

        new Sql(dataSource).eachRow("SELECT * FROM PERSON") {
            people << new Person(id: it.id, firstName: it.firstName, lastName: it.lastName)
        }

        return people;
    }

    @Override
    public void removePerson(Integer id) {
        new Sql(dataSource).execute("DELETE FROM PERSON WHERE PERSON.ID=$id");
    }
}
