package com.example.service;

import com.example.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceSpringJdbcImpl extends JdbcDaoSupport implements PersonService {

    @Autowired
    PersonServiceSpringJdbcImpl(DataSource dataSource) {
        this.setDataSource(dataSource);
    }

    @Override
    public void addPerson(Person person) {
        getJdbcTemplate().update(
                "INSERT INTO PERSON (FIRSTNAME,LASTNAME) VALUES (?, ?)",
                new Object[]{person.getFirstName(), person.getLastName()}
        );
    }

    @Override
    public List<Person> listPeople() {
        return getJdbcTemplate().query(
                "SELECT * FROM PERSON",
                new RowMapper<Person>() {
                    public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Person person = new Person();
                        person.setId(rs.getInt("ID"));
                        person.setFirstName(rs.getString("FIRSTNAME"));
                        person.setLastName(rs.getString("LASTNAME"));
                        return person;
                    }
                });
    }

    @Override
    public void removePerson(Integer id) {
        getJdbcTemplate().update("DELETE FROM PERSON WHERE ID = ?", id);
    }
}
